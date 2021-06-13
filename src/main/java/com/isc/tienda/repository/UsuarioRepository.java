package com.isc.tienda.repository;

import com.isc.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //CRUD
}
