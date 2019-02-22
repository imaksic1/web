package com.maxa.web.controller;

import com.maxa.web.model.UserDetails;
import com.maxa.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class SelectController {
    @Autowired
    UserRepository userRepo;

    @PutMapping("/updateUser/{id}")
    String updateUser(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName, @RequestParam(value = "address", required = false) String address,
                      @RequestParam(value = "nickName", required = false) String nickName, @RequestParam(value = "age", required = false) Integer age, @RequestParam("id") Long id) {
        UserDetails updateUser = userRepo.findById(id);
        boolean written = false;
        if (updateUser == null) {
            return "UKNOWN USER !";
        }
        if (!(firstName==null)){
            updateUser.setFirstName(firstName);
            written=true;
        }
        if (!(lastName==null)){
            updateUser.setLastName(lastName);
            written=true;
        }
        if (!(address==null)){
            updateUser.setAddress(address);
            written=true;
        }
        if (!(nickName==null)){
            updateUser.setNickName(nickName);
            written=true;
        }
        if (!(age==null)){
            updateUser.setAge(age);
            written=true;
        }
        if (written){
            userRepo.save(updateUser);
            return "OK";
        }else {
            return "All fields are empty !";
        }

    }

    @GetMapping("/selectFirstName/{firstName}")
    public List<UserDetails> selectFirstName(@PathVariable String firstName) {
        return userRepo.findByFirstNameIgnoreCase(firstName);
    }

    @GetMapping("/selectLastName/{lastName}")
    public List<UserDetails> selectLastName(@PathVariable String lastName) {
        return userRepo.findByLastNameIgnoreCase(lastName);
    }

    @GetMapping("/selectAddress/{address}")
    public List<UserDetails> selectAddress(@PathVariable String address) {
        return userRepo.findByAddressIgnoreCase(address);
    }

    @GetMapping("/selectNickName/{nickName}")
    public List<UserDetails> selectNickName(@PathVariable String nickName) {
        return userRepo.findByNickNameIgnoreCase(nickName);
    }

    @GetMapping("/selectAge/{age}")
    public List<UserDetails> selectAge(@PathVariable  Integer age) {
        return userRepo.findByAge(age);
    }

    @GetMapping("/likeFirstName/{firstName}")
    public Optional<List<UserDetails>> likeFirstName(@PathVariable String firstName) {
        Optional<List<UserDetails>> accept;
        if (firstName.length()>2){
            accept=userRepo.findByFirstNameStartingWithIgnoreCase(firstName);
            return accept;
        }else {
            return Optional.empty();
        }
    }

    @GetMapping("/likeLastName/{lastName}")
    public Optional<List<UserDetails>> likeLastName(@PathVariable String lastName) {
        if (lastName.length()>2){
            return userRepo.findByLastNameStartingWithIgnoreCase(lastName);
        }else {
            return Optional.empty();
        }
    }

    @GetMapping("/likeAddress/{address}")
    public Optional<List<UserDetails>> likeAddress(@PathVariable String address) {
        if (address.length()>2){
            return userRepo.findByAddressStartingWithIgnoreCase(address);
        }else {
            return Optional.empty();
        }
    }

    @GetMapping("/likeNickName/{nickName}")
    public Optional<List<UserDetails>> likeNickName(@PathVariable String nickName) {
        if (nickName.length()>2){
            return userRepo.findByNickNameStartingWithIgnoreCase(nickName);
        }else {
            return Optional.empty();
        }
    }

}
