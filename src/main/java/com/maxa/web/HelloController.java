package com.maxa.web;
import org.springframework.web.bind.annotation.*;

@RestController
    public class HelloController {

        @GetMapping("/Profa")
        String ajd() {
            return "Zoki";
        }
        @GetMapping("/str")
        public String uldDetailGet (@RequestParam("id") String id){
            return id;
        }
        @GetMapping("/intBr")
        public Integer uldDetailGet (@RequestParam(value = "int1", required=false) Integer i){
            if (i==null){
                return -1;
            }
            return i;
        }
        @GetMapping("/ia1/{i1}")
        public Integer getUser(@PathVariable Integer i1)
        {
            return i1;
        }
        @GetMapping("/igra/{id}")
        public String getUser(@PathVariable String id)
        {
            return "Napisao si "+id;
        }
        @GetMapping("/br")
        Integer br1(@RequestParam("i1") Integer i1,@RequestParam("i2") Integer i2) {
            Pomocna pom = new Pomocna();
            return pom.izracunaj(i1)*i2;
        }
    }
