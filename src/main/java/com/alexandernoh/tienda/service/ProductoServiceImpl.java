package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.Producto;
import com.alexandernoh.tienda.exception.ResourceNotFoundException;
import com.alexandernoh.tienda.repository.ProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepositorio productoRepository;

    public ProductoServiceImpl(ProductoRepositorio productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto crear(Producto producto) {
        producto.setIdProducto(null);
        return productoRepository.save(producto);
    }

    @Override
    public Producto buscarPorId(Integer id) {
        return productoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Producto con ID, no encontrado: " + id));
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Producto existente = buscarPorId(id);
        existente.setNombreProducto(producto.getNombreProducto());
        existente.setPrecioProducto(producto.getPrecioProducto());
        existente.setStock(producto.getStock());
        existente.setIdCategoria(producto.getIdCategoria());
        return productoRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if(!productoRepository.existsById(id)){
            throw new ResourceNotFoundException("Producto no encontrado con ID: " + id);
        }

        productoRepository.deleteById(id);
    }
}
