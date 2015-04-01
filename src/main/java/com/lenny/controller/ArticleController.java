package com.lenny.controller;

import com.lenny.model.Article;
import com.lenny.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by apple on 15/4/1.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @RequestMapping(value = "/getArticles.do",method = RequestMethod.POST)
    @ResponseBody
    public List<Article> getArticles(String category, String time, Integer page) {
        System.out.println(category+time+page);
        List<Article> articles = articleService.getByPage(category, time, page);
        return articles;
    }
}
