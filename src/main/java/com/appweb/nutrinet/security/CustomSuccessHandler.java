package com.appweb.nutrinet.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
        throws IOException, ServletException{
        String redirectUrl = "/";

        for(GrantedAuthority auth: authentication.getAuthorities()){
            String rol = auth.getAuthority();
            switch (rol) {
                case "ROLE_ADMINISTRADOR":
                    redirectUrl = "/index";
                    break;
                case "ROLE_NUTRICIONISTA":
                    redirectUrl = "/nutricionista/menus";
                    break;
                case "ROLE_COORDINADOR":
                    redirectUrl = "/coordinador/comedor";
                    break;
                case "ROLE_PADRE":
                    redirectUrl = "/padre/hijos";
                    break;
                case "ROLE_TUTOR":
                    redirectUrl = "/tutor/estudiantes";
                    break;
                default:
                    redirectUrl = "/login";
            }
            break;
        }

        response.sendRedirect(redirectUrl);
    }
}
