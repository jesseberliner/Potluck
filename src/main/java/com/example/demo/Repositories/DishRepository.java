package com.example.demo.Repositories;

import com.example.demo.Models.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Long> {
}
