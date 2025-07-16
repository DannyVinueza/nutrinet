package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.UsuarioReqDTO;
import com.appweb.nutrinet.dto.UsuarioResDTO;
import com.appweb.nutrinet.entity.Usuario;
import com.appweb.nutrinet.repository.UsuarioRepository;
import com.appweb.nutrinet.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private UsuarioResDTO toResponse(Usuario usuario){
        UsuarioResDTO user = new UsuarioResDTO();
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setCorreo(usuario.getCorreo());
        user.setRol(usuario.getRol().name());
        user.setTelefono(usuario.getTelefono());
        user.setFechaCreacion(usuario.getFechaCreacion());

        return user;
    }

    private Usuario fromRequest(UsuarioReqDTO user){
        Usuario usuario = new Usuario();
        usuario.setNombre(user.getNombre());
        usuario.setApellido(user.getApellido());
        usuario.setCorreo(user.getCorreo());
        usuario.setContrasenia(user.getContrasenia());
        usuario.setRol(user.getRol());
        usuario.setTelefono(user.getTelefono());

        return usuario;
    }

    @Override
    public UsuarioResDTO crear(UsuarioReqDTO usuario) {
        Usuario user = fromRequest(usuario);

        String contraseniaCodificada = passwordEncoder.encode(usuario.getContrasenia());
        user.setContrasenia(contraseniaCodificada);

        usuarioRepository.save(user);
        return toResponse(user);
    }

    @Override
    public UsuarioResDTO obtenerPorId(int id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return toResponse(usuario);
    }

    @Override
    public List<UsuarioResDTO> listar() {
        return usuarioRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResDTO actualizar(int id, UsuarioReqDTO usuario) {
        Usuario user = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no econtrado"));
        user.setNombre(usuario.getNombre());
        user.setApellido(usuario.getApellido());
        user.setCorreo(usuario.getCorreo());
        user.setContrasenia(usuario.getContrasenia());
        user.setRol(usuario.getRol());
        user.setTelefono(usuario.getTelefono());
        usuarioRepository.save(user);
        return toResponse(user);
    }

    @Override
    public void eliminar(int id) {
        usuarioRepository.deleteById(id);
    }
}
