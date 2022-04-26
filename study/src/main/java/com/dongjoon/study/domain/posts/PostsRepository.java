package com.dongjoon.study.domain.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(value = "select * from dongjun where keyword =:kw", nativeQuery = true)
    List<Posts> postsearch(@Param("kw") String kw);
}
