package com.example.demo.repository;

import com.example.demo.model.Meals;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MealsRepository extends JpaRepository<Meals, Long> {


}
