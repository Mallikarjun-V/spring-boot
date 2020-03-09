package com.learn.springbooteurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author MALLIKARJUN
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServiceApplication.class, args);
	}

}
