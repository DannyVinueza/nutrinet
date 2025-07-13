package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.MenuReqDTO;
import com.appweb.nutrinet.dto.MenuResDTO;
import com.appweb.nutrinet.entity.Menu;
import com.appweb.nutrinet.entity.Usuario;
import com.appweb.nutrinet.repository.MenuRepository;
import com.appweb.nutrinet.repository.UsuarioRepository;
import com.appweb.nutrinet.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final UsuarioRepository usuarioRepository;

    public MenuServiceImpl(MenuRepository menuRepository, UsuarioRepository usuarioRepository) {
        this.menuRepository = menuRepository;
        this.usuarioRepository = usuarioRepository;
    }

    private Menu fromRequest(MenuReqDTO dto) {
        Usuario creador = usuarioRepository.findById(dto.getIdUsuarioCreador())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Menu menu = new Menu();
        menu.setFecha(dto.getFecha());
        menu.setDesayuno(dto.getDesayuno());
        menu.setAlmuerzo(dto.getAlmuerzo());
        menu.setMerienda(dto.getMerienda());
        menu.setCaloriasTotales(dto.getCaloriasTotales());
        menu.setCreador(creador);
        return menu;
    }

    private MenuResDTO toResponse(Menu menu) {
        MenuResDTO dto = new MenuResDTO();
        dto.setIdMenu(menu.getIdMenu());
        dto.setFecha(menu.getFecha());
        dto.setDesayuno(menu.getDesayuno());
        dto.setAlmuerzo(menu.getAlmuerzo());
        dto.setMerienda(menu.getMerienda());
        dto.setCaloriasTotales(menu.getCaloriasTotales());
        dto.setIdUsuarioCreador(menu.getCreador().getId());
        return dto;
    }

    @Override
    public MenuResDTO crear(MenuReqDTO dto) {
        Menu menu = fromRequest(dto);
        menuRepository.save(menu);
        return toResponse(menu);
    }

    @Override
    public MenuResDTO obtenerPorId(int id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menú no encontrado"));
        return toResponse(menu);
    }

    @Override
    public List<MenuResDTO> listar() {
        return menuRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public MenuResDTO actualizar(int id, MenuReqDTO dto) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menú no encontrado"));

        Usuario creador = usuarioRepository.findById(dto.getIdUsuarioCreador())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        menu.setFecha(dto.getFecha());
        menu.setDesayuno(dto.getDesayuno());
        menu.setAlmuerzo(dto.getAlmuerzo());
        menu.setMerienda(dto.getMerienda());
        menu.setCaloriasTotales(dto.getCaloriasTotales());
        menu.setCreador(creador);

        menuRepository.save(menu);
        return toResponse(menu);
    }

    @Override
    public void eliminar(int id) {
        if (!menuRepository.existsById(id)) {
            throw new RuntimeException("Menú no encontrado");
        }
        menuRepository.deleteById(id);
    }
}
