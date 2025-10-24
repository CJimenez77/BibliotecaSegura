package com.estudio.bibliotecasegura.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthRequestDTO {
    @NotBlank
    private String nombreUsuario;

    @Size(min = 8)
    private String contrasena;
}
