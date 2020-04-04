package com.learn.adminserver.config;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import de.codecentric.boot.admin.server.config.AdminServerProperties;

@Profile("prod")
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecuritySecureConfig.class);
	private final AdminServerProperties adminServer;

	public SecuritySecureConfig(AdminServerProperties adminServer) {
		LOGGER.info("Loading secure config");
		this.adminServer = adminServer;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.info("Loading secure config");
		SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
		successHandler.setTargetUrlParameter("redirectTo");
		successHandler.setDefaultTargetUrl(this.adminServer.path("/"));

		http.authorizeRequests((authorizeRequests) -> authorizeRequests.antMatchers(this.adminServer.path("/assets/**")) // Grants
																															// public
																															// access
																															// to
																															// all
																															// static
																															// assets
																															// and
																															// the
																															// login
																															// page.

				.permitAll().antMatchers(this.adminServer.path("/login")).permitAll().anyRequest().authenticated())// Every
																													// other
																													// request
																													// must
																													// be
																													// authenticated.
				.formLogin((formLogin) -> formLogin.loginPage(this.adminServer.path("/login"))
						.successHandler(successHandler).and()) // Configures login and logout.
				.logout((logout) -> logout.logoutUrl(this.adminServer.path("/logout")))
				.httpBasic(Customizer.withDefaults())// Enables HTTP-Basic support. This is needed for the Spring Boot
														// Admin Client to register.
				.csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())// Enables
																										// CSRF-Protection
																										// using Cookies

						.ignoringRequestMatchers(
								new AntPathRequestMatcher(this.adminServer.path("/instances"),
										HttpMethod.POST.toString()), // Disables CSRF-Protection for the endpoint the
																		// Spring Boot Admin Client uses to
																		// (de-)register.
								new AntPathRequestMatcher(this.adminServer.path("/instances/*"),
										HttpMethod.DELETE.toString()), // Disables CSRF-Protection for the endpoint the
																		// Spring Boot Admin Client uses to
																		// (de-)register.
								new AntPathRequestMatcher(this.adminServer.path("/actuator/**"))))// Disables
																									// CSRF-Protection
																									// for the actuator
																									// endpoints.
				.rememberMe((rememberMe) -> rememberMe.key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600));
	}

	// Required to provide UserDetailsService for "remember functionality"
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("user").password("{noop}password").
	 * roles("USER"); }
	 */
}
