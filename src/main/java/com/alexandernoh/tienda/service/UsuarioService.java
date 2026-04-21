package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UsuarioService {
    List<Usuario> listar();
    Usuario crear(Usuario usuario);
    Usuario actualizar(Integer id, Usuario usuario);
    Usuario buscarPorId(Integer id);
    void eliminar(Integer id);
}