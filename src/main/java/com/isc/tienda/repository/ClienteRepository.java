package com.isc.tienda.repository;

import com.isc.tienda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query(value = "Select e from Cliente e where e.dni = ?1 AND e.password = ?2")
    Cliente loginClient(String dni, String clave);
}
