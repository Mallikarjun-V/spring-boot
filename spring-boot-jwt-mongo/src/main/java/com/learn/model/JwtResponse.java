package com.learn.model;

public class JwtResponse {
	private String token;
	private static String type = "Bearer";
	private String id;
	private String username;
	private String email;
	private String role;

	public JwtResponse(String token, String id, String username, String email, String role) {
		this.token = token;
		this.id = id;
		this.setUsername(username);
		this.setEmail(email);
		this.setRole(role);
	}

	public String getToken() {
		return token;
	}

	public String getType() {
		return type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
