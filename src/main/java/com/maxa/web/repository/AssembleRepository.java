package com.maxa.web.repository;

import com.maxa.web.model.AssembleComputer;
import com.maxa.web.model.Computer;
import com.maxa.web.model.ComputerParts;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AssembleRepository extends CrudRepository<AssembleComputer,Long> {

    AssembleComputer findById(Long id);

    @Transactional
    void deleteById(Long id);

    List<AssembleComputer> findAll();

    List<AssembleComputer> findByComputerParts(ComputerParts computerParts);

    List<AssembleComputer> findByComputer(Computer computer);
}
