package com.estudio.bibliotecasegura.Repository;

import com.estudio.bibliotecasegura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByTitulo(String titulo);
    ArrayList<Libro> findByAutor(String autor);
}
