package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.ConsumoReqDTO;
import com.appweb.nutrinet.dto.ConsumoResDTO;

import java.util.List;

public interface ConsumoService {

    ConsumoResDTO crear(ConsumoReqDTO dto);
    ConsumoResDTO obtenerPorId(int id);

    List<ConsumoResDTO> listar();
    ConsumoResDTO actualizar(int id, ConsumoReqDTO dto);
    void eliminar(int id);
}
