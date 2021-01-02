package com.example.demo.repository;

import com.example.demo.model.Ingredients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {
    Page<Ingredients> findByMealId(Long mealId, Pageable pageable);
    Optional<Ingredients> findByIdAndMealId(Long id, Long mealId);
}
