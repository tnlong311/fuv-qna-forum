package com.qnaforum.webapp.repository;

import com.qnaforum.webapp.model.entity.Post;
import com.qnaforum.webapp.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    /*Page<Post> findByUserOrderByCreatedDateDesc(User user, Pageable pageable);*/

    Page<Post> findAllByOrderByCreatedDateDesc(Pageable pageable);

    /*Page<Post> findByCreatedBy(Long userId, Pageable pageable);*/

    /*Long countByCreatedBy(Long userId);*/


}

