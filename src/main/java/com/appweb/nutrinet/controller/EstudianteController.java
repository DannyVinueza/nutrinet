package com.appweb.nutrinet.controller;

import com.appweb.nutrinet.dto.EstudianteReqDTO;
import com.appweb.nutrinet.dto.EstudianteResDTO;
import com.appweb.nutrinet.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<EstudianteResDTO> crear(@Valid @RequestBody EstudianteReqDTO dto) {
        return ResponseEntity.status(201).body(estudianteService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResDTO> obtener(@PathVariable int id) {
        return ResponseEntity.ok(estudianteService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<EstudianteResDTO>> listar() {
        return ResponseEntity.ok(estudianteService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstudianteResDTO> actualizar(@PathVariable int id, @Valid @RequestBody EstudianteReqDTO dto) {
        return ResponseEntity.ok(estudianteService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
