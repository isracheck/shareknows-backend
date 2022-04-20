package com.shareknows.websitebackend.service;

import java.util.List;

import com.shareknows.websitebackend.entity.Languages;

public interface ILanguagesService {

	public List<Languages> findAll();

	public void save(Languages languages);
}
