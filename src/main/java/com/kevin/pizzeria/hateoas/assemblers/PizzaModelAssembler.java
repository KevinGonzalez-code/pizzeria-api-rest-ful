package com.kevin.pizzeria.hateoas.assemblers;

import com.kevin.pizzeria.controllers.PizzaController;
import com.kevin.pizzeria.entities.Pizza;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class PizzaModelAssembler implements RepresentationModelAssembler<Pizza,EntityModel<Pizza>>{

    @Override
    public EntityModel<Pizza> toModel(Pizza pizza) {        
        return EntityModel.of(pizza, 
        linkTo(methodOn(PizzaController.class).getPizzasById(pizza.getId())).withSelfRel(),
        linkTo(methodOn(PizzaController.class).getPizzas()).withSelfRel());
    }
    
}
