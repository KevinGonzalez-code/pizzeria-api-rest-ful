package com.kevin.pizzeria.controllers;

import java.util.List;

import com.kevin.pizzeria.entities.Ingrediente;
import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.services.interfaces.IIngredienteService;
import com.kevin.pizzeria.services.interfaces.IPizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private IIngredienteService ingredienteService;

    @GetMapping("/pizzas")
    public ResponseEntity<List<Pizza>> getPizzas() {
        return new ResponseEntity<List<Pizza>>(pizzaService.getAllPizzas(), HttpStatus.OK);
    }

    @GetMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        if (pizzaService.getPizzaById(id) == null) {
            return new ResponseEntity<Pizza>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<Pizza>(pizzaService.getPizzaById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/pizzas/add")
    public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
        return new ResponseEntity<Pizza>(pizzaService.save(pizza), HttpStatus.CREATED);
    }

    @GetMapping("/ingredients")
    public ResponseEntity<List<Ingrediente>> getAllIngredients(){
        return new ResponseEntity<List<Ingrediente>>(ingredienteService.getAllIngredientes(), HttpStatus.OK);
    }

}
