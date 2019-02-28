package com.example.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/*
Create a Spring Boot web application (with Bootstrap) that will allow other classmates to sign up on the CodeAcademy Potluck Chef list.
Each user should be able to provide their name, the dish they're bringing, and an image of that dish.

The application should allow users to add new dishes, update dishes and delete dishes.

Images for dishes can also be updated and the image for an existing dish should show on the form page when loading a sign-up record for updating.
 */

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String dishName;

    @NotNull
    private String dishImg;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishImg() {
        return dishImg;
    }

    public void setDishImg(String dishImg) {
        this.dishImg = dishImg;
    }
}
