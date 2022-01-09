package com.qnaforum.webapp.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.qnaforum.webapp.model.entity.Post;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = { "Username" })})
public class User {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Uid") //Change from id -> Uid
    private Long Uid;

    @NotBlank
    @Column(name = "Username")
    @Size(max = 40)
    private String username;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(max = 100)
    @Column(name = "Password")
    private String password;

    @NotBlank
    @NaturalId
    @Size(max = 40)
    @Column(name = "Email")
    @Email
    private String email;

    @JsonIgnore //Should add this annotation?
    @OneToMany(mappedBy = "", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


}
