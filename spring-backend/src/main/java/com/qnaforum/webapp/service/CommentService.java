package com.qnaforum.webapp.service;

import com.qnaforum.webapp.model.dto.CommentDto;
import com.qnaforum.webapp.model.entity.Comment;
import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.model.entity.User;
import com.qnaforum.webapp.repository.CommentRepository;
import com.qnaforum.webapp.repository.PostRepository;
import com.qnaforum.webapp.service.impl.CustomUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private CustomUserDetailsServiceImpl userDetailsService;

  public void addComment(CommentDto commentDto) {
    String content = commentDto.getContent();
    LocalDateTime createdDate = LocalDateTime.now();
    User user = userDetailsService.getCurrentUserByUsername();
    // need handle empty post exception
    Post post = postRepository.getById(commentDto.getPid());

    Comment comment = new Comment(content, createdDate, user, post);
    commentRepository.save(comment);
  }
}
