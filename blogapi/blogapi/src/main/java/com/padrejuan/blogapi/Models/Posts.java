package com.padrejuan.blogapi.Models;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.*;

@Entity
@JsonInclude(JsonInclude.Include.ALWAYS)
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id", updatable = false, insertable = false)
    private Set<Comments> comments;

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
