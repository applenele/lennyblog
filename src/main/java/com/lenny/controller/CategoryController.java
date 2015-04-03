package com.lenny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by apple on 15/4/3.
 */


@Controller
@RequestMapping("/category")
public class CategoryController {

    @RequestMapping("/show.do")
    public String show(String post,Model model){
        model.addAttribute("category",post);
        return "index";
    }
}
