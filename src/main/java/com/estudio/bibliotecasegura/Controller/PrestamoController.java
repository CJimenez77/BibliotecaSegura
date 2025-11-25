package com.estudio.bibliotecasegura.Controller;

import com.estudio.bibliotecasegura.Service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
public class PrestamoController {

    private final PrestamoService prestamoService;

    @PostMapping("/{libroId}")
    public ResponseEntity<String> solicitarPrestamo(@PathVariable Long libroId) {
        // Obtenemos el usuario autenticado automáticamente
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        try {
            prestamoService.realizarPrestamo(username, libroId);
            return ResponseEntity.ok("Préstamo realizado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/devolucion/{prestamoId}")
    public ResponseEntity<String> devolverLibro(@PathVariable Long prestamoId) {
        try {
            prestamoService.devolverLibro(prestamoId);
            return ResponseEntity.ok("Libro devuelto con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}