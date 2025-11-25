package com.estudio.bibliotecasegura.Controller;

import com.estudio.bibliotecasegura.Dto.AuthRequestDTO;
import com.estudio.bibliotecasegura.Dto.AuthResponseDTO;
import com.estudio.bibliotecasegura.Dto.UsuarioRegistroDTO;
import com.estudio.bibliotecasegura.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody UsuarioRegistroDTO request) {
        return ResponseEntity.ok(authService.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authService.autenticar(request));
    }
}