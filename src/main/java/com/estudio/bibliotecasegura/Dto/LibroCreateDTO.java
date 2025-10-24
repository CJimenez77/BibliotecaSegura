package com.estudio.bibliotecasegura.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LibroCreateDTO {
    @NotBlank
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String autor;

    @Size(min = 1)
    private Integer nroCopias;
}
