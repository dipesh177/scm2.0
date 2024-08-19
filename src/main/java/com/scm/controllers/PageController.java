package com.scm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    
    @RequestMapping("/home")
    public String home(Model model){
        // sending data to view
        System.out.println("home page handler");
        model.addAttribute("name", "substrings");
        model.addAttribute("youtube", "DipeshChoudhary");
        model.addAttribute("youtube","https://www.youtube.com/@dipeshchoudharyYT/featured");

        return "home";
    }

    @RequestMapping("/about")
    public String aboutpage(){
        System.out.println("This is about page");
        return "about";
    }

    @RequestMapping("/services")
    public String servicepage(){
        System.out.println("This is services page");
        return "services";
    }
}
    

