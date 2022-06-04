package com.kevin.pizzeria.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comentario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El nombre del ingrediente es requerido")
    @Size(message = "El comentario debe de ser mas breve", max = 200)
    private String texto;

    @Size(min = 0 , max = 10, message = "La puntuacion no debe ser superior a 10 ni inferior a 0")
    private Long puntuacion;

    @NotNull(message = "La fecha no puede estar vacia")
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    private Pizza pizza;

    @NotNull(message = "El usuario es requerido")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Usuario usuario;
}
