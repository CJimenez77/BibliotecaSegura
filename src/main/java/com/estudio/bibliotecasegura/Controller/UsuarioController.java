package com.estudio.bibliotecasegura.Controller;

import com.estudio.bibliotecasegura.Model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private static Usuario usuario;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        UsuarioController.usuario = usuario;
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(List.of(usuario));
    }
}
