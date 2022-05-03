package com.shareknows.websitebackend.service.impl;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shareknows.websitebackend.dao.ILanguagesDao;

import com.shareknows.websitebackend.entity.Languages;
import com.shareknows.websitebackend.service.ILanguagesService;

@Service
public class LanguagesService implements ILanguagesService  {

	
	@Autowired
	private ILanguagesDao languagesDao;

	@Override
	@Transactional(readOnly=true)
	public List<Languages> findAll() {
		return (List<Languages>) languagesDao.findAll();
	}

	@Override
	@Transactional
	public void save(Languages languages) {
		languagesDao.save(languages);	
	}

	@Override
	public Languages findByLanguage(String language) {
		return (Languages) languagesDao.findByIdlanguage(language);
	}
	
	@Override
	public List<Languages> findByIdlanguage(String idlanguage) {
		return (List<Languages>) languagesDao.findByIdlanguage(idlanguage);
	}

	@Override
	public Languages findLanguage(Languages cities) {
		return (Languages) languagesDao.findByIdlanguage(cities.getIdlanguage());
	}

	@Override
	@Transactional
	public void deleteLanguage(String city) {
		languagesDao.removeByIdlanguage(city);
		
	}

	@Override
	@Transactional
	public Languages updateLanguage(Languages language) {
		return languagesDao.save(language);
	}

}
