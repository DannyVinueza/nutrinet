package com.appweb.nutrinet.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AsistenciaReqDTO {

    @NotNull(message = "El ID del estudiante es obligatorio")
    private Integer idEstudiante;

    @NotNull(message = "La fecha es obligatoria")
    @FutureOrPresent(message = "La fecha no puede ser anterior a hoy")
    private LocalDate fecha;

    @NotNull(message = "Debe indicar si el estudiante estuvo presente")
    private Boolean presente;

    private String observaciones;
}
