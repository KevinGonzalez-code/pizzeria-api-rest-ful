package com.kevin.pizzeria.dao;

import com.kevin.pizzeria.entities.Comentario;
import com.kevin.pizzeria.entities.Pizza;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioDao extends JpaRepository<Comentario, Long> {

    @Query(nativeQuery = false ,value = "SELECT c FROM Comentario c WHERE c.pizza = ?1")
    public List<Comentario> findByPizzaId(long id);
    
}
