package com.estudio.bibliotecasegura.Service;

import com.estudio.bibliotecasegura.Config.JwtService;
import com.estudio.bibliotecasegura.Dto.AuthRequestDTO;
import com.estudio.bibliotecasegura.Dto.AuthResponseDTO;
import com.estudio.bibliotecasegura.Dto.UsuarioRegistroDTO;
import com.estudio.bibliotecasegura.Model.Rol;
import com.estudio.bibliotecasegura.Model.Usuario;
import com.estudio.bibliotecasegura.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO registrar(UsuarioRegistroDTO request) {
        var usuario = new Usuario();
        usuario.setUsername(request.getNombreUsuario());
        usuario.setContrasena(passwordEncoder.encode(request.getContrasena()));
        usuario.setRol(Rol.ROLE_USUARIO); // Por defecto se registra como Usuario
        usuario.setEstado(true);

        usuarioRepository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);

        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(jwtToken);
        return response;
    }

    public AuthResponseDTO autenticar(AuthRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getNombreUsuario(),
                        request.getContrasena()
                )
        );
        var usuario = usuarioRepository.findByUsername(request.getNombreUsuario())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(usuario);

        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(jwtToken);
        return response;
    }
}