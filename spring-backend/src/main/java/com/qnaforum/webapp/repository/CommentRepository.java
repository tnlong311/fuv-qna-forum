package com.qnaforum.webapp.repository;

import com.qnaforum.webapp.model.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  Page<Comment> findByPost_PidOrderByCreatedDateDesc(Long pid, Pageable pageable);
}
