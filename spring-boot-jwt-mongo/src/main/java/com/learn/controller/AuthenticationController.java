package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.config.jwt.JwtUtil;
import com.learn.model.JwtRequest;
import com.learn.model.JwtResponse;

@RestController()
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@RequestMapping(method = RequestMethod.POST, value = "/authenticate")
	public ResponseEntity<?> unthenticateUser(@RequestBody JwtRequest authenticationRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
				authenticationRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails userDetails = (UserDetails)authentication.getPrincipal();
		String jwt = jwtUtil.generateJwtToken(userDetails);
		String role = userDetails.getAuthorities().stream().findAny().get().getAuthority();
		return ResponseEntity.ok(new JwtResponse(jwt,"" , userDetails.getUsername(), "email", role));
	}
}
