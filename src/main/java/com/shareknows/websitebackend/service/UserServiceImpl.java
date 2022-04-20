package com.shareknows.websitebackend.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.dao.IUserDao;
import com.shareknows.websitebackend.entity.User;



@Service
public class UserServiceImpl implements IUserService {
	
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
	public void deleteUser(User user) {
		userDao.deleteByUser(user.getUser());	
	}

	@Override
	public User updateUser(User user) {
		return (User) userDao.save(user);
	}

	@Override
	public void deleteUser(String user) {
		userDao.deleteByUser(user);	
	}

	@Override
	public User findByUser(String user) {
		return (User) userDao.findByUser(user);
	}


	
}
