package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.EstudianteReqDTO;
import com.appweb.nutrinet.dto.EstudianteResDTO;

import java.util.List;

public interface EstudianteService {

    EstudianteResDTO crear(EstudianteReqDTO dto);
    EstudianteResDTO obtenerPorId(int id);

    List<EstudianteResDTO> listar();
    EstudianteResDTO actualizar(int id, EstudianteReqDTO dto);
    void eliminar(int id);
}
