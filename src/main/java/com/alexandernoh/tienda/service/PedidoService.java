package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PedidoService {
    List<Pedido> listar();
    Pedido crear(Pedido pedido);
    Pedido actualizar(Integer id, Pedido pedido);
    Pedido buscarPorId(Integer id);
    void eliminar(Integer id);
}
