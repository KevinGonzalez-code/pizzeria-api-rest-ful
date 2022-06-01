package com.kevin.pizzeria.hateoas.assemblers;

import com.kevin.pizzeria.controllers.IngredienteController;
import com.kevin.pizzeria.entities.Ingrediente;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class IngredienteModelAssembler implements RepresentationModelAssembler<Ingrediente,EntityModel<Ingrediente>>{

    @Override
    public EntityModel<Ingrediente> toModel(Ingrediente ingrediente) {
        return EntityModel.of(ingrediente, 
        linkTo(methodOn(IngredienteController.class).getAllIngredientes()).withSelfRel());
    }
    

}
