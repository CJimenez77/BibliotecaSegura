package com.estudio.bibliotecasegura.Controller;

import com.estudio.bibliotecasegura.Dto.LibroCreateDTO;
import com.estudio.bibliotecasegura.Dto.LibroResponseDTO;
import com.estudio.bibliotecasegura.Service.LibroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroResponseDTO>> getAll() {
        return ResponseEntity.ok(libroService.listarLibros());
    }

    // Solo ADMIN/BIBLIOTECARIO (configurado en SecurityConfig)
    @PostMapping("/gestion")
    public ResponseEntity<LibroResponseDTO> create(@RequestBody LibroCreateDTO dto) {
        return ResponseEntity.ok(libroService.guardarLibro(dto));
    }
}