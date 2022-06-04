package com.kevin.pizzeria.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class Pizza implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty(message = "La imagen de la pizza es requerida")
    private String foto;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "pizza_ingrediente",
        joinColumns = @JoinColumn(name="pizza_id"),
        inverseJoinColumns = @JoinColumn(name="ingrediente_id"))
    private List<Ingrediente> ingredientes;

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Comentario> comentarios;

    @Min(value = 0, message = "El precio no puede ser negativo")
    @NotNull(message = "El precio no puede estar vacio")
    private Double precio;

}
