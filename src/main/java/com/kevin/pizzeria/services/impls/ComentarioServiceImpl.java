package com.kevin.pizzeria.services.impls;

import java.util.List;
import com.kevin.pizzeria.dao.ComentarioDao;
import com.kevin.pizzeria.entities.Comentario;
import com.kevin.pizzeria.entities.Pizza;
import com.kevin.pizzeria.services.interfaces.IComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements IComentarioService{

    @Autowired
    private ComentarioDao comentarioDao;

    @Override
    public List<Comentario> getAllComentarios() {
        return comentarioDao.findAll();
    }

    @Override
    public void saveComentario(Comentario comentario) {
        comentarioDao.save(comentario);
    }

    @Override
    public List<Comentario> getComentariosByIdPizza(long id) {
        return comentarioDao.findByPizzaId(id);
    }

  
}
