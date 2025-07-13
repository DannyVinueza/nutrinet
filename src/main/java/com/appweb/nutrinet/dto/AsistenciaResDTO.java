package com.appweb.nutrinet.dto;

import java.time.LocalDate;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AsistenciaResDTO {
	private int id;
    private int idEstudiante;
    private String nombreEstudiante; 
    private LocalDate fecha;
    private Boolean presente;
    private String observaciones;
}


