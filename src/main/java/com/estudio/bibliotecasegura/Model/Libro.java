package com.estudio.bibliotecasegura.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 100)
    private String autor;

    @Column(nullable = false)
    private Integer nroCopias;

    @Column(nullable = false)
    private Integer copiasDisponibles;

    @OneToMany(mappedBy = "libro")
    private ArrayList<Prestamo> prestamosList = new ArrayList<>();
}
