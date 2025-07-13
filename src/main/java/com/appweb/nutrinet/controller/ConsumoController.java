package com.appweb.nutrinet.controller;

import com.appweb.nutrinet.dto.ConsumoReqDTO;
import com.appweb.nutrinet.dto.ConsumoResDTO;
import com.appweb.nutrinet.service.ConsumoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumos")
public class ConsumoController {

    private final ConsumoService consumoService;

    public ConsumoController(ConsumoService consumoService) {
        this.consumoService = consumoService;
    }

    @PostMapping
    public ResponseEntity<ConsumoResDTO> crear(@Valid @RequestBody ConsumoReqDTO dto) {
        return ResponseEntity.status(201).body(consumoService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumoResDTO> obtener(@PathVariable int id) {
        return ResponseEntity.ok(consumoService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ConsumoResDTO>> listar() {
        return ResponseEntity.ok(consumoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumoResDTO> actualizar(@PathVariable int id, @Valid @RequestBody ConsumoReqDTO dto) {
        return ResponseEntity.ok(consumoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        consumoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
