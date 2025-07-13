package com.appweb.nutrinet.controller;

import com.appweb.nutrinet.dto.UsuarioReqDTO;
import com.appweb.nutrinet.dto.UsuarioResDTO;
import com.appweb.nutrinet.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResDTO> crearUsuario(@Valid @RequestBody UsuarioReqDTO user){
        UsuarioResDTO usuarioCreado = usuarioService.crear(user);
        return new ResponseEntity<>(usuarioCreado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResDTO> obtenerUsuario(@PathVariable int id){
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResDTO>> listarUsuarios(){
        return ResponseEntity.ok(usuarioService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResDTO> actualizarUsuario(
            @PathVariable int id,
            @Valid @RequestBody UsuarioReqDTO user){
        return ResponseEntity.ok(usuarioService.actualizar(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id){
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
