package com.qnaforum.webapp.service.impl;

import com.qnaforum.webapp.exception.AppException;
import com.qnaforum.webapp.model.dto.PostDto;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.model.entity.User;
import com.qnaforum.webapp.repository.PostRepository;

import com.qnaforum.webapp.repository.UserRepository;
import com.qnaforum.webapp.security.SecurityUtil;
import com.qnaforum.webapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


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

    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void addPost(PostDto postDto) {
        String title = postDto.getTitle();
        String content = postDto.getContent();
        LocalDateTime createdDate = LocalDateTime.now();
        User user = userDetailsService.getCurrentUserByUsername();

        Post post = new Post(title, content, createdDate, user);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long pid) {
        postRepository.findById(pid).ifPresent(p -> {
            if (p.getUser().getUid() != SecurityUtil.getCurrentUserLogin().get().getId()) {
                throw new AppException("It's not a writer.");
            }
            postRepository.delete(p);
        });
    }
}
