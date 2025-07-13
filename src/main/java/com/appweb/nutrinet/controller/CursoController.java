package com.appweb.nutrinet.controller;

import com.appweb.nutrinet.dto.CursoReqDTO;
import com.appweb.nutrinet.dto.CursoResDTO;
import com.appweb.nutrinet.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<CursoResDTO> crear(@Valid @RequestBody CursoReqDTO dto) {
        return ResponseEntity.status(201).body(cursoService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResDTO> obtener(@PathVariable int id) {
        return ResponseEntity.ok(cursoService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<CursoResDTO>> listar() {
        return ResponseEntity.ok(cursoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResDTO> actualizar(@PathVariable int id, @Valid @RequestBody CursoReqDTO dto) {
        return ResponseEntity.ok(cursoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
