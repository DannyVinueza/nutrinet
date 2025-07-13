package com.appweb.nutrinet.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MenuReqDTO {

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "El desayuno es obligatorio")
    private String desayuno;

    @NotBlank(message = "El almuerzo es obligatorio")
    private String almuerzo;

    @NotBlank(message = "La merienda es obligatoria")
    private String merienda;

    @NotNull(message = "Las calorías son obligatorias")
    private BigDecimal caloriasTotales;

    @NotNull(message = "El ID del usuario creador es obligatorio")
    private Integer idUsuarioCreador;
}
