package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Comments;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.CommentsRepo;
import com.padrejuan.blogapi.Repos.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
public class CommentsController {
    @Autowired
    private PostsRepo postsRepo;
    @Autowired
    private CommentsRepo commentsRepo;
    //    TODO: InternalServerError when out of bounds
    @PostMapping(value ="/comment")
    public ResponseEntity<Comments> createComment(@RequestBody Comments comment){
        Comments newComment = commentsRepo.save(comment);
        return new ResponseEntity<>(newComment, HttpStatus.OK);
    }

    //    TODO: InternalServerError when out of bounds
    @PatchMapping(value ="/comment/{comment_id}")
    public ResponseEntity<Comments> editComment(@PathVariable long comment_id, @RequestBody Comments comment){
        Comments editedComment = commentsRepo.findById(comment_id).get();
        if (editedComment == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else{
            editedComment.setCommenter_name(comment.getCommenter_name());
            editedComment.setComment_body(comment.getComment_body());
            commentsRepo.save(editedComment);
            return new ResponseEntity<>(editedComment, HttpStatus.OK);
        }
    }

    //    TODO: Add boolean response when successfully deleted
    @DeleteMapping(value ="/comment/{comment_id}")
    public ResponseEntity<Comments> deleteComment(@PathVariable long comment_id){
        Comments deleteComment = commentsRepo.findById(comment_id).get();
        if (deleteComment == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else{
            commentsRepo.deleteById(comment_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}
