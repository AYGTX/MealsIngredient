package com.example.demo.controller;


import com.example.demo.model.Meals;
import com.example.demo.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MealsController {

    @Autowired
    private MealsRepository mealsRepository;


    @GetMapping("/meals")
    public Page<Meals> getAllMeals(Pageable pageable) {
        return mealsRepository.findAll(pageable);
    }
    @PostMapping("/meals")
    public Meals createMeal(@Valid @RequestBody Meals meal) {
        return mealsRepository.save(meal);
    }
    @PutMapping("/meals")
    public String updateMeal() { return "works"; }
}
