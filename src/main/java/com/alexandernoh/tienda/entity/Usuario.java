package com.alexandernoh.tienda.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_usuario")
private Integer idUsuario;

@NotBlank(message = "EL nombre del usuario no puede estar vacio.")
    @Column(name="nombre_usuario")
    private String nombreUsuario;

    @NotBlank(message = "EL apellido del usuario no puede estar vacio.")
    @Column(name="apellido_usuario")
    private String apellidoUsuario;

    @NotNull(message = "La edad no puede ir vacio.")
    @Column(name="edad_usuario")
    private Integer edadUsuario;

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(Integer edadUsuario) {
        this.edadUsuario = edadUsuario;
    }
}