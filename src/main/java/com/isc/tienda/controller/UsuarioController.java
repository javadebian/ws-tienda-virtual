package com.isc.tienda.controller;

import com.isc.tienda.model.Usuario;
import com.isc.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> listaUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUruario(@PathVariable int id){
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping("/add")
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @PutMapping("/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }
}
