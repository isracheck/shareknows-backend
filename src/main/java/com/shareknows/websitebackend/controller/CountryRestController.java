package com.shareknows.websitebackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shareknows.websitebackend.entity.Countries;
import com.shareknows.websitebackend.service.ICountriesService;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

	@Autowired
	private ICountriesService countriesService;

	/**
	 * Method: Petición que retorna todos los paises de la entidad
	 * @param 
	 * @return 
	 */
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Countries> getCountries() {
		return countriesService.findAll();
	}
	
	/**
	 * Method: Petición que retorna un pais en base a un ID
	 * @param 
	 * @return 
	 */
	@GetMapping("/find/{idcountry}")
	public ResponseEntity<?> findCountry(@PathVariable(value = "idcountry") String idcountry) {
		Countries countryDb = countriesService.findByCountry(idcountry);
		if (countryDb != null) {
			return new ResponseEntity<>(countryDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Method: Petición que guarda un nuevo pais
	 * @param 
	 * @return 
	 */
	@PostMapping("/save")
	public ResponseEntity<Void> saveCountry(@RequestBody Countries countries) {

		if (countriesService.findCountry(countries) == null) {
			countriesService.save(countries);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

	/**
	 * Method: Petición que actualiza un pais en base a un ID
	 * @param 
	 * @return 
	 */
	@PutMapping("/update/{idcountry}")
	public ResponseEntity<?> updateCountry(@PathVariable(value = "idcountry") String idcountry,
			@RequestBody Countries countries) {
		Countries countryDb = null;
		countryDb = countriesService.findByCountry(idcountry);
		if (countryDb != null) {
			countryDb.setIdcountry(countries.getIdcountry());
			countryDb.setDescription(countries.getDescription());
			countryDb.setContinentName(countries.getContinentName());
			countriesService.updateCountry(countries);
			return new ResponseEntity<>(countryDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Method: Petición que elimina un pais en base a un ID
	 * @param 
	 * @return 
	 */
	@DeleteMapping("/delete/{idcountry}")
	public ResponseEntity<Void> deleteCountry(@PathVariable(value = "idcountry") String idcountry) {
		countriesService.deleteCountry(idcountry);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
