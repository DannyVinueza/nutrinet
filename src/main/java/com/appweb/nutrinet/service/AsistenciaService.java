package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.AsistenciaReqDTO;
import com.appweb.nutrinet.dto.AsistenciaResDTO;

import java.util.List;

public interface AsistenciaService {

    AsistenciaResDTO crear(AsistenciaReqDTO asistencia);
    AsistenciaResDTO obtenerPorId(int id);

    List<AsistenciaResDTO> listar();
    AsistenciaResDTO actualizar(int id, AsistenciaReqDTO asistencia);
    void eliminar(int id);
}
