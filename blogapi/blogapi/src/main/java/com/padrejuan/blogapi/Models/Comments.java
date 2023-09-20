package com.padrejuan.blogapi.Models;

import jakarta.persistence.*;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comment_id;
    @Column
    private String commenter_name;
    @Column
    private String comment_body;
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
}
