package com.isc.tienda.repository;

import com.isc.tienda.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta,Integer> {
    @Query(value = "Select e from DetalleVenta e where e.venta.id = ?1")
    List<DetalleVenta> listarDetalleVenta(int idVenta);
}
