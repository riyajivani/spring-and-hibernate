package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap modelMap){

//        ModelAndView modelAndView = new ModelAndView("welcome");
//        modelAndView.addObject("welcomeMessage","welcome to spring mvc");
//        return modelAndView;

        modelMap.addAttribute("welcomeMessage","welcome to spring mvc");
        return "welcome";
    }
}
