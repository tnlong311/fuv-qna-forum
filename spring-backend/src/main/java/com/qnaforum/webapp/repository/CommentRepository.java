package com.qnaforum.webapp.repository;

import com.qnaforum.webapp.model.entity.Comment;
import com.qnaforum.webapp.model.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  Page<Comment> findByPost_PidOrderByCreatedDateDesc(Long pid, Pageable pageable);

  /*Optional<Comment> findByPost_Pid(Long Pid);*/
}
