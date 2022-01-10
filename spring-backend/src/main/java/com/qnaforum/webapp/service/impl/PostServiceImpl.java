package com.qnaforum.webapp.service.impl;

import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.model.entity.User;
import com.qnaforum.webapp.payload.ApiResponse;
import com.qnaforum.webapp.repository.PostRepository;

import com.qnaforum.webapp.repository.UserRepository;
import com.qnaforum.webapp.security.UserPrincipal;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsServiceImpl userDetailsService;

    @Override
    public Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    @Override
    public ApiResponse deletePost(Long id, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public void addPost(PostDto postRequest) {
        String title = postRequest.getTitle();
        String content = postRequest.getContent();
        LocalDateTime createdDate = LocalDateTime.now();
        User user = userDetailsService.getCurrentUserByUsername();

        Post post = new Post(title, content, createdDate, user);
        postRepository.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }
}
