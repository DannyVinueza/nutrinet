package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.CursoReqDTO;
import com.appweb.nutrinet.dto.CursoResDTO;

import java.util.List;

public interface CursoService {

    CursoResDTO crear(CursoReqDTO dto);
    CursoResDTO obtenerPorId(int id);

    List<CursoResDTO> listar();
    CursoResDTO actualizar(int id, CursoReqDTO dto);
    void eliminar(int id);
}
