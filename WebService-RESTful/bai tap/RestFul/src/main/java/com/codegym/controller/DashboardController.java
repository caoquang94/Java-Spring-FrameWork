package com.codegym.controller;

import com.codegym.service.CustomerService;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class DashboardController extends AdminBaseController{
    @GetMapping("/")
    public String dashboard(){
        return "admin/dashboard";
    }
    private String TERM = "Customer";
    private String TERM1= "Province";
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/customer-datatables-ajax/")
    public ModelAndView customerDataTablesAjax(){

        ModelAndView modelAndView = new ModelAndView("/admin/customer");
        modelAndView.addObject("title",TITLE_ADD);
        modelAndView.addObject("term",TERM);
        return modelAndView;
    }

    @GetMapping("/province-datatables-ajax/")
    public ModelAndView provinceDataTablesAjax(){
        ModelAndView modelAndView = new ModelAndView("/admin/province");
        modelAndView.addObject("title",TITLE_ADD);
        modelAndView.addObject("term",TERM1);
        return modelAndView;
    }
}
