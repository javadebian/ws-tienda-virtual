package com.isc.tienda.controller;

import com.isc.tienda.model.Proveedor;
import com.isc.tienda.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/proveedor", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/all")
    public List<Proveedor> listaProveedores(){
        return proveedorService.getProveedores();
    }

    @GetMapping("/{id}")
    public Proveedor getProveedor(@PathVariable int id){
        return proveedorService.getProveedorById(id);
    }

    @PostMapping("/add")
    public Proveedor createProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.createProveedor(proveedor);
    }

    @PutMapping("/update")
    public Proveedor updateProveedor(@RequestBody Proveedor proveedor){
        return proveedorService.updateProveedor(proveedor);
    }

    @PostMapping("/login")
    public Map<String, Object> loginProveedor(@RequestBody Map<String,String> data){
        Map<String, Object> map= new HashMap<String, Object>();
        Proveedor proveedor = proveedorService.validarProveedor(data.get("dni"), data.get("clave"));
        if(proveedor!= null){
            map.put("valido",true);
            map.put("dni",proveedor.getDni());
            map.put("nombres",proveedor.getNombres()+" "+proveedor.getApellidos());
            map.put("estado", proveedor.getEstado());
        }else{
            map.put("valido",false);
            map.put("msj","El usuario no existe!!");
        }
        return map;
    }
}
