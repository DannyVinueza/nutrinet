package com.appweb.nutrinet.dto;

import com.appweb.nutrinet.enums.TipoComida;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsumoResDTO {

    private int id;
    private int idMenu;
    private String nombreMenu;
    private int idEstudiante;
    private String nombreEstudiante;
    private LocalDateTime fecha;
    private TipoComida tipoComida;
    private Boolean completo;
    private String observaciones;
}
