package com.maxa.web.controller;


import com.maxa.web.Calculate;
import com.maxa.web.model.UserDetails;
import com.maxa.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class H2Controller {
@Autowired
UserRepository userRepo;

@PostMapping("/add")
public String addUser(@RequestBody UserDetails userDetails) {
    userRepo.save(userDetails);
    return "OK";
}

@DeleteMapping("/delUser/{userId}")
public String deleteUser(@PathVariable Long userId)
{
    UserDetails updateUser = userRepo.findById(userId);
    if (updateUser==null){
        return "UKNOWN USER !";
    }
    userRepo.deleteById(userId);
    return "OK";
}

@PutMapping("/updateUser/{id}")
String updateUser(@RequestParam("firstName") String firstName, @RequestParam("id") Long id) {
    UserDetails updateUser = userRepo.findById(id);
    if (updateUser==null){
        return "UKNOWN USER !";
    }
    updateUser.setFirstName(firstName);
    userRepo.save(updateUser);
    return "OK";
}

@GetMapping("/selectId/{id}")
public UserDetails studentId(@PathVariable Long id)
{
    return userRepo.findById(id);
}

@GetMapping("/selectAll")
List <UserDetails> selectAll() {
    return userRepo.findAll();
}
}