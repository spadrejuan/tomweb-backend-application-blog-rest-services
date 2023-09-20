package com.padrejuan.blogapi.Repos;

import com.padrejuan.blogapi.Models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo  extends JpaRepository<Comments, Long> {
}
