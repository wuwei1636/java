package com.li.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class test {

    @PostMapping("/e/t")
    public String test(Model model,String name){

        model.addAttribute("msg",name);
        return "test";
    }

}
