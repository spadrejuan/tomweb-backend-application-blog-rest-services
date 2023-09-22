package com.padrejuan.blogapi.Repos;
// JPA repository to query to the database using built-in methods
import com.padrejuan.blogapi.Models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepo  extends JpaRepository<Posts, Long> {

}
