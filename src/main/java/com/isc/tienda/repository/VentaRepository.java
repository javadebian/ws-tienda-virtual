package com.isc.tienda.repository;

import com.isc.tienda.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Integer> {
    @Query(value = "Select e from Venta e where e.fechaReg >= ?1 AND e.fechaReg <= ?2")
    List<Venta> listarVentasMes(Date fechaI, Date fechaF);
}
