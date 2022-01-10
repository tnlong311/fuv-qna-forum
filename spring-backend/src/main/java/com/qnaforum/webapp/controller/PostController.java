package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.exception.AppException;
import com.qnaforum.webapp.model.dto.PostRequest;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/{Pid}")
    public ResponseEntity<PostRequest> getPost(@PathVariable Long Pid) {
        Post post = postService.findForId(Pid)
            .orElseThrow(() -> new AppException("Post does not exist", HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(new PostRequest(post), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostRequest>> getPostList(Pageable pageable) {
        Page<Post> posts = postService.findAllByOrderByCreatedDateDescPageable(pageable);
        Page<PostRequest> postRequest = posts.map(post -> new PostRequest((post)));
        return new ResponseEntity<>(postRequest.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostRequest> addPost(@RequestBody PostRequest postRequest) {
        postService.addPost(postRequest);
        return new ResponseEntity<PostRequest>(HttpStatus.CREATED);
    }

}
