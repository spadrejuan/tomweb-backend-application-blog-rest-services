package com.padrejuan.blogapi.Repos;

import com.padrejuan.blogapi.Models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo  extends JpaRepository<Posts, Long> {

}
