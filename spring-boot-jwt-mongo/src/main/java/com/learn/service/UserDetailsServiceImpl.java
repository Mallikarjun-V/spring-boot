package com.learn.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.model.Role;
import com.learn.model.User;
import com.learn.respository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private static final Logger logger  = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username : " + username));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getUserAuthority(user.getRole()));
	}

	private List<GrantedAuthority> getUserAuthority(Role userRole) {
		logger.info("User role : " + userRole.name());
		return Arrays.asList(new SimpleGrantedAuthority(userRole.name()));
	}
}
