package com.lenny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by apple on 15/3/31.
 */
@Controller
public class HomeController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping(value = "/index.do")
    public String show(){
        return "index";
    }



}
