package com.padrejuan.blogapi.Repos;
// JPA repository to query to the database using built-in methods
import com.padrejuan.blogapi.Models.Comments;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepo  extends JpaRepository<Comments, Long> {
}
