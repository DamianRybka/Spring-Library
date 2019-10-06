package com.javagda24.labiblioteca.controller;

import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/ph/")
public class PublishingHouseController {
    @Autowired
    private PublishingHouseService publishingHouseService;

    @GetMapping("/list")
    public String list(Model model) {
        List<PublishingHouse> publishingHouses = publishingHouseService.getAll();
        model.addAttribute("phouses", publishingHouses);

        return "ph-list";
    }

    @GetMapping("/remove")
    public String delete(@RequestParam(name = "phouseId") Long id) {
        publishingHouseService.deleteById(id);

        return "redirect:/ph/list";
    }

    @GetMapping("/add")
    public String addForm(Model model, PublishingHouse publishingHouse){
        model.addAttribute("edited_object", publishingHouse);

        return "ph-form";
    }

    @PostMapping("/add")
    public String save(PublishingHouse publishingHouse){
        publishingHouseService.save(publishingHouse);

        return "redirect:/ph/list";
    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "phouseId") Long id) {
        Optional<PublishingHouse> publishingHouseOptional = publishingHouseService.getById(id);
        if(publishingHouseOptional.isPresent()) {
            model.addAttribute("edited_object", publishingHouseOptional.get());
            return "ph-form";
        }
        return "redirect:/ph/list";
    }
}
