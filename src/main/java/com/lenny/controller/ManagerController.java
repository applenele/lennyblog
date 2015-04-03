package com.lenny.controller;

import com.github.rjeschke.txtmark.Processor;
import com.lenny.model.Article;
import com.lenny.model.Reply;
import com.lenny.model.Tag;
import com.lenny.repository.ArticleRepo;
import org.markdown4j.Markdown4jProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by apple on 15/3/31.
 */
@Controller
@RequestMapping("/manage")
public class ManagerController {

    @Autowired
    private ArticleRepo articleRepo;

    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String login() {
        return "./manager/login";
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String doLogin(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("lenny19920716")) {
            return "ok";
        } else {
            return "no";
        }
    }

    @RequestMapping(value = "/index.do",method = RequestMethod.GET)
    public String index(){
       return "./manager/index";
    }

    @RequestMapping(value = "/addArticle.do", method = RequestMethod.GET)
    public String addArticle() {
        return "./manager/addArticle";
    }

    @RequestMapping(value = "/addArticle.do",method = RequestMethod.POST)
    @ResponseBody
    public String doAddArticle(@RequestParam String title,@RequestParam String content,@RequestParam String category,@RequestParam String tags) {
        try {
            content = new Markdown4jProcessor().process(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Tag> tagList =new ArrayList<Tag>();
        if(!"".equals(tags)){
            String[] tagArr=tags.split(",");
            for (String stag : tagArr){
                Tag tag =new Tag(stag);
                tagList.add(tag);
            }
        }
        String uuid=UUID.randomUUID().toString();
        String ptime= LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        Article article=new Article(content,0,uuid,0,ptime,new ArrayList<Reply>(),tagList,title,category);
        articleRepo.save(article);
        return "ok";
    }
}
