package com.shareknows.websitebackend.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.entity.UsersFollow;
import com.shareknows.websitebackend.service.IUsersFollowService;

//@Service
public class UsersFollowService implements IUsersFollowService {

	@Autowired
	private UsersFollowService usersFollowDao;

	@Override
	// @Transactional(readOnly=true)
	public List<UsersFollow> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UsersFollow userFollow) {
		usersFollowDao.save(userFollow);

	}

}
