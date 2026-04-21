package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Categoria;
import com.alexandernoh.tienda.exception.ResourceNotFoundException;
import com.alexandernoh.tienda.repository.CategoriaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepositorio categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepositorio categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria crear(Categoria categoria) {
        categoria.setIdCategoria(null);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarPorId(Integer id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria con ID, no encontrado" + id));
    }

    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {
        Categoria existente = buscarPorId(id);
        existente.setNombreCategoria(categoria.getNombreCategoria());
        existente.setDescripcionCategoria(categoria.getDescripcionCategoria());

        return categoriaRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
if(!categoriaRepository.existsById(id)){
    throw new ResourceNotFoundException("Categoria no encontrada con ID:" + id);
}
categoriaRepository.deleteById(id);
    }
}
