package com.shareknows.websitebackend.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shareknows.websitebackend.entity.Languages;
import com.shareknows.websitebackend.service.ILanguagesService;

//@Service
public class LanguagesService implements ILanguagesService  {

	@Autowired
	private ILanguagesService languagesDao;
	
	@Override
	//@Transactional(readOnly=true)
	public List<Languages> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Languages languages) {
		languagesDao.save(languages);	
		
	}



}
