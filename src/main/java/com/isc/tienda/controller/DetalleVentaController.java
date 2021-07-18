package com.isc.tienda.controller;

import com.isc.tienda.model.DetalleVenta;
import com.isc.tienda.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/detalleVenta", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @PostMapping("/add")
    public DetalleVenta crearDetalleVenta(@RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.crearDetalleVenta(detalleVenta);
    }

    @PutMapping("/update")
    public DetalleVenta updateDetalleVenta(@RequestBody DetalleVenta detalleVenta){
        return detalleVentaService.updateDetalleVenta(detalleVenta);
    }

    @DeleteMapping("/{id}")
    public boolean deleteDetalleVenta(@PathVariable int id){
        return detalleVentaService.deleteDetalleVenta(id);
    }

    @GetMapping("/{id}")
    public DetalleVenta obtenerDetalleVenta(@PathVariable int id){
        return detalleVentaService.getDetalleVentaById(id);
    }

    @GetMapping("/venta/{id}")
    public List<DetalleVenta> listDetallePorVenta(@PathVariable int id){
        return detalleVentaService.listDetalleVenta(id);
    }
}
