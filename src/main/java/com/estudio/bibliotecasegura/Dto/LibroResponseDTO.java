package com.estudio.bibliotecasegura.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LibroResponseDTO {
    @NotBlank
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private Integer nroCopias;
}
