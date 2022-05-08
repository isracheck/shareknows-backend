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

import com.shareknows.websitebackend.entity.Cities;
import com.shareknows.websitebackend.service.ICitiesService;

@RestController
@RequestMapping("/api/cities")
public class CityRestController {

	@Autowired
	private ICitiesService citiesService;

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Cities> getCities() {
		return citiesService.findAll();
	}

	@GetMapping("/find/{idcity}")
	public ResponseEntity<?> findCity(@PathVariable(value = "idcity") String idcity) {
		Cities cityDb = citiesService.findByCity(idcity);
		if (cityDb != null) {
			return new ResponseEntity<>(cityDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/findByCountry/{idcountry}")
	public List<Cities> findByCountry(@PathVariable(value = "idcountry") String idcountry) {
		return citiesService.findByIdcountry(idcountry);
	}

	@PostMapping("/save")
	public ResponseEntity<Void> saveCity(@RequestBody Cities cities) {

		if (citiesService.findCity(cities) == null) {
			citiesService.save(cities);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/update/{idcity}")
	public ResponseEntity<?> updateCity(@PathVariable(value = "idcity") String idcity, @RequestBody Cities cities) {
		Cities cityDb = null;
		cityDb = citiesService.findByCity(idcity);
		if (cityDb != null) {
			cityDb.setIdcity(cities.getIdcity());
			cityDb.setIdcountry(cities.getIdcountry());
			cityDb.setName(cities.getName());
			citiesService.updateCity(cities);
			return new ResponseEntity<>(cityDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{idcity}")
	public ResponseEntity<Void> deleteCity(@PathVariable(value = "idcity") String idcity) {
		citiesService.deleteCity(idcity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
