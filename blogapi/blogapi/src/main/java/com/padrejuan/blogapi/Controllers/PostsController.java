package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.PostsRepo;
import com.padrejuan.blogapi.Response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class PostsController {
    // declare repositories for JPA function calls
    @Autowired
    private PostsRepo postsRepo;
//  From this point, we annotate with @Mappings to declare our functions
//    Method to get posts in the database. If there are no posts, return with a message and null value
//    Returns a ResponseEntity object when successfully retrieved from the database
    @GetMapping(value = "/posts")
    public ResponseEntity<Object> getPosts(){
        try {
            List<Posts> allPosts = postsRepo.findAll();
            if (allPosts.isEmpty())
                return ResponseHandler.postNotFound("There are no posts lately", HttpStatus.NOT_FOUND, null);
            else
                return new ResponseEntity<>(allPosts, HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
         }
    }

//    Get a specific post through inputting an ID in the url. Same functionalities,
//    but this time, findByID is used
    @GetMapping(value = "/posts/{post_id}")
    public ResponseEntity<Object> getSpecificPost(@PathVariable long post_id) {
        try {
            Posts specificPost = postsRepo.findById(post_id).get();
            return new ResponseEntity<>(specificPost, HttpStatus.OK);
        } catch(NoSuchElementException nee) {
            return ResponseHandler.postNotFound("There are no posts with the id: " + post_id, HttpStatus.NOT_FOUND,null);
        }
           catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
           }
    }
//    Saves a post using .save method in JPA repository. Returns the newly saved post
    @PostMapping(value = "/posts")
    public ResponseEntity<Object> savePost(@RequestBody Posts post){
        try {
            Posts newPost = postsRepo.save(post);
            return new ResponseEntity<>(newPost, HttpStatus.OK);
        } catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }

//    Edits  a posts through URL input, use setters and getters to replace/retain values.
//    Returns the newly edited post, if there are no posts with given id, returns an error msg
    @PatchMapping(value ="/posts/{post_id}")
    public ResponseEntity<Object> editPost(@PathVariable long post_id, @RequestBody Posts post){
        try {
            Posts editedPost = postsRepo.findById(post_id).get();
            editedPost.setTitle(post.getTitle());
            editedPost.setContent(post.getContent());
            editedPost.setAuthor_name(post.getAuthor_name());
            postsRepo.save(editedPost);
            return new ResponseEntity<>(editedPost, HttpStatus.OK);
        } catch(NoSuchElementException nee) {
            return ResponseHandler.postNotFound("There are no posts with the id: " + post_id, HttpStatus.NOT_FOUND,null);
        }
          catch(Exception e) {
            return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
        }
    }
//    Deletes a post. We declare a boolean flag to use the functions in our ResponseHandler.
//        We return with a message if successful/!successful along with the status code and our flag
    @DeleteMapping(value ="/posts/{post_id}")
    public ResponseEntity<Object> deletePost(@PathVariable long post_id){
        try {
            Posts deletePost = postsRepo.findById(post_id).get();
            postsRepo.deleteById(post_id);
            boolean delFlag = true;
            return ResponseHandler.postDeleted("Successfully deleted post with id: " + post_id, HttpStatus.OK, delFlag);
        } catch(NoSuchElementException nee) {
                boolean delFlag = false;
                return ResponseHandler.postDeleted("There are no posts with the id: " + post_id, HttpStatus.NOT_FOUND, delFlag);
            }
                catch(Exception e) {
                return ResponseHandler.genericErrorException(e.getMessage(), HttpStatus.MULTI_STATUS,null);
                }
        }
    }

//    TODO:
//    Pagination
//    Search filters



