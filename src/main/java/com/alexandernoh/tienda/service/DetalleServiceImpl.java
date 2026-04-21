package com.alexandernoh.tienda.service;

import com.alexandernoh.tienda.entity.DetallePedido;
import com.alexandernoh.tienda.exception.ResourceNotFoundException;
import com.alexandernoh.tienda.repository.DetalleRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServiceImpl implements DetalleService{
    private final DetalleRepositorio detalleRepository;

    public DetalleServiceImpl(DetalleRepositorio detalleRepository) {
        this.detalleRepository = detalleRepository;
    }

    @Override
    public List<DetallePedido> listar() {
        return detalleRepository.findAll();
    }

    @Override
    public DetallePedido crear(DetallePedido detallePedido) {
        detallePedido.setIdDetalle(null);
        return detalleRepository.save(detallePedido);
    }

    @Override
    public DetallePedido buscarPorId(Integer id) {
        return detalleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Detalle con ID, no encontrado: "+ id));
    }

    @Override
    public DetallePedido actualizar(Integer id, DetallePedido detallePedido) {
        DetallePedido existente = buscarPorId(id);
        existente.setCantidad(detallePedido.getCantidad());
        existente.setPrecioUnitario(detallePedido.getPrecioUnitario());
        existente.setIdPedido(detallePedido.getIdPedido());
        existente.setIdProducto(detallePedido.getIdProducto());
        return detalleRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if(!detalleRepository.existsById(id)){
            throw new ResourceNotFoundException("Detalle no encontrado con ID: " + id);
        }

        detalleRepository.deleteById(id);
    }
}
