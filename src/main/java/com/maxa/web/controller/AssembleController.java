package com.maxa.web.controller;

import com.maxa.web.model.AssembleComputer;
import com.maxa.web.model.Computer;
import com.maxa.web.model.ComputerParts;
import com.maxa.web.repository.AssembleRepository;
import com.maxa.web.repository.ComputerPartsRepository;
import com.maxa.web.repository.ComputerReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssembleController {

    @Autowired
    ComputerReposirory compRepo;

    @Autowired
    ComputerPartsRepository partsRepo;

    @Autowired
    AssembleRepository assembleRepo;

    @PostMapping("/addAssemble/{computerId}")
    String addAssemble(@RequestParam("computerId") Long computerId, @RequestParam("computerPartId") Long computerPartId) {
        Computer addComp = compRepo.findById(computerId);
        if (addComp == null) {
            return "NO SUCH COMPUTER !";
        }
        ComputerParts addPart = partsRepo.findById(computerPartId);
        if (addPart == null) {
            return "NO SUCH PART !";
        }
        AssembleComputer assemble=new AssembleComputer();
        assemble.setComputer(addComp);
        assemble.setComputerParts(addPart);
        assembleRepo.save(assemble);
        return "OK";
    }

    @DeleteMapping("/delAssemble/{assembleId}")
    public String deleteAssemble(@PathVariable Long assembleId) {
        AssembleComputer delAssemble = assembleRepo.findById(assembleId);
        if (delAssemble == null) {
            return "NO SUCH ASSEMBLE INFO !";
        }
        assembleRepo.deleteById(assembleId);
        return "OK";
    }
}
