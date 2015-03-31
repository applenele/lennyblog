package com.lenny.repository;

import com.lenny.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by apple on 15/3/31.
 */
public interface ArticleRepo  extends MongoRepository<Article,String> {
}
