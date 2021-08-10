package com.isc.tienda.service;

import com.isc.tienda.model.Cliente;
import com.isc.tienda.model.Producto;
import com.isc.tienda.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository  productoRepository;

    public Producto crearProducto(Producto producto){
        return this.productoRepository.save(producto);
    }

    public Producto updateProducto(Producto producto){
        Producto auxProducto= productoRepository.findById(producto.getId()).orElse(null);

        if(auxProducto!=null){
            return productoRepository.save(producto);
        }else{
            return null;
        }
    }

    public boolean deleteProducto(int idProducto){
        Producto auxProducto= productoRepository.findById(idProducto).orElse(null);
        if(auxProducto!=null){
            productoRepository.delete(auxProducto);
            return true;
        }else{
            return false;
        }
    }

    public Producto getProductoById(int IdProducto){
        return productoRepository.findById(IdProducto).orElse(null);
    }

    public List<Producto> listProductosUsuario(String dni){
        return productoRepository.listarProductosUsuario(dni);
    }

    public List<Producto> listProductos(){
        return productoRepository.findAll();
    }
}