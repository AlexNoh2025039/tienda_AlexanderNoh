package com.alexandernoh.tienda.repository;

import com.alexandernoh.tienda.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositorio extends JpaRepository <Pedido, Integer> {
}
