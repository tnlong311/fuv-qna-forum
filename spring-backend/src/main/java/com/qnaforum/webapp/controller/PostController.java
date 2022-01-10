package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.exception.AppException;
import com.qnaforum.webapp.model.dto.PostDto;
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

    @GetMapping(value = "{Pid}")
    public ResponseEntity<PostDto> getPost(@PathVariable Long Pid) {
        Post post = postService.findForId(Pid).orElseThrow(() -> new AppException("Post does not exist", HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(new PostDto(post), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getPostList(Pageable pageable) {
        Page<Post> posts = postService.findAllByOrderByCreatedDateDescPageable(pageable);
        Page<PostDto> postDto = posts.map(post -> new PostDto((post)));
        return new ResponseEntity<>(postDto.getContent(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postRequest) {
        postService.addPost(postRequest);
        return new ResponseEntity<PostDto>(HttpStatus.CREATED);
    }

}
