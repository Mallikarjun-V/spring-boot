package com.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.config.JwtTokenUtil;
import com.learn.model.JwtRequest;
import com.learn.model.JwtResponse;
import com.learn.service.JwtUserDetailsService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
public class HelloWorldController {
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        
        final String token = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @ApiImplicitParams(@ApiImplicitParam(name = "Authorization", value = "Access Token", required = true, dataType = "String", paramType = "header", example = "Bearer access_token"))
    public String hello(@RequestHeader(value = "Authorization") String headerStr) {
        return "Hello World";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() throws Exception {
        
        return ResponseEntity.ok("Testing");
    }
}
