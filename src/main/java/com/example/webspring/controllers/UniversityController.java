package com.example.webspring.controllers;

import com.example.webspring.entity.University;
import com.example.webspring.repositories.UniversityRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UniversityController {
    @Autowired
    private UniversityRopository universityRopository;
    @RequestMapping(value = "university/add", method = RequestMethod.GET)
    public String showForm(@ModelAttribute University university, Model model){
        model.addAttribute("university", new University());
        return "add_university";

    }

    @RequestMapping(value = "/university/add", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute University university, Model model){
        universityRopository.save(university);
        model.addAttribute("addInfo", university.getUniversityName());
        return "add_university";
    }
}
