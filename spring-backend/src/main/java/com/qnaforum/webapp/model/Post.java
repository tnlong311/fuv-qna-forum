package com.qnaforum.webapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "POST", uniqueConstraints = { @UniqueConstraint(columnNames = { "Pid" })})
public class Post {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Content")
    private String content;

    @CreatedDate
    @Column(name = "DateCreated")
    private LocalDateTime createdDate = LocalDateTime.now();

    @CreatedDate
    @Column(name = "Like")
    private int like; //int or Long?

    @ManyToOne(fetch = FetchType.LAZY) //LAZY or  EAGER?
    @JoinColumn(name = "Uid")
    private User user;

//    @JsonIgnore
//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Comment> comments;

}
