package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.CommentsRepo;
import com.padrejuan.blogapi.Repos.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PostsController {
    @Autowired
    private PostsRepo postsRepo;
    //    TODO: Add JSON response when posts are null
    @GetMapping(value = "/posts")
    public ResponseEntity<List<Posts>> getPosts(){
        List<Posts> allPosts = postsRepo.findAll();
        if (allPosts.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        else
            return new ResponseEntity<>(allPosts, HttpStatus.OK);
    }


//    TODO: Add error exception/JSON  response when posts are null
//    TODO: InternalServerError when out of bounds
    @GetMapping(value = "/posts/{post_id}")
    public ResponseEntity<Posts> getSpecificPost(@PathVariable long post_id){
        Posts specificPost = postsRepo.findById(post_id).get();
        if (specificPost == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(specificPost, HttpStatus.OK);
    }
    @PostMapping(value = "/posts")
    public ResponseEntity<Posts> savePost(@RequestBody Posts post){
        Posts newPost = postsRepo.save(post);
        return new ResponseEntity<>(newPost, HttpStatus.OK);
    }


//    TODO: Add error exception/JSON  response when posts are null
    //    TODO: InternalServerError when out of bounds

    @PatchMapping(value ="/posts/{post_id}")
    public ResponseEntity<Posts> editPost(@PathVariable long post_id, @RequestBody Posts post){
        Posts editedPost = postsRepo.findById(post_id).get();
        if (editedPost == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            editedPost.setTitle(post.getTitle());
            editedPost.setContent(post.getContent());
            editedPost.setAuthor_name(post.getAuthor_name());
            postsRepo.save(editedPost);
            return new ResponseEntity<>(editedPost, HttpStatus.OK);
        }
    }

//    TODO: Add boolean response when successfully deleted
//    TODO: Comments must also be deleted
    @DeleteMapping(value ="/posts/{post_id}")
    public ResponseEntity<Posts> deletePost(@PathVariable long post_id){
        Posts deletePost = postsRepo.findById(post_id).get();
        if(deletePost == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            postsRepo.deleteById(post_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//    TODO:
//    Pagination
//    Search filters


}
