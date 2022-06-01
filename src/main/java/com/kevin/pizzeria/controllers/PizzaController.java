package com.kevin.pizzeria.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.kevin.pizzeria.entities.Ingrediente;
import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.hateoas.assemblers.PizzaModelAssembler;
import com.kevin.pizzeria.services.interfaces.IIngredienteService;
import com.kevin.pizzeria.services.interfaces.IPizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    @Autowired
    private IPizzaService pizzaService;

    @NonNull
    private final PizzaModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Pizza>> getPizzas() {



        List<Pizza> pizass = pizzaService.getAllPizzas();

        var pizzasHiperMedia = pizass.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(pizzasHiperMedia);
    }

    @GetMapping("/{id}")
    public EntityModel<Pizza> getPizzasById(@PathVariable long id) {
        return assembler.toModel(pizzaService.getPizzaById(id));
    }

     @PostMapping("/pizzas/add")
     public ResponseEntity<Pizza> addPizza(@RequestBody Pizza pizza) {
         return new ResponseEntity<Pizza>(pizzaService.save(pizza), HttpStatus.CREATED);
    }



}