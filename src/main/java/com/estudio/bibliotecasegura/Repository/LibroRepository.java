package com.estudio.bibliotecasegura.Repository;

import com.estudio.bibliotecasegura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // <-- Usa List
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    Optional<Libro> findByIdAndCopiasDisponiblesGreaterThan(Long id, int copias);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);
    List<Libro> findByAutorContainingIgnoreCase(String autor);

    boolean existsByTituloIgnoreCaseAndAutorIgnoreCase(String titulo, String autor);
}