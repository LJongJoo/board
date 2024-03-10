package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/random-quote")
    public String randomQuote(Model model) {
        String[] quotes ={
                "명언1" + "-허버드1-",
                "명언2" + "-허버드2-",
                "명언3" + "-허버드3-",
                "명언4" + "-허버드4-",
                "명언5" + "-허버드5-",
                "명언6" + "-허버드6-",
        };
        int randInt = (int)(Math.random()*quotes.length);
        model.addAttribute("randomQuote",quotes[randInt]);
        return "quote";
    }
}
