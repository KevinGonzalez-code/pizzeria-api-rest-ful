package com.kevin.pizzeria.services.impls;

import java.util.List;
import com.kevin.pizzeria.dao.PizzaDao;
import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.services.interfaces.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PizzaServiceImpl implements IPizzaService {

    @Autowired
    private PizzaDao pizzaDao;

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaDao.findAll();
    }

    @Override
    public Pizza getPizzaById(Long idPizza) {
        return pizzaDao.findById(idPizza).get();
    }

    @Override
    public void save(Pizza pizza) { 
        pizzaDao.save(pizza);
    }

    @Override
    public void deletePizzaById(Long idPizza) {
        pizzaDao.deleteById(idPizza);
    }    
}
