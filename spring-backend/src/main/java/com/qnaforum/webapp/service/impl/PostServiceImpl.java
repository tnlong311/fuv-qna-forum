package com.qnaforum.webapp.service.impl;

import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.payload.ApiResponse;
import com.qnaforum.webapp.repository.PostRepository;

import com.qnaforum.webapp.security.UserPrincipal;
import com.qnaforum.webapp.service.CustomUserDetailsService;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository PostRepository;


    @Override
    public Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable) {
        return PostRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    @Override
    public ApiResponse deletePost(Long id, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public PostDto addPost(PostDto postDto, CustomUserDetailsService customUserDetails) {
        return null;
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }
}
