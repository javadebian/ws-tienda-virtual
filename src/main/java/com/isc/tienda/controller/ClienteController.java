package com.isc.tienda.controller;

import com.isc.tienda.model.Cliente;
import com.isc.tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/cliente", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente obtenerClienteById(@PathVariable int id){
        return clienteService.getClienteById(id);
    }

    @PostMapping("/add")
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteService.crearCliente(cliente);
    }

    @PostMapping("/login")
    public Map<String, Object> loginCliente(@RequestBody Map<String,String> data){
        Map<String, Object> map= new HashMap<String, Object>();
        Cliente cliente = clienteService.validarCliente(data.get("dni"), data.get("clave"));
        if(cliente!= null){
            map.put("valido",true);
            map.put("dni",cliente.getDni());
            map.put("nombres",cliente.getNombres());
            map.put("estado", cliente.getEstado());
        }else{
            map.put("valido",false);
            map.put("msj","El cliente no existe!!");
        }
        return map;
    }
}
