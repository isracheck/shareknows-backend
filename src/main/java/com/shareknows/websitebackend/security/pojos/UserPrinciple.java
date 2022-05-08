package com.shareknows.websitebackend.security.pojos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shareknows.websitebackend.entity.User;
import com.shareknows.websitebackend.model.RoleName;

public class UserPrinciple implements UserDetails {

	private static final long serialVersionUID = 5887971688214007651L;

	private Integer id;

	private String name;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	private boolean isEnabled;

	private boolean isCredentialsNonExpired;

	public UserPrinciple(Integer id, String name, String username, String email, String password, boolean isEnabled,
			String recoveryUuid, Collection<SimpleGrantedAuthority> authorities) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
		this.isEnabled = isEnabled;

		if (recoveryUuid != null && !recoveryUuid.isEmpty()) {
			this.isCredentialsNonExpired = false;
		} else {
			this.isCredentialsNonExpired = true;
		}
	}

	public static UserPrinciple build(User user) {

		// Check if role exists in current enum
		RoleName autorityRole = RoleName.valueOf(user.getRole());

		// Create the authority array
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(autorityRole.name()));

		// Build object
		return new UserPrinciple(user.getIduser().intValue(), user.getName(), user.getUsername(), user.getEmail(),
				user.getHash(), true, user.getRecoveryuuid(), authorities);
	}

	// ********************
	// GETTERS
	// ********************

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(authorities, email, id, name, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPrinciple other = (UserPrinciple) obj;
		return Objects.equals(authorities, other.authorities) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
}
