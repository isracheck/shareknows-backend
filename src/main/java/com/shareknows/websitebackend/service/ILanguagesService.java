package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.Cities;
import com.shareknows.websitebackend.entity.Languages;

public interface ILanguagesService {
	
	public List<Languages> findAll();

	public void save(Languages languages);
	
	public Languages findByLanguage(String language);
	
	public List<Languages> findByIdlanguage(String language);
	
	Languages findLanguage(Languages languages);
	
	public void deleteLanguage(String language);
	
	public Languages updateLanguage(Languages languages);
}
