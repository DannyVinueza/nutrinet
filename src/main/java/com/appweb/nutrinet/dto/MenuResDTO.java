package com.appweb.nutrinet.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class MenuResDTO {

    private int idMenu;

    private LocalDate fecha;

    private String desayuno;
    private String almuerzo;
    private String merienda;

    private BigDecimal caloriasTotales;

    private int idUsuarioCreador;


}
