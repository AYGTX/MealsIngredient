package com.example.demo.controller;

import com.example.demo.model.Ingredients;
import com.example.demo.repository.IngredientsRepository;
import com.example.demo.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
public class IngredientsController {


    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Autowired
    private MealsRepository mealsRepository;

    @GetMapping("meals/{mealId}/ingredients")
    public Page<Ingredients> getAllIngredientsByMealId(@PathVariable(value = "mealId") Long mealId, Pageable pageable) {
        return ingredientsRepository.findByMealId(mealId, pageable);
    }

    @PostMapping("meals/{mealId}/ingredients")
    public Ingredients createIngredients(@PathVariable (value = "mealId") Long mealId,
                                         @Valid @RequestBody Ingredients ingredient) {
        return mealsRepository.findById(mealId).map(meals -> {
            ingredient.setMeal(meals);
            return ingredientsRepository.save(ingredient);
        }).orElseThrow(() -> new ResourceNotFoundException("mealId " + mealId + " not found"));
    }
@PutMapping("meals/{mealId}/ingredients")
    public String update(){
        return "text";
}

}
