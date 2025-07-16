package com.appweb.nutrinet.service;

import com.appweb.nutrinet.dto.AuthReqDTO;
import com.appweb.nutrinet.dto.AuthResDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    AuthResDTO loginUser (AuthReqDTO authReqDTO);
}
