package com.kevin.pizzeria.dao;

import com.kevin.pizzeria.entities.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioDao extends JpaRepository<Comentario, Long> {
    
}
