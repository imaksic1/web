package com.maxa.web.repository;

import com.maxa.web.model.AssembleComputer;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface AssembleRepository extends CrudRepository<AssembleComputer,Long> {

    AssembleComputer findById(Long id);

    @Transactional
    void deleteById(Long id);

}
