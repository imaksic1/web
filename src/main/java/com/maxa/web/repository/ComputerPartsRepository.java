package com.maxa.web.repository;

import com.maxa.web.model.ComputerParts;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ComputerPartsRepository extends CrudRepository<ComputerParts,Long> {

    List<ComputerParts> findAll();

    ComputerParts findById(Long partId);

    @Transactional
    void deleteById(Long id);
}
