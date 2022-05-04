package com.shareknows.websitebackend.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shareknows.websitebackend.dao.IUserDao;
import com.shareknows.websitebackend.model.BasicResponse;
import com.shareknows.websitebackend.model.JwtResponse;
import com.shareknows.websitebackend.model.LoginForm;
import com.shareknows.websitebackend.security.JwtProvider;


@RestController
@RequestMapping("/api/auth")
public class AuthRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthRestController.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	IUserDao userRepository;

	@PostMapping("/signin")
	@Transactional(readOnly=true)
	public ResponseEntity<BasicResponse> authenticateUser(@RequestBody LoginForm loginRequest) {

		Authentication authentication = this.authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = this.jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		
		// Each user has only one authority
		GrantedAuthority authority = userDetails.getAuthorities().iterator().next();
		
		return ResponseEntity.ok(new JwtResponse(jwt, userDetails, authority));
	}


}
