package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> Test(Pageable pageable) {
        return new ResponseEntity<String>("It's okay", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postRequest) {
        postService.addPost(postRequest);
        return new ResponseEntity<PostDto>(HttpStatus.CREATED);
    }

}
