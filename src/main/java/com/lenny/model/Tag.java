package com.lenny.model;

/**
 * Created by apple on 15/3/31.
 */
public class Tag {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "content='" + content + '\'' +
                '}';
    }

    public Tag() {
    }

    public Tag(String content) {
        this.content = content;
    }
}
