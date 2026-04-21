package com.alexandernoh.tienda.repository;

import com.alexandernoh.tienda.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepositorio extends JpaRepository <DetallePedido, Integer> {
}
