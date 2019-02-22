package com.maxa.web.controller;

import com.maxa.web.Calculate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/professor")
    String professor() {
        return "Zoki";
    }

    @GetMapping("/lessonName")
    public String getLessonName(@RequestParam("lessonName") String lessonName) {
        return lessonName;
    }

    @GetMapping("/lessonNumber")
    public Integer getLessonNumber(@RequestParam(value = "lessonNumber", required = false) Integer lessonNumber) {
        if (lessonNumber == null) {
            return -1;
        }
        return lessonNumber;
    }

    @GetMapping("/studentId/{student}")
    public Integer studentId(@PathVariable Integer student) {
        return student;
    }

    @GetMapping("/game/{playerId}")
    public String playerId(@PathVariable String playerId) {
        return "You wrote: " + playerId;
    }

    @GetMapping("/surface")
    Integer surface(@RequestParam("wide") Integer wide, @RequestParam("lengthy") Integer lengthy) {
        Calculate pom = new Calculate();
        return pom.multiply(wide, lengthy);
    }
}
