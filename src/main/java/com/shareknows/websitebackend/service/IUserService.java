package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.User;

public interface IUserService {

	public List<User> findAll();
	
	public void save(User user);
	
	public User findUser(User user);
	
	public User findByUsername(String user);
	
	public User checkUserLogin(User user);
	
	public void deleteUser(User user);
	
	public User updateUser(User user);
	
	public void deleteUsername(String username);

}
