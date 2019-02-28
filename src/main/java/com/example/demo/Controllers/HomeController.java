package com.example.demo.Controllers;

import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Models.Dish;
import com.example.demo.Repositories.DishRepository;
import com.example.demo.Services.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {


    @Autowired
    DishRepository dishRepo;

    @Autowired
    CloudinaryConfig cloudc;

    @RequestMapping("/")
    public String listDishes(Model model)
    {
        model.addAttribute("dishes", dishRepo.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String newDish(Model model)
    {
        model.addAttribute("dish", new Dish());
        return "form";
    }

    @PostMapping("/add")
    public String processDish(@ModelAttribute Dish dish, @RequestParam("file")MultipartFile file, Model model)
    {
        if(file.isEmpty())
        {
            //model.addAttribute("dish", dish);
            return "redirect:/add";
        }
        try {
            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
            dish.setDishImg(uploadResult.get("url").toString());
            dishRepo.save(dish);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/add";
        }
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showDish(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("dish", dishRepo.findById(id).get());
        return "detail";
    }

    @RequestMapping("/update/{id}")
    public String updateDish(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("dish", dishRepo.findById(id).get());
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String delDish(@PathVariable("id") long id)
    {
        dishRepo.deleteById(id);
        return "redirect:/";
    }
}

