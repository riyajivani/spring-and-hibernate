package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/welcome/{countryName}/{userName}", method = RequestMethod.GET)

    //public String welcome(ModelMap modelMap, @PathVariable("countryName") String countryName, @PathVariable("userName") String userName){

    public String welcome(ModelMap modelMap, @PathVariable Map<String,String> pathVars){

        //modelMap.addAttribute("welcomeMessage","welcome to spring mvc");
        //modelMap.addAttribute("welcomeMessage",String.format("welcome %s from %s",userName,countryName));
        modelMap.addAttribute("welcomeMessage",String.format("welcome %s from %s",
                pathVars.get("userName"),
                pathVars.get("countryName")));

        return "welcome";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(ModelMap modelMap){

        modelMap.addAttribute("exitMessage","Goodbye from Spring MVC");
        return "exit";
    }


}
