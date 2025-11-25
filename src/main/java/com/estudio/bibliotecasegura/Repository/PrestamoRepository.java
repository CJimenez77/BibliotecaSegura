package com.estudio.bibliotecasegura.Repository;
import com.estudio.bibliotecasegura.Model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {}