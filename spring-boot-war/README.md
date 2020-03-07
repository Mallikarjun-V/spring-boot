To deploy Spriing Boot application to an existing Tomcat installation.

change Maven packaging from jar to war.

Finally, add a web entry point into your application. Spring configures almost everything for you using Servlet 3 Java configuration. You just need to give it the opportunity. Modify your Application


	package com.learn;

	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
	import org.springframework.boot.builder.SpringApplicationBuilder;
	import org.springframework.boot.context.web.SpringBootServletInitializer;

	@SpringBootApplication
	public class SpringBootWarApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWarApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWarApplication.class);
    }

}