package com.lenny.controller;

import com.lenny.model.Article;
import com.lenny.repository.ArticleRepo;
import com.lenny.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 15/4/1.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private ArticleRepo articleRepo;

    @RequestMapping(value = "/getArticles.do", method = RequestMethod.POST)
    @ResponseBody
    public List<Article> getArticles(String category, String time, Integer page) {
        List<Article> articles = articleService.getByPage(category, time, page);
        return articles;
    }

    @RequestMapping(value = "/getCategories.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> getCategories() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Article> articles = articleRepo.findAll();
        for (Article article : articles) {
            if (map.containsKey(article.getCategory())) {
                int count = (int) map.get(article.getCategory());
                map.put(article.getCategory(), count++);
            } else {
                map.put(article.getCategory(), 1);
            }
        }
        return map;
    }


    @RequestMapping(value = "/getTime.do", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Integer> getTime() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Article> articles = articleRepo.findAll();
        for (Article article : articles) {
            String time = article.getPtime().substring(0, 7);
            if (map.containsKey(time)) {
                int count = (int) map.get(time);
                map.put(time, count++);
            } else {
                map.put(time, 1);
            }
        }
        return map;
    }


    @RequestMapping(value = "/show.do", method = RequestMethod.GET)
    public String show(@RequestParam String id, Model model) {
        Article article=articleService.findById(id);
        model.addAttribute("article",article);
        return "show";
    }
}
