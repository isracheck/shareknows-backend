package com.shareknows.websitebackend.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.dao.IUserDao;
import com.shareknows.websitebackend.entity.User;
import com.shareknows.websitebackend.service.IUserService;



@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	@Transactional(readOnly = true)
	public User findUser(User user) {
		return (User) userDao.findByEmail(user.getEmail());
	}

	@Override
	public User checkUserLogin(User user) {
		return (User) userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		userDao.deleteByUser(user.getUser());	
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return (User) userDao.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(String user) {
		userDao.deleteByUser(user);	
	}

	@Override
	public User findByUser(String user) {
		return (User) userDao.findByUser(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUser(username);
		if(user == null) {
			throw new UsernameNotFoundException("Usuario no valido");
		}
		return new org.springframework.security.core.userdetails.User(user.getUser(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE ADMIN")));	
	}


	
}
