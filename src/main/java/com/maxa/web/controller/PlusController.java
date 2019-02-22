package com.maxa.web.controller;

import com.maxa.web.Professor;
import com.maxa.web.model.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@RestController
public class PlusController {

    @GetMapping("/studentName")
    String studentName() {
        return "Maxa";
    }

    @PostMapping(path = "/member")
    public String member(@RequestBody UserDetails userDetails) {
        return userDetails.getFirstName() + " " + userDetails.getLastName();
    }

    @PostMapping(path = "/userDetails")
    public Professor userDetails(@RequestBody UserDetails userDetails) {
        Professor k1 = new Professor();
        k1.setFirstName(userDetails.getFirstName() + " " + userDetails.getAddress());
        k1.setLastName(userDetails.getLastName());
        return k1;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "DELETE - Out of service";
    }

    @PutMapping("/updUser/{userId}")
    public String updUser(@PathVariable Integer userId) {
        return "You wrote: " + userId;
    }

    @PutMapping("/updateProfessor/{professorId}")
    public String updateProfessor(@PathVariable String userId, @RequestBody Professor professorId) {
        return professorId.getLastName() + " " + professorId.getFirstName() + " " + userId;
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile uploadFile,
                                   RedirectAttributes redirectAttributes) {
        if (uploadFile.isEmpty()) {
            return "Fajl " + uploadFile.getOriginalFilename() + " is empty!";
        }
        try {
            File convFile = new File(uploadFile.getOriginalFilename());
            convFile.createNewFile();
            FileOutputStream fileToWrite = new FileOutputStream(convFile);
            fileToWrite.write(uploadFile.getBytes());
            fileToWrite.flush();
            fileToWrite.close();
        } catch (IOException e) {
        }
        return "OK";
    }
}
