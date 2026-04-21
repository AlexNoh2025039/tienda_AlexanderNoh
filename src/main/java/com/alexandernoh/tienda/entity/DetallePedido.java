package com.alexandernoh.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    @NotNull(message = "La cantidad no puede ir vacio")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El precio unitario no puede ir vacio.")
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull(message = "El ID de pedido no puede ir vacio")
    @Column(name = "id_pedido")
    private Integer idPedido;

    @NotNull(message = "El ID de producto no puede ir vacio")
    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
