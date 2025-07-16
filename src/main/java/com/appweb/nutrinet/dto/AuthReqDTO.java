package com.appweb.nutrinet.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthReqDTO {
    @NotBlank
    String email;
    @NotBlank
    String contrasenia;
}
