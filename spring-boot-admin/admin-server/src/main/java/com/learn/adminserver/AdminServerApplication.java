package com.learn.adminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.learn.adminserver.config.SecurityPermitAllConfig;
import com.learn.adminserver.config.SecuritySecureConfig;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableAdminServer
@Import({ SecurityPermitAllConfig.class, SecuritySecureConfig.class })
public class AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerApplication.class, args);
	}

}
