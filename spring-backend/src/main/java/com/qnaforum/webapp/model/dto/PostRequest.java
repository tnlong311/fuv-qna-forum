package com.qnaforum.webapp.model.dto;

import com.qnaforum.webapp.model.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostRequest {

    private Long Pid;
    private String title;
    private String content;
    private Long Uid; //User or Id or Uid
    /*private String username;*/
    private LocalDateTime createdDate;
    /*private String createdBy;*/


    public PostRequest() {
    }

    public PostRequest(Post post) {
        this.Pid = post.getPid();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.Uid = post.getUser().getUid();
        /*this.username = post.getUser().getUsername();*/
        this.createdDate = post.getCreatedDate();
        /*this.createdBy = post.getCreatedBy();*/
    }

}