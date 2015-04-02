package com.lenny.service.impl;

import com.lenny.model.Article;
import com.lenny.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 15/4/1.
 */

@Service("articleService")
public class ArticleService  implements IArticleService{

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 分业查找
     * @param category
     * @param time
     * @param page
     * @return
     */
    @Override
    public List<Article> getByPage(String category, String time, Integer page) {
        List<Article> articles=new ArrayList<Article>();

        Criteria criteria=new Criteria();
        if (!time.equals(null) && !"".equals(time)) {
            criteria = Criteria.where("ptime").regex(".*"+time+".*");
        }
        if(!category.equals(null) && ! "".equals(category)){
            criteria=criteria.where("category").is(category);
        }
        Query query=new Query(criteria);
        query.skip(6*page);
        query.limit(6);
        query.with(new Sort(Sort.Direction.DESC,"ptime"));
        articles=mongoTemplate.find(query,Article.class);
        return articles;
    }


    @Override
    public Article findById(String id) {
        Article article =new Article();
        article =mongoTemplate.findById(id,Article.class);
        return article;
    }
}
