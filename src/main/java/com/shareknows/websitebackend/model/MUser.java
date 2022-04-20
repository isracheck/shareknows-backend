package com.shareknows.websitebackend.model;

import com.shareknows.websitebackend.entity.User;

public class MUser {

	private String user;
	private String email;
	private String name;
	private String phone;
	private String photo;

	public MUser() {

	}

	public MUser(String user, String email, String name, String phone, String photo) {
		super();
		this.user = user;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.photo = photo;
	}

	public MUser(User user) {
		super();
		this.user = user.getUser();
		this.email = user.getEmail();
		this.name = user.getEmail();
		this.phone = user.getPhone();
		this.photo = user.getPhoto();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}
