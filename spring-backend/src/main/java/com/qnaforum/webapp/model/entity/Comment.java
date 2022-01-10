package com.qnaforum.webapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment", uniqueConstraints = { @UniqueConstraint(columnNames = { "Cid" })})
public class Comment {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Cid")
  private Long Cid;

  @NotEmpty(message = "Content must not be empty")
  @Column(name = "Content")
  private String content;

  @CreatedDate
  @Column(name = "datecreated", columnDefinition = "TIMESTAMP")
  private LocalDateTime createdDate;

  @Column(name = "Likes")
  private int likes;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotEmpty
  @JoinColumn(name = "Uid", referencedColumnName = "Uid")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @NotEmpty
  @JoinColumn(name = "pid", referencedColumnName = "pid")
  private Post post;

  public Comment(String content, LocalDateTime createdDate, User user, Post post) {
    this.content = content;
    this.createdDate = createdDate;
    this.user = user;
    this.post = post;
  }
}
