package com.kevin.pizzeria.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.kevin.pizzeria.entities.Ingrediente;
import com.kevin.pizzeria.hateoas.assemblers.IngredienteModelAssembler;
import com.kevin.pizzeria.services.interfaces.IIngredienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredienteController {
    
    @Autowired
    private IIngredienteService ingredienteService;

    @NonNull
    private final IngredienteModelAssembler assembler;


    @GetMapping
    public CollectionModel<EntityModel<Ingrediente>> getAllIngredientes(){
        List<Ingrediente> ingredientes = ingredienteService.getAllIngredientes();

        var ingredientesHiperMedia = ingredientes.stream()
                                                 .map(assembler::toModel)
                                                 .collect(Collectors.toList());

        return CollectionModel.of(ingredientesHiperMedia);
    }



}
