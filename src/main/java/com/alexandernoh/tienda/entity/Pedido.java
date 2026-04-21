package com.alexandernoh.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer idPedido;

    @NotBlank(message = "La fecha del pedido no puede estar vacio.")
    @Column(name = "fecha_pedido")
    private String fecha_pedido;

    @NotNull(message = "El total del pedido no puede ir vacio.")
    @Column(name = "total_pedido")
    private Double totalPedido;

    @NotNull(message = "El ID de usuario no puede ir vacio")
    @Column(name = "id_usuario")
    private Integer idUsuario;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(String fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public Double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Double totalPedido) {
        this.totalPedido = totalPedido;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
