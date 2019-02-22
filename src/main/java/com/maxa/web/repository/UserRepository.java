package com.maxa.web.repository;


import com.maxa.web.model.UserDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, Long> {

    @Transactional
    void deleteById(Long id);

    UserDetails findById(Long id);

    List<UserDetails> findAll();

    List<UserDetails> findByFirstNameIgnoreCase(String firstName);

    List<UserDetails> findByLastNameIgnoreCase(String lastName);

    List<UserDetails> findByAddressIgnoreCase(String address);

    List<UserDetails> findByNickNameIgnoreCase(String nickName);

    List<UserDetails> findByAge(Integer age);

    Optional <List<UserDetails>> findByFirstNameStartingWithIgnoreCase(String firstName);

    Optional <List<UserDetails>> findByLastNameStartingWithIgnoreCase(String lastName);

    Optional <List<UserDetails>> findByAddressStartingWithIgnoreCase(String address);

    Optional <List<UserDetails>> findByNickNameStartingWithIgnoreCase(String nickName);

}
