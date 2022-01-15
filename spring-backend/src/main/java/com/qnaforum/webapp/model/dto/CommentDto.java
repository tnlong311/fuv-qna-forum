package com.qnaforum.webapp.model.dto;

import com.qnaforum.webapp.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
  private Long Cid;
  private String content;
  private LocalDateTime createdDate;
  private int likes;
  private Long Uid;
  private String userName;
  private Long pid;

  public CommentDto(Comment comment) {
    this.Cid = comment.getCid();
    this.content = comment.getContent();
    this.likes = comment.getLikes();
    this.createdDate = comment.getCreatedDate();
    this.Uid = comment.getUser().getUid();
    this.userName = comment.getUser().getUsername();
    this.pid = comment.getPost().getPid();
  }
}
