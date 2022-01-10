package com.qnaforum.webapp.controller;

import com.qnaforum.webapp.model.dto.CommentRequest;
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
  public ResponseEntity<CommentRequest> addComment(@RequestBody CommentRequest commentRequest) {
    commentService.addComment(commentRequest);
    return new ResponseEntity<CommentRequest>(HttpStatus.CREATED);
  }

  // @GetMapping("/all/{Pid}")

}
