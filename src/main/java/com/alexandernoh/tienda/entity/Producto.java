package com.alexandernoh.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @NotBlank(message = "EL nombre del producto no puede estar vacio.")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "El precio no puede ir vacio.")
    @Column(name = "precio_producto")
    private Double precioProducto;

    @NotNull(message = "El stock no puede ir vacio")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "EL ID de la categoria no puede ir vacio")
    @Column(name = "id_categoria")
    private Integer idCategoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}