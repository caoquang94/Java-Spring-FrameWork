package com.codegym.controller.admin;

import com.codegym.model.PetType;
import com.codegym.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @Autowired
    private PetTypeService petTypeService;
    @GetMapping("/admin")
    public String admin(){
        return "admin/dashboard";
    }
    @GetMapping("/tables")
    public ModelAndView showAdmin(Pageable pageable){
        Page<PetType> petTypes = petTypeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("admin/tables");
        modelAndView.addObject("petTypes", petTypes);
        return modelAndView;
    }
    @GetMapping("/user")
    public String user(){
        return "admin/user";
    }
}
