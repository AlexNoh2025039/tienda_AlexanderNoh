package com.alexandernoh.tienda.repository;

import com.alexandernoh.tienda.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository <Producto, Integer> {
}
