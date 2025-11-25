package com.estudio.bibliotecasegura.Dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PrestamoResponseDTO {
    private Long id;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean devuelto;
    private String tituloLibro;
    private String nombreUsuario;
}