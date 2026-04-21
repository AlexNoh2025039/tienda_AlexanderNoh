package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    Producto crear(Producto producto);
    Producto actualizar(Integer id, Producto producto);
    Producto buscarPorId(Integer id);
    void eliminar(Integer id);
}
