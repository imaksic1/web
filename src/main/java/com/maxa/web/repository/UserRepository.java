package com.maxa.web.repository;


import com.maxa.web.model.UserDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserDetails,Long> {

@Transactional
void deleteById(Long id);
UserDetails  findById(Long id);
List <UserDetails> findAll();

}
