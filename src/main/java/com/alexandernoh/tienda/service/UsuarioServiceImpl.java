package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Usuario;
import com.alexandernoh.tienda.exception.ResourceNotFoundException;
import com.alexandernoh.tienda.repository.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepositorio usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepositorio usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario crear(Usuario usuario) {
        usuario.setIdUsuario(null);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuario con ID, no encontrado" + id));
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario existente = buscarPorId(id);
         existente.setNombreUsuario(usuario.getNombreUsuario());
         existente.setApellidoUsuario(usuario.getApellidoUsuario());
         existente.setEdadUsuario(usuario.getEdadUsuario());
         return usuarioRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
if(!usuarioRepository.existsById(id)) {
    throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
}
    usuarioRepository.deleteById(id);
    }
}
