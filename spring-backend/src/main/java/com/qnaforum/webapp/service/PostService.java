package com.qnaforum.webapp.service;

import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {

    public Optional<Post> findById(Long id);

    public void addPost(PostDto postDto);

    Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable);

    public void deletePost(Long pid);
}