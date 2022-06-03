package com.kevin.pizzeria.services.impls;

import java.util.List;

import com.kevin.pizzeria.dao.IngredienteDao;
import com.kevin.pizzeria.entities.Ingrediente;
import com.kevin.pizzeria.services.interfaces.IIngredienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServiceImpl implements IIngredienteService{

    @Autowired
    private IngredienteDao ingredienteDao;
    
    @Override
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteDao.findAll();
    }

    @Override
    public void save(Ingrediente ingrediente) {
        ingredienteDao.save(ingrediente);        
    }
    
}
