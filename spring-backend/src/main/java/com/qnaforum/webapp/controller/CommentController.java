package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.exception.AppException;
import com.qnaforum.webapp.model.dto.CommentDto;
import com.qnaforum.webapp.model.entity.Comment;
import com.qnaforum.webapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
  @Autowired
  private CommentService commentService;

  @PostMapping
  public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto) {
    commentService.addComment(commentDto);
    return new ResponseEntity<CommentDto>(HttpStatus.CREATED);
  }


  @GetMapping("/all/{pid}")
  public ResponseEntity<List<CommentDto>> getCommentList(@PathVariable Long pid, Pageable pageable) {
    Page<Comment> commentList = commentService.findAllByPid(pid, pageable);
    Page<CommentDto> commentDto = commentList.map(comment -> new CommentDto((comment)));
    return new ResponseEntity<>(commentDto.getContent(), HttpStatus.OK);
  }

}
