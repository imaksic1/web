package com.maxa.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class PlusControleler {

    @GetMapping("/ucenik")
    String ajd() {
        return "Maxa";
    }

    @PostMapping(path = "/members")
    public String addMemberV1(@RequestBody UserDetails userDetails) {
        return userDetails.getFirstName() + " " + userDetails.getLastName();
    }

    @PostMapping(path = "/korisnik")
    public Korisnik dodajClanV2(@RequestBody UserDetails userDetails) {
        Korisnik k1 = new Korisnik();
        k1.setIme(userDetails.getFirstName()+" "+userDetails.getAddress());
        k1.setPrezime(userDetails.getLastName());
        return k1;
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable String userId)
    {
         return "DELETE nije implementiran";

    }

    @PutMapping("/unos1/{Id}")
    public String updateUser(@PathVariable Integer id) {
        return "Uneli ste: " + id;
    }

    @PutMapping("/unos/{userId}")
    public String updateUser1(@PathVariable String userId, @RequestBody Korisnik kor) {
        return kor.getPrezime() + " " + kor.getIme() + " " + userId;
    }
}
