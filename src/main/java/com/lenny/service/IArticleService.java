package com.lenny.service;

import com.lenny.model.Article;

import java.util.List;

/**
 * Created by apple on 15/4/1.
 */
public interface IArticleService {

    List<Article>  getByPage(String category,String ptime,Integer page);

    Article findById(String id);
}
