package com.qnaforum.webapp.model.dto;

import com.qnaforum.webapp.model.entity.Post;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class PostDto {

    private Long id;
    private String title;
    private String content;
    private Long Uid; //User or Id or Uid
    private String username;
    private LocalDateTime createdDate;
    private String createdBy;


    public PostDto() {
    }

    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.Uid = post.getUser().getId();
        this.username = post.getUser().getUsername();
        this.createdDate = post.getCreatedDate();
        this.createdBy = post.getCreatedBy();
    }

}