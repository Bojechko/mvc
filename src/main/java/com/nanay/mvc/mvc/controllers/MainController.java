package com.nanay.mvc.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/hello/{name}")
    public String showTable(Model model, @PathVariable(value = "name") String name){
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/index")
    public String showTable(){
        return "index";
    }
}
