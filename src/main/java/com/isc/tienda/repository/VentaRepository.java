package com.isc.tienda.repository;

import com.isc.tienda.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
}
