package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoriaService {

     List<Categoria> listar();
     Categoria crear(Categoria categoria);
     Categoria actualizar(Integer id, Categoria categoria);
     Categoria buscarPorId(Integer id);
     void eliminar(Integer id);
}
