package com.shareknows.websitebackend.dao;

import org.springframework.data.repository.CrudRepository;

import com.shareknows.websitebackend.entity.Countries;
import com.shareknows.websitebackend.entity.Languages;

public interface ILanguagesDao extends CrudRepository<Languages, String> {

	public Integer removeByIdlanguage(String idlanguage);

	public Languages findByIdlanguage(String idlanguage);

}
