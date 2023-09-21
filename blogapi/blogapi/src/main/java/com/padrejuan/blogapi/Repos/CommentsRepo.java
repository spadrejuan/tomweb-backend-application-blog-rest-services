package com.padrejuan.blogapi.Repos;

import com.padrejuan.blogapi.Models.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepo  extends JpaRepository<Comments, Long> {
}
