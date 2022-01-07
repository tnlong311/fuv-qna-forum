package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.exception.AppException;
import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.security.UserPrincipal;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.qnaforum.webapp.security.CurrentUser;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> Test(Pageable pageable) {
        return new ResponseEntity<String>("It's okay", HttpStatus.OK);
    }

    @GetMapping(value = "/posts")
    public ResponseEntity<List<PostDto>> getPostList(Pageable pageable) {
        Page<Post> posts = postService.findAllByOrderByCreatedDateDescPageable(pageable);
        Page<PostDto> postDto = posts.map(post -> new PostDto((post)));
        return new ResponseEntity<>(postDto.getContent(), HttpStatus.OK);
    }

    @PostMapping(value = "/posts/{id}")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto,
                                                @CurrentUser UserPrincipal UserPrincipal) {
        if (postDto.getId() != null) {
            throw new AppException("A new post cannot already have an ID", HttpStatus.CONFLICT);
        } else {
            PostDto returnPost = postService.addPost(postDto, UserPrincipal);
            return new ResponseEntity<PostDto>(returnPost, HttpStatus.CREATED);
        }
    }

//    @GetMapping(value = "/posts/{id}")

//    @PostMapping(value = "/posts")

//    @DeleteMapping(value = "/posts/{id}")

}
