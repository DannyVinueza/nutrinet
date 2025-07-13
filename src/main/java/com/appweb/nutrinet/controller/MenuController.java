package com.appweb.nutrinet.controller;

import com.appweb.nutrinet.dto.MenuReqDTO;
import com.appweb.nutrinet.dto.MenuResDTO;
import com.appweb.nutrinet.service.MenuService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuResDTO> crear(@Valid @RequestBody MenuReqDTO dto) {
        return ResponseEntity.status(201).body(menuService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuResDTO> obtener(@PathVariable int id) {
        return ResponseEntity.ok(menuService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<MenuResDTO>> listar() {
        return ResponseEntity.ok(menuService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuResDTO> actualizar(@PathVariable int id, @Valid @RequestBody MenuReqDTO dto) {
        return ResponseEntity.ok(menuService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        menuService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
