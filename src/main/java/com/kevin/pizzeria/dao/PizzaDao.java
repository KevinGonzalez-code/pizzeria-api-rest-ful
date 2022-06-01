package com.kevin.pizzeria.dao;

import com.kevin.pizzeria.entities.Pizza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaDao extends JpaRepository<Pizza, Long>{


        
}
