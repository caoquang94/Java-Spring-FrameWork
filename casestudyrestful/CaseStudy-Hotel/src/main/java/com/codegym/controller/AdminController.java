package com.codegym.controller;

import com.codegym.service.PoliceCityService;
import com.codegym.service.PoliceProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController extends AdminBaseController {
    @GetMapping("/")
    public String dashboard1(){
        return "admin/dashboard1";
    }
    private String TERM1 = "PoliceProvince";
    private String TERM2 = "PoliceCity";
    private String TERM3 = "Area";

    @Autowired
    private PoliceProvinceService policeProvinceService;
    @Autowired
    private PoliceCityService policeCityService;

    @GetMapping("/police-province/")
    public ModelAndView policeProvinceDataTableAjax(){
        ModelAndView modelAndView = new ModelAndView("police/policeprovince");
        modelAndView.addObject("main", MAIN_POLICE);
        modelAndView.addObject("title", TITLE_ADD);
        modelAndView.addObject("term", TERM1);
        return modelAndView;
    }

    @GetMapping("/police-city/")
    public ModelAndView policeCityDataTableAjax() {
        ModelAndView modelAndView = new ModelAndView("police/policecity");
        modelAndView.addObject("main", MAIN_POLICE);
        modelAndView.addObject("title", TITLE_ADD);
        modelAndView.addObject("term", TERM2);
        return modelAndView;
    }

    @GetMapping("/area/")
    public ModelAndView areaDataTableAjax() {
        ModelAndView modelAndView = new ModelAndView("police/area");
        modelAndView.addObject("main", MAIN_POLICE);
        modelAndView.addObject("title", TITLE_ADD);
        modelAndView.addObject("term", TERM3);
        return modelAndView;
    }
}
