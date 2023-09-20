package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Comments;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.CommentsRepo;
import com.padrejuan.blogapi.Repos.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class APIControllers {
    @Autowired
    private PostsRepo postsRepo;
    @Autowired
    private CommentsRepo commentsRepo;

    @GetMapping("/")
    public String getPage(){
        return "Welcome!";
    }

    @GetMapping(value = "/posts")
    public List<Posts> getPosts(){
        return postsRepo.findAll();
    }

    @GetMapping(value = "/posts/{post_id}")
    public String getSpecificPost(@PathVariable long post_id, @RequestBody Posts post){
        Posts specificPost = postsRepo.findById(post_id).get();
        return "Gotcha!!";
    }

    @PostMapping(value = "/posts")
    public String savePost(@RequestBody Posts post){
        postsRepo.save(post);
        return "Saved!!";
    }

    @PatchMapping(value ="/posts/{post_id}")
    public String editPost(@PathVariable long post_id, @RequestBody Posts post){
        Posts editedPost = postsRepo.findById(post_id).get();
        editedPost.setTitle(editedPost.getTitle());
        editedPost.setContent(editedPost.getContent());
        editedPost.setAuthor_name(editedPost.getAuthor_name());
        return "Updated!";
    }

    @DeleteMapping(value ="/posts/{post_id}")
    public String deletePost(@PathVariable long post_id){
        Posts deletePost = postsRepo.findById(post_id).get();
        postsRepo.delete(deletePost);
        return "Deleted post with id number: " + post_id;
    }

    @PostMapping(value ="/comment")
    public String createComment(@RequestBody Comments comment){
        commentsRepo.save(comment);
        return "Comment Added!!";
    }

    @PatchMapping(value ="/comment/{comment_id}")
    public String editComment(@PathVariable long comment_id, @RequestBody Comments comment){
        Comments editedComment = commentsRepo.findById(comment_id).get();
        editedComment.setCommenter_name(editedComment.getCommenter_name());
        editedComment.setComment_body(editedComment.getComment_body());
        return "Comment Edited!!";
    }

    @DeleteMapping(value ="/comment/{comment_id}")
    public String deleteComment(@PathVariable long comment_id){
        Comments deleteComment = commentsRepo.findById(comment_id).get();
        commentsRepo.delete(deleteComment);
        return "Comment deleted with id number: " + comment_id;
    }

}
