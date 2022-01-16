package com.qnaforum.webapp.service;

import com.qnaforum.webapp.model.dto.CommentDto;
import com.qnaforum.webapp.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CommentService {

  public Page<Comment> findAllByPid(Long pid, Pageable pageable);

  public void addComment(CommentDto commentDto);
}