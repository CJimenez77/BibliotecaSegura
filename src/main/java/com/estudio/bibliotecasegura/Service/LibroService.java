package com.estudio.bibliotecasegura.Service;

import com.estudio.bibliotecasegura.Dto.LibroCreateDTO;
import com.estudio.bibliotecasegura.Dto.LibroResponseDTO;
import com.estudio.bibliotecasegura.Model.Libro;
import com.estudio.bibliotecasegura.Repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public List<LibroResponseDTO> listarLibros() {
        return libroRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public LibroResponseDTO guardarLibro(LibroCreateDTO dto) {
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setAutor(dto.getAutor());
        libro.setNroCopias(dto.getNroCopias());
        libro.setCopiasDisponibles(dto.getNroCopias()); // Inicialmente iguales

        Libro guardado = libroRepository.save(libro);
        return mapToDto(guardado);
    }

    // Método auxiliar simple
    private LibroResponseDTO mapToDto(Libro libro) {
        LibroResponseDTO dto = new LibroResponseDTO();
        dto.setId(libro.getId());
        dto.setTitulo(libro.getTitulo());
        dto.setAutor(libro.getAutor());
        dto.setNroCopias(libro.getCopiasDisponibles()); // Mostramos disponibles
        return dto;
    }
}