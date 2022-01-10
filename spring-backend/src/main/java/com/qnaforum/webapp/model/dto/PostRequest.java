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
    private Long Uid;
    private LocalDateTime createdDate;


    public PostRequest() {
    }

    public PostRequest(Post post) {
        this.Pid = post.getPid();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.Uid = post.getUser().getUid();
        this.createdDate = post.getCreatedDate();
    }

}