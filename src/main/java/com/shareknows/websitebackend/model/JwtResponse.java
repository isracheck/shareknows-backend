package com.shareknows.websitebackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtResponse extends BasicResponse {

	private static final String TOKEN_TYPE = "Bearer";

	private final String accessToken;
	private final String username;
	private final String authority;

	public JwtResponse(String accessToken, UserDetails user, GrantedAuthority authority) {
		super("User loaded");
		this.username = user.getUsername();
		this.authority = authority.getAuthority();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getTokenType() {
		return TOKEN_TYPE;
	}

	public String getUsername() {
		return username;
	}

	public String getAuthority() {
		return authority;
	}

}
