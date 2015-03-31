package com.lenny.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by apple on 15/3/31.
 */
@Document(collection = "articles")
public class Article {

    @Id
    private String id;

    private String title;

    private String content;

    private String ptime;

    private List<Reply> replies;

    private  List<Tag> tags;

    private Integer hit;

    private Integer commentnum;


    public Article() {
    }

    public Article(String content, Integer hit, String id, Integer commentnum, String ptime, List<Reply> replies, List<Tag> tags, String title) {
        this.content = content;
        this.hit = hit;
        this.id = id;
        this.commentnum = commentnum;
        this.ptime = ptime;
        this.replies = replies;
        this.tags = tags;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setOmmentnum(Integer ommentnum) {
        this.commentnum = ommentnum;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "content='" + content + '\'' +
                ", hit=" + hit +
                ", id='" + id + '\'' +
                ", ommentnum=" + commentnum +
                ", ptime='" + ptime + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
