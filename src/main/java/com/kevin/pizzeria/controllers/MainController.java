package com.kevin.pizzeria.controllers;

import java.util.List;

import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.services.interfaces.IPizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private IPizzaService pizzaService;
    
    @GetMapping("/pizzas")
    public List<Pizza> getPizzas(){
        return pizzaService.getAllPizzas();
    }

    @PostMapping("/pizzas/add")
    public void addPizza(@RequestBody Pizza pizza){        
        pizzaService.save(pizza);
    }

    @GetMapping("/pizzas/{id}")
    public Pizza getPizzaById(@PathVariable Long id){
        return pizzaService.getPizzaById(id);
    }
}
