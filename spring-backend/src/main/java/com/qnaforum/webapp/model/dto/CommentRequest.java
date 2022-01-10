package com.qnaforum.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CommentRequest {
  /*private Long Cid;*/
  private String content;
  /*private LocalDateTime createdDate;*/
  /*private int likes;*/
  /*private Long Uid;*/
  private Long Pid;
}
