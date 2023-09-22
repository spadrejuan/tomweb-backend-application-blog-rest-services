package com.padrejuan.blogapi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
//We first make our column names for the Spring Data JPA repository found in the Repos folder.
@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Comments {
//    We auto generate our primary key for this table using @GeneratedValue
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;
    @Column
    private String commenter_name;
    @Column
    private String comment_body;
//    Our foreign key for our Many-One relationship between posts and comments
    @Column
    private Long post_id;

//    setters and getters
    public long getComment_id() {
        return comment_id;
    }
    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }
    public String getCommenter_name() {
        return commenter_name;
    }
    public void setCommenter_name(String commenter_name) {
        this.commenter_name = commenter_name;
    }
    public String getComment_body() {
        return comment_body;
    }
    public void setComment_body(String comment_body) {
        this.comment_body = comment_body;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }
}
