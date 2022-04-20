package com.shareknows.websitebackend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shareknows.websitebackend.entity.User;
import com.shareknows.websitebackend.model.MUser;
import com.shareknows.websitebackend.service.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getCompanies(){
        return userService.findAll();
    }

    @PostMapping("/findUser")
    public ResponseEntity<?> findUser(@RequestBody User user){
        User userDb = userService.findUser(user);
        if(userDb!=null) {
            return new ResponseEntity<>(userDb, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<Void> addUser(@RequestBody User user){
        if(userService.findUser(user)==null) {
            userService.save(user);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        User userDb = userService.checkUserLogin(user);
        if(userDb!=null) {
            List<User> users = new ArrayList<>();
            users.add(userDb);
            List<MUser> mUsers = new ArrayList<>();
            //mUsers = Mapper.convertirListaUsers(users);
            return new ResponseEntity<>(mUsers, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable(value="id")String userid, @RequestBody User user){
        User userDb = null;
        userDb = userService.findByUser(userid);
        if(userDb != null) {
            userDb.setEmail(user.getEmail());
            userDb.setName(user.getName());
            userDb.setPhone(user.getPhone());
            userDb.setPhoto(user.getPhoto());
            userService.updateUser(user);
            return new ResponseEntity<>(userDb, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value="user")String user){
        userService.deleteUser(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
