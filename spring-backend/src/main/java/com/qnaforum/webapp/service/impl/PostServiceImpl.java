package com.qnaforum.webapp.service.impl;

import com.qnaforum.webapp.mapper.PostMapper;
import com.qnaforum.webapp.model.dto.PostRequest;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.payload.ApiResponse;
import com.qnaforum.webapp.repository.PostRepository;

import com.qnaforum.webapp.security.UserPrincipal;
import com.qnaforum.webapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Override
    public Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable) {
        return postRepository.findAllByOrderByCreatedDateDesc(pageable);
    }

    @Override
    public ApiResponse deletePost(Long id, UserPrincipal currentUser) {
        return null;
    }

    @Override
    public void addPost(PostRequest postRequest) {
        postRepository.save(postMapper.map(postRequest));
    }

    @Override
    public Post getPost(Long id) {
        return null;
    }
}
