package com.lenny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by apple on 15/4/3.
 */

@Controller
@RequestMapping("/time")
public class TimeController {

    @RequestMapping("/show")
    public String show(String post,Model model){
        model.addAttribute("time",post);
        return "index";
    }
}
