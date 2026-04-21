package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.DetallePedido;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DetalleService {
List<DetallePedido> listar();
DetallePedido crear(DetallePedido detallePedido);
DetallePedido actualizar(Integer id, DetallePedido detallePedido);
DetallePedido buscarPorId(Integer id);
void eliminar(Integer id);
}
