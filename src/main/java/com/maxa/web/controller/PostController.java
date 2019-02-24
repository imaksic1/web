package com.maxa.web.controller;

import com.maxa.web.model.UserDetails;
import com.maxa.web.model.UserPost;
import com.maxa.web.repository.PostRepository;
import com.maxa.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    PostRepository postRepo;

    @PostMapping("/addPost")
    public String addPost(@RequestBody UserPost userPost) {
        UserDetails updateUser = userRepo.findById(userPost.getUserId());
        if (updateUser == null) {
            return "UKNOWN USER !";
        }
        postRepo.save(userPost);
        return "OK";
    }

    @GetMapping("/selectUserId/{userId}")
    public List<UserPost> selectUserId(@PathVariable Long userId) {
        return postRepo.findByUserId(userId);
    }

    @GetMapping("/selectAllPost")
    List<UserPost> selectAllPost() {
        return postRepo.findAllByOrderByUserIdAsc();
    }

    @DeleteMapping("/delPost/{postId}")
    public String deletePost(@PathVariable Long postId) {
        UserPost delPost = postRepo.findById(postId);
        if (delPost == null) {
            return "NO SUCH POST !";
        }
        postRepo.deleteById(postId);
        return "OK";
    }

}
