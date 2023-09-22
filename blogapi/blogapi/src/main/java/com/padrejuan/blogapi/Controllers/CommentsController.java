package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Comments;
import com.padrejuan.blogapi.Repos.CommentsRepo;
import com.padrejuan.blogapi.Repos.PostsRepo;
import com.padrejuan.blogapi.Response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
public class CommentsController {
    // declare repositories for JPA function calls
    @Autowired
    private PostsRepo postsRepo;
    @Autowired
    private CommentsRepo commentsRepo;
    //  From this point, we annotate with @Mappings to declare our functions
//    Method to comment in the database. If there are no posts, return with a message and null value for both post and commeny
//    Returns the newly saved comment back to the user along with the foreign key.
//    Returns a no post message when no post exists
    @PostMapping(value ="/comment")
    public ResponseEntity<Object> createComment(@RequestBody Comments comment){
        try {
            Comments newComment = commentsRepo.save(comment);
            return new ResponseEntity<>(newComment, HttpStatus.OK);
        } catch(Exception e) {
                return ResponseHandler.postNotFound("There are no posts with the id: " + comment.getPost_id(), HttpStatus.NOT_FOUND,null, null);
        }
    }

    //    Edits a comment through URL input, use setters and getters to replace/retain values.
//    Returns the newly edited comment
//    returns the same error message when there are no comments of that id
    @PatchMapping(value ="/comment/{comment_id}")
    public ResponseEntity<Object> editComment(@PathVariable long comment_id, @RequestBody Comments comment){
        try {
            Comments editedComment = commentsRepo.findById(comment_id).get();
            editedComment.setCommenter_name(comment.getCommenter_name());
            editedComment.setComment_body(comment.getComment_body());
            commentsRepo.save(editedComment);
            return new ResponseEntity<>(editedComment, HttpStatus.OK);
        } catch(NoSuchElementException nee) {
            return ResponseHandler.commentNotFound("There are no comments with the id: " + comment_id, HttpStatus.NOT_FOUND,null);
        }
        catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
    //    Deletes a comment. We declare a boolean flag to use the functions in our ResponseHandler.
//        We return with a message if successful/!successful along with the status code and our flag
    @DeleteMapping(value ="/comment/{comment_id}")
    public ResponseEntity<Object> deleteComment(@PathVariable long comment_id){
        try {
            Comments deleteComment = commentsRepo.findById(comment_id).get();
            commentsRepo.deleteById(comment_id);
            boolean delFlag = true;
            return ResponseHandler.commentDeleted("Successfully deleted comment with the id: " + comment_id, HttpStatus.OK, delFlag);
        } catch(NoSuchElementException nee) {
            boolean delFlag = false;
            return ResponseHandler.commentDeleted("There are no comments with the id: " + comment_id, HttpStatus.NOT_FOUND, delFlag);
        }
        catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
}
