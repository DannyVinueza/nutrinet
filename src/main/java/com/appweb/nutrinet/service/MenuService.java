package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.MenuReqDTO;
import com.appweb.nutrinet.dto.MenuResDTO;

import java.util.List;

public interface MenuService {

    MenuResDTO crear(MenuReqDTO dto);
    MenuResDTO obtenerPorId(int id);
    
    List<MenuResDTO> listar();
    MenuResDTO actualizar(int id, MenuReqDTO dto);
    void eliminar(int id);
}
