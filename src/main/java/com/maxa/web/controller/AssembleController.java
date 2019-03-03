package com.maxa.web.controller;

import com.maxa.web.dto.AssembleComputerDTO;
import com.maxa.web.dto.AssembleCopmuterMapper;
import com.maxa.web.model.AssembleComputer;
import com.maxa.web.model.Computer;
import com.maxa.web.model.ComputerParts;
import com.maxa.web.repository.AssembleRepository;
import com.maxa.web.repository.ComputerPartsRepository;
import com.maxa.web.repository.ComputerReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

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
        addComp.getAssembleComputer().add(assemble);
        addPart.getAssembleComputer().add(assemble);
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

    @GetMapping("/selectAllAssemble")
    List<AssembleComputerDTO> selectAllAssemble() {
        List<AssembleComputer> assemble = assembleRepo.findAll();
        return AssembleCopmuterMapper.INSTANCE.assembleToAssembleDTO(assemble);
    }

    @GetMapping("/selectOneAssemble/{oneAssemble}")
    AssembleComputerDTO selectOneAssemble(@RequestParam("oneAssemble") Long oneAssemble) {
        AssembleComputer assemble = assembleRepo.findById(oneAssemble);
        if (assemble==null){
            return new AssembleComputerDTO();
        }
        return AssembleCopmuterMapper.INSTANCE.assembleToAssembleDTO(assemble);
    }

    @GetMapping("/selectAssemblePart/{computerParts}")
    List<AssembleComputerDTO> selectAssemblePart(@RequestParam("assembleParts") Long computerParts) {
        ComputerParts findPart = partsRepo.findById(computerParts);
        if (findPart == null) {
            return new LinkedList<AssembleComputerDTO>();
        }
        List<AssembleComputer> assemble = assembleRepo.findByComputerParts(findPart);
        return AssembleCopmuterMapper.INSTANCE.assembleToAssembleDTO(assemble);
    }

    @GetMapping("/selectAssembleComputer/{computer}")
    List<AssembleComputerDTO> selectAssembleComputer(@RequestParam("computer") Long computer) {
        Computer findComputer = compRepo.findById(computer);
        if (findComputer == null) {
            return new LinkedList<AssembleComputerDTO>();
        }
        List<AssembleComputer> assemble = assembleRepo.findByComputer(findComputer);
        return AssembleCopmuterMapper.INSTANCE.assembleToAssembleDTO(assemble);
    }

    @PutMapping("/updateAssemble/{id}")
    String updateAssemble(@RequestParam(value = "computer", required = false) Long computer, @RequestParam(value = "computerPart", required = false) Long computerPart, @RequestParam("id") Long id) {
        AssembleComputer assemble = assembleRepo.findById(id);
        if (assemble == null) {
            return "UKNOWN ASSEMBLE !";
        }
        Computer findComp = compRepo.findById(computer);
        if (findComp != null) {
            findComp.getAssembleComputer().add(assemble);
            assemble.setComputer(findComp);
        }
        ComputerParts findPart = partsRepo.findById(computerPart);
        if (findPart != null) {
            findPart.getAssembleComputer().add(assemble);
            assemble.setComputerParts(findPart);
        }
        if (computer==null && computerPart==null){
            return "All fields are empty";
        }
        if (computer!=null && findComp==null){
            return "NO SUCH COMPUTER !";
        }
        if (computerPart!=null && findPart==null){
            return "NO SUCH PART !";
        }
        assembleRepo.save(assemble);
        return "OK";
    }
}
