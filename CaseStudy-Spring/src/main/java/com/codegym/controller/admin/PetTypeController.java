package com.codegym.controller.admin;

import com.codegym.model.PetType;
import com.codegym.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PetTypeController {
    @Autowired
    private PetTypeService petTypeService;

    @GetMapping("/create-pettype")
    public ModelAndView showFormPetType() {
        ModelAndView modelAndView = new ModelAndView("admin/pettype/create");
        modelAndView.addObject("pettype", new PetType());
        return modelAndView;
    }

    @PostMapping("/create-pettype")
    public ModelAndView savePetType(@Valid @ModelAttribute("pettype")PetType petType, BindingResult bindingResult){
        new PetType().validate(petType, bindingResult);
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("admin/pettype/create");
            return modelAndView;
        } else {
            petTypeService.save(petType);
            ModelAndView modelAndView = new ModelAndView("admin/pettype/create");
            modelAndView.addObject("pettype", petType);
            modelAndView.addObject("message","New Pet Type create successfully");
            return modelAndView;
        }
    }

    @GetMapping("/pettype")
    public ModelAndView listPetType(Pageable pageable){
        Page<PetType> petTypes = petTypeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("admin/pettype/list");
        modelAndView.addObject("pettypes", petTypes);
        return modelAndView;
    }

    @GetMapping("/edit-pettype/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        PetType petType = petTypeService.findById(id);
        if (petType != null){
            ModelAndView modelAndView = new ModelAndView("admin/pettype/edit");
            modelAndView.addObject("pettype", petType);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-pettype")
    public ModelAndView updatePetType(@Valid @ModelAttribute("pettype") PetType petType, BindingResult bindingResult) {
        new PetType().validate(petType, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("admin/pettype/edit");
            return modelAndView;
        } else {
            petTypeService.save(petType);
            ModelAndView modelAndView = new ModelAndView("admin/pettype/edit");
            modelAndView.addObject("pettype", petType);
            modelAndView.addObject("message", "Pet Type updated successfully");
            return modelAndView;
        }
    }

    @GetMapping("delete-pettype/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        PetType petType = petTypeService.findById(id);
        if(petType != null) {
            ModelAndView modelAndView = new ModelAndView("admin/pettype/delete");
            modelAndView.addObject("pettype", petType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deletePetType(@ModelAttribute("pettype") PetType petType){
        petTypeService.findById(petType.getId());
        return "redirect:customers";
    }
}
