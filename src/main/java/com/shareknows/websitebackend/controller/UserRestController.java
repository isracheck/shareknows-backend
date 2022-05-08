package com.shareknows.websitebackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.shareknows.websitebackend.entity.User;
import com.shareknows.websitebackend.model.MUser;
import com.shareknows.websitebackend.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	@Autowired
	private IUserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPassowrdEncoder;

	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getCompanies() {
		return userService.findAll();
	}

	@GetMapping("/find/{username}")
	public ResponseEntity<?> findUser(@PathVariable(value = "username") String username) {
		User userDb = userService.findByUsername(username);
		if (userDb != null) {
			return new ResponseEntity<>(userDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<?> updateUser(@PathVariable(value = "username") String username, @RequestBody User user) {
		User userDb = null;
		userDb = userService.findByUsername(username);
		if (userDb != null) {

			if (user.getEmail() != null) {
				userDb.setEmail(user.getEmail());
			}

			if (user.getName() != null) {
				userDb.setName(user.getName());
			}
			if (user.getLastname() != null) {
				userDb.setLastname(user.getLastname());
			}

			if (user.getPhone() != null) {
				userDb.setPhone(user.getPhone());
			}

			userDb.setPhoto(user.getPhoto());

			if (user.getHash() != null) {
				userDb.setHash(bCryptPassowrdEncoder.encode(user.getHash()));
			}
			userService.updateUser(userDb);
			return new ResponseEntity<>(userDb, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete/{user}")
	public ResponseEntity<Void> deleteUser(@PathVariable(value = "user") String user) {
		userService.deleteUsername(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
