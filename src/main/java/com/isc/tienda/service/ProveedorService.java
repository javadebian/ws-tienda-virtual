package com.isc.tienda.service;

import com.isc.tienda.model.Proveedor;
import com.isc.tienda.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public Proveedor createProveedor(Proveedor proveedor){
        String password = DigestUtils.md5DigestAsHex(String.valueOf(proveedor.getDni()).getBytes());
        proveedor.setPassword(password);
        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> getProveedores(){
        return proveedorRepository.findAll();
    }

    public Proveedor getProveedorById(Integer id){
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor updateProveedor(Proveedor proveedor){
        Proveedor exitUser= proveedorRepository.findById(proveedor.getId()).orElse(null);
        if(exitUser != null){
            return proveedorRepository.save(proveedor);
        }else{
            return null;
        }
    }

    public Proveedor validarProveedor(String dni, String clave){
        String password = DigestUtils.md5DigestAsHex(String.valueOf(clave).getBytes());
        return proveedorRepository.loginUser(dni,password);
    }
}
