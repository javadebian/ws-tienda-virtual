package com.isc.tienda.controller;

import com.isc.tienda.model.Venta;
import com.isc.tienda.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/venta", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/add")
    public Venta crearVenta(@RequestBody Venta venta){
        return ventaService.crearVenta(venta);
    }

    @PutMapping("/update")
    public Venta updateVenta(@RequestBody Venta venta){
        return ventaService.updateVenta(venta);
    }

    @DeleteMapping("/{id}")
    public boolean deleteVenta(@PathVariable int id){
        return ventaService.deleteVenta(id);
    }

    @GetMapping("/{id}")
    public Venta obtenerVenta(@PathVariable int id){
        return ventaService.getVentaById(id);
    }

    @PostMapping("/porMes")
    public List<Venta> listVentasMes(@RequestBody Map<String, Date> map){
        return ventaService.listVentasMes(map.get("fechaI"),map.get("fechaF"));
    }
}
