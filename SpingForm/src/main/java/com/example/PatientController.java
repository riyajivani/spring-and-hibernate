package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class PatientController {

    @RequestMapping("/appointment")
    public ModelAndView appointment(Model model){

        Patient patient = new Patient();

        patient.setPatientGender("Male");
        model.addAttribute("countryList", Arrays.asList("India","USA","UK","Canada"));
        model.addAttribute("allergyList",Arrays.asList("Peanuts","Dust","Smoke"));

//        patient.setPatientName("patient name");
//        patient.setPatientContact("xxxxxxxxx");
//        patient.setReceiveNewsletter(true);
//        patient.setInterests(new String[] {"food"});
//        patient.setFavouriteWord("myself");


        return new ModelAndView("appointment","patient",patient);
    }

    @PostMapping("/addappointment")
    public ModelAndView addAppointment(@ModelAttribute Patient patient)
    {
        ModelAndView modelAndView = new ModelAndView("addappointment");
        modelAndView.addObject("message","we have registered your detail sucessfully");
        return modelAndView;
    }

    @ModelAttribute
    public void addingCommonObject(Model model)
    {
        model.addAttribute("mainHeader","welcome to the best clinic");
    }
}
