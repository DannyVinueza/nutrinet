package com.appweb.nutrinet.dto;

import lombok.Getter;

import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioResDTO {
    private String nombre;
    private String apellido;
    private String correo;
    private String rol;
    private String telefono;
    private LocalDateTime fechaCreacion;
}
