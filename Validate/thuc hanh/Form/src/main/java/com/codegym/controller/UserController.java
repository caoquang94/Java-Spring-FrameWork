package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/user",produces = "application/json;charset=UTF-8")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @GetMapping("/showUser")
    public ModelAndView showValidation(){
        Iterable<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("users", users);
        return modelAndView;
    }
    @PostMapping("/show-User")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }
        userService.save(user);
        Iterable<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("users",users);

        return modelAndView;
    }

    @GetMapping("/view-user/{id}")
    public ModelAndView viewUser(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null){
            ModelAndView modelAndView = new ModelAndView("view");
            modelAndView.addObject("user", user);
            return  modelAndView;
        }else {
            return new ModelAndView("/error.404");
        }
    }

    @GetMapping("/edit-user/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null){
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("user", user);
            return  modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-user")
    public ModelAndView updateUser(@ModelAttribute("user") User user){
    userService.save(user);
    ModelAndView modelAndView = new ModelAndView("edit");
    modelAndView.addObject("user", user);
    modelAndView.addObject("message", "User updated successfuly");
    return modelAndView;
    }

    @GetMapping("/delete-user/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        User user = userService.findById(id);
        if(user != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("user", user);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-user")
    public String deleteCustomer(@ModelAttribute("user") User user){
        userService.remove(user.getId());
        return "redirect:showUser";
    }

}
