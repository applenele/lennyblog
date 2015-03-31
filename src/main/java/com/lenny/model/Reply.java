package com.lenny.model;

/**
 * Created by apple on 15/3/31.
 */
public class Reply {
    private  String content;

    public Reply(){}

    public Reply(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "content='" + content + '\'' +
                '}';
    }
}
