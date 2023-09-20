package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Comments;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.CommentsRepo;
import com.padrejuan.blogapi.Repos.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class CommentsController {
    @Autowired
    private PostsRepo postsRepo;
    @Autowired
    private CommentsRepo commentsRepo;

    @PostMapping(value ="/comment")
    public String createComment(@RequestBody Comments comment){
        commentsRepo.save(comment);
        return "Comment Added!!";
    }

    @PatchMapping(value ="/comment/{comment_id}")
    public String editComment(@PathVariable long comment_id, @RequestBody Comments comment){
        Comments editedComment = commentsRepo.findById(comment_id).get();
        editedComment.setCommenter_name(comment.getCommenter_name());
        editedComment.setComment_body(comment.getComment_body());
        commentsRepo.save(editedComment);
        return "Comment Edited!!";
    }

    @DeleteMapping(value ="/comment/{comment_id}")
    public String deleteComment(@PathVariable long comment_id){
        Comments deleteComment = commentsRepo.findById(comment_id).get();
        commentsRepo.delete(deleteComment);
        return "Comment deleted with id number: " + comment_id;
    }
}
