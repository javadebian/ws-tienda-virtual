package com.isc.tienda.repository;

import com.isc.tienda.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProveedorRepository extends JpaRepository<Proveedor,Integer> {
    //CRUD
    @Query(value = "Select e from Proveedor e where e.dni = ?1 AND e.password = ?2")
    Proveedor loginUser(String dni,String clave);
}
