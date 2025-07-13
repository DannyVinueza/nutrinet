package com.appweb.nutrinet.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.nutrinet.dto.AsistenciaReqDTO;
import com.appweb.nutrinet.dto.AsistenciaResDTO;
import com.appweb.nutrinet.service.AsistenciaService;
import com.appweb.nutrinet.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/asistencias")

public class AsistenciaController {
	private final AsistenciaService asistenciaService;

	public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }
	
	@PostMapping
    public ResponseEntity<AsistenciaResDTO> crearAsistencia(@Valid @RequestBody AsistenciaReqDTO asistenciaDTO) {
        AsistenciaResDTO nuevaAsistencia = asistenciaService.crear(asistenciaDTO);
        return new ResponseEntity<>(nuevaAsistencia, HttpStatus.CREATED);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<AsistenciaResDTO> obtenerAsistencia(@PathVariable int id) {
        return ResponseEntity.ok(asistenciaService.obtenerPorId(id));
    }
	
	 @GetMapping
	    public ResponseEntity<List<AsistenciaResDTO>> listarAsistencias() {
	        return ResponseEntity.ok(asistenciaService.listar());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<AsistenciaResDTO> actualizarAsistencia(
	            @PathVariable int id,
	            @Valid @RequestBody AsistenciaReqDTO asistenciaDTO) {
	        return ResponseEntity.ok(asistenciaService.actualizar(id, asistenciaDTO));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminarAsistencia(@PathVariable int id) {
	        asistenciaService.eliminar(id);
	        return ResponseEntity.noContent().build();
	    }

	    
}
