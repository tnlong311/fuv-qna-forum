package com.qnaforum.webapp.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "post", uniqueConstraints = { @UniqueConstraint(columnNames = { "Pid" })})
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pid")
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @CreatedDate
    @Column(name = "DateCreated")
    private LocalDateTime createdDate = LocalDateTime.now();


//    @Column(name = "Like")
//    private int like; //int or Long?

    @CreatedBy
    @Column(name = "CreateBy", length = 50, updatable = false)
    private String createdBy;

    @ManyToOne(fetch = FetchType.LAZY) //LAZY or  EAGER?
    @JoinColumn(name = "Uid", nullable = false)
    private User user;


}
