package com.estudio.bibliotecasegura.Service;

import com.estudio.bibliotecasegura.Model.Libro;
import com.estudio.bibliotecasegura.Model.Prestamo;
import com.estudio.bibliotecasegura.Model.Usuario;
import com.estudio.bibliotecasegura.Repository.LibroRepository;
import com.estudio.bibliotecasegura.Repository.PrestamoRepository;
import com.estudio.bibliotecasegura.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public void realizarPrestamo(String username, Long libroId) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Buscamos libro y verificamos que tenga copias > 0
        Libro libro = libroRepository.findByIdAndCopiasDisponiblesGreaterThan(libroId, 0)
                .orElseThrow(() -> new RuntimeException("Libro no disponible o no existe"));

        libro.setCopiasDisponibles(libro.getCopiasDisponibles() - 1);
        libroRepository.save(libro);

        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setUsuario(usuario);
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setFechaDevolucion(LocalDate.now().plusDays(15));
        prestamo.setDevuelto(false);

        prestamoRepository.save(prestamo);
    }

    @Transactional
    public void devolverLibro(Long prestamoId) {
        Prestamo prestamo = prestamoRepository.findById(prestamoId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if(prestamo.isDevuelto()) {
            throw new RuntimeException("El libro ya fue devuelto");
        }

        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(LocalDate.now()); // Fecha real de devolución

        Libro libro = prestamo.getLibro();
        libro.setCopiasDisponibles(libro.getCopiasDisponibles() + 1);

        libroRepository.save(libro);
        prestamoRepository.save(prestamo);
    }
}