package com.qnaforum.webapp.service;

import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.payload.ApiResponse;
import com.qnaforum.webapp.security.UserPrincipal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

//    ApiResponse deletePost(Long id, UserPrincipal currentUser);

    public PostDto addPost(PostDto postDto, UserPrincipal userPrincipal);

    Page<Post> findAllByOrderByCreatedDateDescPageable(Pageable pageable);
}