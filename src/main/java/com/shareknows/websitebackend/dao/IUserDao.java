package com.shareknows.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.User;

public interface IUserDao extends CrudRepository<User, Long>{

	public User findByEmail(String email);
	
	public User findByUsername(String username);
	
	public User findByEmailAndHash(String email, String password);
	
	public Integer deleteByUsername(String username);
	
}
