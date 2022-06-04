package com.kevin.pizzeria.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ingrediente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del ingrediente es requerido")
    private String nombre;

    @Min(value = 0, message = "El precio no puede ser negativo")
    @NotEmpty(message = "El precio no puede estar vacio")
    private Double precio;

    @ManyToMany(mappedBy = "ingredientes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
     private List<Pizza> pizza;
}
