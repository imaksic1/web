package com.maxa.web.controller;

import com.maxa.web.auxiliary.ComputerJson;
import com.maxa.web.auxiliary.ComputerPartsJson;
import com.maxa.web.model.Computer;
import com.maxa.web.model.ComputerParts;
import com.maxa.web.model.UserDetails;
import com.maxa.web.model.UserPost;
import com.maxa.web.repository.ComputerPartsRepository;
import com.maxa.web.repository.ComputerReposirory;
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

import java.util.LinkedList;
import java.util.List;

@RestController
public class ComputerController {

    @Autowired
    ComputerReposirory compRepo;

    @Autowired
    ComputerPartsRepository partsRepo;

    @PostMapping("/addComputer")
    public String addComputer(@RequestBody ComputerJson computerJson) {
        Computer computer=new Computer();
        computer.setComputerName(computerJson.getComputerName());
        computer.setPrice(computerJson.getPrice());
        compRepo.save(computer);
        return "OK";
    }

    @GetMapping("/selectAllComputer")
    List<ComputerJson> selectAllComputer() {
        List<Computer> allComputers=compRepo.findAll();
        List<ComputerJson> allComputersJson = new LinkedList<>();
        for (int i=0; i<allComputers.size();i++){
            ComputerJson computersJson = new ComputerJson();
            computersJson.setComputerName(allComputers.get(i).getComputerName());
            computersJson.setPrice(allComputers.get(i).getPrice());
            allComputersJson.add(computersJson);
        }
        return allComputersJson;
    }

    @DeleteMapping("/delComputer/{compId}")
    public String deleteComputer(@PathVariable Long compId) {
        Computer delComp = compRepo.findById(compId);
        if (delComp == null) {
            return "NO SUCH COMPUTER !";
        }
        compRepo.deleteById(compId);
        return "OK";
    }

    @PutMapping("/updateComputer/{id}")
    String updateComputer(@RequestParam(value = "computerName", required = false) String computerName, @RequestParam(value = "price", required = false) Double price, @RequestParam("id") Long id) {
        Computer updateComputer = compRepo.findById(id);
        boolean written = false;
        if (updateComputer == null) {
            return "UKNOWN COMPUTER !";
        }
        if (!(computerName==null)){
            updateComputer.setComputerName(computerName);
            written=true;
        }
        if (!(price==null)){
            updateComputer.setPrice(price);
            written=true;
        }
        if (written){
            compRepo.save(updateComputer);
            return "OK";
        }else {
            return "All fields are empty !";
        }

    }

    @PostMapping("/addComputerPart")
    public String addParts(@RequestBody ComputerPartsJson computerPartsJson) {
        ComputerParts computerParts = new ComputerParts();
        computerParts.setPartType(computerPartsJson.getPartType());
        computerParts.setPrice(computerPartsJson.getPrice());
        computerParts.setProducer(computerPartsJson.getProducer());
        partsRepo.save(computerParts);
        return "OK";
    }

    @GetMapping("/selectAllComputerParts")
    List<ComputerPartsJson> selectAllComputerParts() {
        List<ComputerParts> allComputerParts = partsRepo.findAll();
        List<ComputerPartsJson> allComputerPartsJson = new LinkedList<>();
        for (int i=0; i<allComputerParts.size();i++){
            ComputerPartsJson computerPartsJson = new ComputerPartsJson();
            computerPartsJson.setPartType(allComputerParts.get(i).getPartType());
            computerPartsJson.setPrice(allComputerParts.get(i).getPrice());
            computerPartsJson.setProducer(allComputerParts.get(i).getProducer());
            allComputerPartsJson.add(computerPartsJson);
        }
        return allComputerPartsJson;
    }

    @DeleteMapping("/delPart/{partId}")
    public String deletePart(@PathVariable Long partId) {
        ComputerParts delPart = partsRepo.findById(partId);
        if (delPart == null) {
            return "NO SUCH PART !";
        }
        partsRepo.deleteById(partId);
        return "OK";
    }

    @PutMapping("/updateComputerPart/{id}")
    String updateComputerPart(@RequestParam(value = "partType", required = false) String partType, @RequestParam(value = "price", required = false) Double price,
                              @RequestParam(value = "producer", required = false) String producer,@RequestParam("id") Long id) {
        ComputerParts updatePart = partsRepo.findById(id);
        boolean written = false;
        if (updatePart == null) {
            return "UKNOWN PART !";
        }
        if (!(partType==null)){
            updatePart.setPartType(partType);
            written=true;
        }
        if (!(price==null)){
            updatePart.setPrice(price);
            written=true;
        }
        if (!(producer==null)){
            updatePart.setProducer(producer);
            written=true;
        }
        if (written){
            partsRepo.save(updatePart);
            return "OK";
        }else {
            return "All fields are empty !";
        }
    }
}
