package com.appweb.nutrinet.serviceImpl;

import com.appweb.nutrinet.dto.AuthReqDTO;
import com.appweb.nutrinet.dto.AuthResDTO;
import com.appweb.nutrinet.repository.UsuarioRepository;
import com.appweb.nutrinet.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository usuarioRepository;

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public AuthResDTO loginUser(AuthReqDTO authReqDTO) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
