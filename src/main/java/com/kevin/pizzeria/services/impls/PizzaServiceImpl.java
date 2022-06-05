package com.kevin.pizzeria.services.impls;

import java.util.List;
import com.kevin.pizzeria.dao.PizzaDao;
import com.kevin.pizzeria.entities.Ingrediente;
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
    public Pizza getPizzaById(long idPizza) {
        return pizzaDao.findById(idPizza).get();
    }

    @Override
    public Pizza save(Pizza pizza) { 
        return pizzaDao.save(pizza);
    }

    @Override
    public void deletePizzaById(Long idPizza) {
        pizzaDao.deleteById(idPizza);
    }

    @Override
    public Double calculateProfits(List<Ingrediente> ingredients) {
        double precio=0;

        for(Ingrediente ingrediente : ingredients){
             precio += ingrediente.getPrecio();
        }

        precio = (precio * 0.21) + precio;

        return precio;
    }    
}
