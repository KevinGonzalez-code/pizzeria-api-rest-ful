package com.kevin.pizzeria.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.pizzeria.entities.Comentario;
import com.kevin.pizzeria.entities.Ingrediente;
import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.hateoas.assemblers.PizzaModelAssembler;
import com.kevin.pizzeria.services.interfaces.IComentarioService;
import com.kevin.pizzeria.services.interfaces.IIngredienteService;
import com.kevin.pizzeria.services.interfaces.IPizzaService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pizzas" )
@RequiredArgsConstructor
public class PizzaController {

    @Autowired
    private IPizzaService pizzaService;

    @Autowired
    private IIngredienteService ingredienteService;

    @Autowired
    private IComentarioService comentarioService;

    @NonNull
    private final PizzaModelAssembler assembler;

    @GetMapping
    public CollectionModel<EntityModel<Pizza>> getPizzas() {

        // Pizza test = Pizza.builder()
        // .nombre("Comentarios")
        // .precio(23.22)
        // .foto("foto")
        // .ingredientes(ingredienteService.getAllIngredientes())
        // .comentarios(comentarioService.getAllComentarios())
        // .build();

        // pizzaService.save(test);

        // Ingrediente test2 = Ingrediente.builder()
        //                             .nombre("Carne picada")
        //                             .precio(3.44)
        //                             .build();
        // List<Ingrediente> ingredientes = new ArrayList<>();
        // ingredientes.add(test2);

        // ingredienteService.save(test2);

        List<Pizza> pizass = pizzaService.getAllPizzas();

        var pizzasHiperMedia = pizass.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(pizzasHiperMedia);
    }

    @GetMapping("/{id}")
    public EntityModel<Pizza> getPizzasById(@PathVariable long id) {
        Pizza test = pizzaService.getPizzaById(id);

        List<Comentario> comentarios = comentarioService.getAllComentarios();
        
        //test.setComentarios(comentarios);
        

        return assembler.toModel(pizzaService.getPizzaById(id));
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> guardarProducto(@Valid @RequestBody Pizza pizza,
            BindingResult result) {

        ResponseEntity<Map<String, Object>> responseEntity = null;

        var responseMap = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errores = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseMap.put("errores", errores);

            return responseEntity = new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.BAD_REQUEST);
        }
 

        try {

            //calcular el precio de la pizza antes de guardarla          

            pizza.setPrecio(pizzaService.calculateProfits(pizza.getIngredientes()));

            // Comprobamos que realmente se a guardado el producto en la base de datos
            Pizza pizzaDB = pizzaService.save(pizza);

            if (pizzaDB != null) {
                responseMap.put("mensaje", "La pizza id: " + pizzaDB.getId() + " se ha guardado correctamente");
                responseMap.put("pizza", pizzaDB);
                responseEntity = new ResponseEntity<>(responseMap, HttpStatus.CREATED);
            } else {
                // Hubo algun problema
                responseMap.put("mensaje", "No se ha podido guardar la pizza");
                responseEntity = new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException e) {
            responseMap.put("mensaje", "No se ha podido guardar la pizza, " + e.getMostSpecificCause());
            responseEntity = new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> modificarProducto(@Valid @RequestBody Pizza pizza,
            BindingResult result, @PathVariable Long id) {

        ResponseEntity<Map<String, Object>> responseEntity = null;

        var responseMap = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errores = new ArrayList<>();

            for (ObjectError error : result.getAllErrors()) {
                errores.add(error.getDefaultMessage());
            }
            responseMap.put("errores", errores);

            return responseEntity = new ResponseEntity<Map<String, Object>>(responseMap, HttpStatus.BAD_REQUEST);
        }
        // Guardamos el producto

        try {

            pizza.setId(id);
           // pizza.setComentarios(pizza.getComentarios());

            pizza.setPrecio(pizzaService.calculateProfits(pizza.getIngredientes()));


            // Comprobamos que realmente se a guardado el producto en la base de datos
            Pizza pizzaDB = pizzaService.save(pizza);

            if (pizzaDB != null) {
                responseMap.put("mensaje", "La pizza id:" + pizzaDB.getId() + " se ha guardado correctamente");
                responseMap.put("pizza", pizzaDB);
                responseEntity = new ResponseEntity<>(responseMap, HttpStatus.CREATED);
            } else {
                // Hubo algun problema
                responseMap.put("mensaje", "No se ha podido guardar la pizza");
                responseEntity = new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
            }

        } catch (DataAccessException e) {
            responseMap.put("mensaje", "No se ha podido guardar la pizza, " + e.getMostSpecificCause());
            responseEntity = new ResponseEntity<>(responseMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePizza(@PathVariable Long id) {

        ResponseEntity<String> response = null;

        

        pizzaService.deletePizzaById(id);

        try {
            if(pizzaService.getPizzaById(id) == null){
                response = new ResponseEntity<>(HttpStatus.OK);
            }else{
                response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            
        } catch (Exception e) {
           return response = new ResponseEntity<>(HttpStatus.OK);

        }

        return response;

    }

}
