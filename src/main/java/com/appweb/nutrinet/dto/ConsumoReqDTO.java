package com.appweb.nutrinet.dto;

import com.appweb.nutrinet.enums.TipoComida;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumoReqDTO {

    @NotNull(message = "El ID del menú es obligatorio")
    private Integer idMenu;

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer idEstudiante;

    @NotNull(message = "El tipo de comida es obligatorio")
    private TipoComida tipoComida;

    private Boolean completo;

    private String observaciones;
}
