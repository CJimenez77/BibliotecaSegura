package com.estudio.bibliotecasegura.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LibroUpdateDTO {
    @NotBlank
    private Integer nroCopias;
}
