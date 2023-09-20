package com.padrejuan.blogapi.Controllers;
import com.padrejuan.blogapi.Models.Posts;
import com.padrejuan.blogapi.Repos.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PostsController {
    @Autowired
    private PostsRepo postsRepo;
    @GetMapping("/")
    public String getPage(){
        return "Welcome!";
    }

    //CHECK
    @GetMapping(value = "/posts")
    public List<Posts> getPosts(){
        return postsRepo.findAll();
    }

    //CHECK
//    TODO: Add exception error if there are no posts with post_id
    @GetMapping(value = "/posts/{post_id}")
    public Posts getSpecificPost(@PathVariable long post_id){
        return postsRepo.findById(post_id).get();
    }

    // CHECK
    @PostMapping(value = "/posts")
    public String savePost(@RequestBody Posts post){
        postsRepo.save(post);
        return "Saved!!";
    }


    //CHECK
    @PatchMapping(value ="/posts/{post_id}")
    public String editPost(@PathVariable long post_id, @RequestBody Posts post){
        Posts editedPost = postsRepo.findById(post_id).get();
        editedPost.setTitle(post.getTitle());
        editedPost.setContent(post.getContent());
        editedPost.setAuthor_name(post.getAuthor_name());
        postsRepo.save(editedPost);
        return "Updated!";
    }

    //CHECK
    @DeleteMapping(value ="/posts/{post_id}")
    public String deletePost(@PathVariable long post_id){
        Posts deletePost = postsRepo.findById(post_id).get();
        postsRepo.delete(deletePost);
        return "Post deleted with id number: " + post_id;
    }

}
