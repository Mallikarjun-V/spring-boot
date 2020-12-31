package com.learn.apiservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learn.apiservice.model.User;

@Service
public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	private RestTemplate restTemplate = new RestTemplate();

	@Value("${app.db-service.host}")
	private String dbServiceName;

	public List<User> getUsers() {
		logger.info("DB Service : {}", dbServiceName);
		String url = "http://" + dbServiceName + "/users";
		return restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
		}).getBody();
	}
}
