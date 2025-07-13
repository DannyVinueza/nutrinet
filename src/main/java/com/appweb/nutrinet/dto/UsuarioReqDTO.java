package com.appweb.nutrinet.dto;

import com.appweb.nutrinet.enums.Rol;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioReqDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 32, message = "El nombre no puede exceder 32 caracteres")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 32, message = "El apellido no puede exceder 32 caracteres")
    private String apellido;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Debe ser un correo válido")
    @Size(max = 64, message = "El correo no puede exceder 64 caracteres")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, max = 255, message = "La contraseña debe tener entre 6 y 255 caracteres")
    private String contrasenia;

    @Size(max = 15, message = "El teléfono no puede exceder 15 caracteres")
    private String telefono;

    @NotNull(message = "El rol es obligatorio")
    private Rol rol;
}
