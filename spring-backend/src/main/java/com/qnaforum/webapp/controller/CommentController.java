package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.model.dto.CommentDto;
import com.qnaforum.webapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  // @GetMapping("/all/{Pid}")

}
