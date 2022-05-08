package com.shareknows.websitebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shareknows.websitebackend.entity.Languages;
import com.shareknows.websitebackend.service.ILanguagesService;

@RestController
@RequestMapping("/api/languages")
public class LanguageRestController {

	@Autowired
	private ILanguagesService languagesService;

	/**
	 * Method: Petición que retorna todos los lenguajes en la entidad
	 * @param 
	 * @return 
	 */
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Languages> getLanguages() {
		return languagesService.findAll();
	}

	/**
	 * Method: Petición que retorna el lenguaje en base al id
	 * @param 
	 * @return 
	 */
	@GetMapping("/find/{idlanguage}")
	public ResponseEntity<?> findLanguage(@PathVariable(value = "idlanguage") String idlanguage) {
		Languages languageDb = languagesService.findByLanguage(idlanguage);
		if (languageDb != null) {
			return new ResponseEntity<>(languageDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Method: Petición que guarda un lenguaje nuevo
	 * @param 
	 * @return 
	 */
	@PostMapping("/save")
	public ResponseEntity<Void> saveLanguage(@RequestBody Languages languages) {

		if (languagesService.findLanguage(languages) == null) {
			languagesService.save(languages);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

	/**
	 * Method: Petición que actualiza los datos de un lenguaje en base a su id y body
	 * @param 
	 * @return 
	 */
	@PutMapping("/update/{idlanguage}")
	public ResponseEntity<?> updateLanguage(@PathVariable(value = "idlanguage") String idlanguage,
			@RequestBody Languages languages) {
		Languages languageDb = null;
		languageDb = languagesService.findByLanguage(idlanguage);
		if (languageDb != null) {
			languageDb.setIdlanguage(languages.getIdlanguage());
			languageDb.setDescription(languages.getDescription());
			languagesService.updateLanguage(languages);
			return new ResponseEntity<>(languageDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Method: Petición que elimina un lenguaje en base a su id
	 * @param 
	 * @return 
	 */
	@DeleteMapping("/delete/{idlanguage}")
	public ResponseEntity<Void> deleteLanguage(@PathVariable(value = "idlanguage") String idlanguage) {
		languagesService.deleteLanguage(idlanguage);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
