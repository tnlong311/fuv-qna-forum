package com.qnaforum.webapp.model.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post", uniqueConstraints = { @UniqueConstraint(columnNames = { "pid" })})
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Long pid;

    @NotEmpty(message = "Title must not be empty")
    @Column(name = "Title")
    private String title;

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


    public Post(String title, String content, LocalDateTime createdDate, User user) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.user = user;
    }
}
