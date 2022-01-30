package com.example.demo.controllers;

import com.example.demo.models.PlantInventoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.example.demo.models.PlantInventoryEntryRepository;

@Controller
public class PlantInventoryEntryController {
    @Autowired
    PlantInventoryEntryRepository repo;

    @GetMapping("/plants")

    public String list(Model model){

        model.addAttribute("plants", repo.findAll());
        System.out.println("Plants List");
        return "plants/list";

    }

    @GetMapping(value="/plants/form")
    public String form(Model model)
    {
        model.addAttribute("plant", new PlantInventoryEntry());
        System.out.println("Plants Create");
        return "plants/create";
    }

    @PostMapping(value="/plants")
    public String create(PlantInventoryEntry plant) {

        repo.save(plant);
        return "redirect:/plants";

    }
}