package com.isc.tienda.repository;

import com.isc.tienda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    //CRUD
    @Query(value = "Select e from Usuario e where e.dni = ?1 AND e.password = ?2")
    Usuario loginUser(String dni,String clave);
}
