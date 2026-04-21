package com.alexandernoh.tienda.repository;

import com.alexandernoh.tienda.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository <Categoria, Integer> {
}
