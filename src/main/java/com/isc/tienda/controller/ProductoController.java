package com.isc.tienda.controller;

import com.isc.tienda.model.Producto;
import com.isc.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/producto", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/add")
    public Producto crearProducto(@RequestBody Producto venta){
        return productoService.crearProducto(venta);
    }

    @PutMapping("/update")
    public Producto updateProducto(@RequestBody Producto venta){
        return productoService.updateProducto(venta);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProducto(@PathVariable int id){
        return productoService.deleteProducto(id);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable int id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/{dni}")
    public List<Producto> listProductoUsuario(@PathVariable String dni){
        return productoService.listProductosUsuario(dni);
    }
}
