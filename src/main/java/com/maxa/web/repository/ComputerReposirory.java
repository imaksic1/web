package com.maxa.web.repository;

import com.maxa.web.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ComputerReposirory extends CrudRepository<Computer,Long> {

    List<Computer> findAll();

    Computer findById(Long compId);

    @Transactional
    void deleteById(Long id);
}
