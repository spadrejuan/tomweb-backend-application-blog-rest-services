package com.padrejuan.blogapi.Models;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.*;
//We first make our column names for the Spring Data JPA repository found in the Repos folder.
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Posts {
    //    We auto generate our primary key for this table using @GeneratedValue
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long post_id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String author_name;
//     we connect posts and comments using the @JoinColumn annotation. We specify @OneToMany with attributes like
//    orphanRemoval along with updatable and insertable in the JoinColumn annotation for the purpose of retaining referencial
//    integrity. When we delete a post, we also delete all comments associated with the post.
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id", updatable = false, insertable = false)
    private Set<Comments> comments;

//    setters and getters
    public long getPost_id() {
        return post_id;
    }
    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor_name() {
        return author_name;
    }
    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }
}
