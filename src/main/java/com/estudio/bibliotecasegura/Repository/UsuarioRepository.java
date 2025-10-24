package com.estudio.bibliotecasegura.Repository;

import com.estudio.bibliotecasegura.Model.Rol;
import com.estudio.bibliotecasegura.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);
    ArrayList<Usuario> findUsuarioByRol(Rol rol);
}
