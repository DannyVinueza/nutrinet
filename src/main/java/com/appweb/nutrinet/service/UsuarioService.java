package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.UsuarioReqDTO;
import com.appweb.nutrinet.dto.UsuarioResDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResDTO crear (UsuarioReqDTO usuario);
    UsuarioResDTO obtenerPorId(int id);

    List<UsuarioResDTO> listar();
    UsuarioResDTO actualizar(int id, UsuarioReqDTO usuario);
    void eliminar(int id);
}
