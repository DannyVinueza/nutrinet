package com.appweb.nutrinet.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EstudianteResDTO {

    private int id;

    private String nombres;

    private String apellidos;

    private LocalDate fechaNacimiento;

    private String alergias;

    private int idCurso;
    private String nombreCurso;

    private int idPadre;
    private String nombrePadre;
}
