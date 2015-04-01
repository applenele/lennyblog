package com.lenny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by apple on 15/3/31.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/index.do")
    public String show(){
        return "index";
    }
    
}
