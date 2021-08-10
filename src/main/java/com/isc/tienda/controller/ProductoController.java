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
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PutMapping("/update")
    public Producto updateProducto(@RequestBody Producto producto){
        return productoService.updateProducto(producto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProducto(@PathVariable int id){
        return productoService.deleteProducto(id);
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable int id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/usuario/{dni}")
    public List<Producto> listProductoUsuario(@PathVariable String dni){
        return productoService.listProductosUsuario(dni);
    }

    @GetMapping("/all")
    public List<Producto> listProductos(){
        return productoService.listProductos();
    }
}
