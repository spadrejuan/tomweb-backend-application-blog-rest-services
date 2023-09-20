package com.padrejuan.blogapi.Models;

import jakarta.persistence.*;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long post_id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String author_name;
    //  @Column
    //  private Comment[] comments;

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
}
