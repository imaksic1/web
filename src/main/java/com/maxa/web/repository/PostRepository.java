package com.maxa.web.repository;


import com.maxa.web.model.UserDetails;
import com.maxa.web.model.UserPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<UserPost,Long> {

    List<UserPost> findByUserId(Long userId);

    List<UserPost> findAllByOrderByUserIdAsc();

    UserPost findById(Long id);

    @Transactional
    void deleteById(Long id);
}
