package com.isc.tienda.repository;

import com.isc.tienda.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query(value = "Select e from Producto e where e.dni >= ?1")
    List<Producto> listarProductosUsuario(String dni);
}
