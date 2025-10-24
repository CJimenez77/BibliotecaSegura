package com.estudio.bibliotecasegura.Dto;

import com.estudio.bibliotecasegura.Model.Rol;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombreUsuario;
    private Rol rol;
    private boolean estado;
}
