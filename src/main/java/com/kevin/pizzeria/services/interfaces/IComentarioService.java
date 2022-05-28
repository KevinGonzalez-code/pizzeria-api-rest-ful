package com.kevin.pizzeria.services.interfaces;

import java.util.List;

import com.kevin.pizzeria.entities.Comentario;

public interface IComentarioService {
    public List<Comentario> getAllComentarios();
    public void saveComentario(Comentario comentario);
}
