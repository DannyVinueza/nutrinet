package com.appweb.nutrinet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "menus")
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;

    private LocalDate fecha;

    private String desayuno;
    private String almuerzo;
    private String merienda;

    private BigDecimal caloriasTotales;

    @ManyToOne
    @JoinColumn(name = "id_usuario_creador")
    private Usuario creador;
}
