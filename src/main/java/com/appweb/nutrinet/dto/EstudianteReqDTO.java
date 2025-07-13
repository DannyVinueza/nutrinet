package com.appweb.nutrinet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EstudianteReqDTO {

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios")
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fechaNacimiento;

    private String alergias;

    @NotNull(message = "El ID del curso es obligatorio")
    private Integer idCurso;

    @NotNull(message = "El ID del padre es obligatorio")
    private Integer idPadre;
}
