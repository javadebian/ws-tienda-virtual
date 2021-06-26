package com.isc.tienda.controller;

import com.isc.tienda.model.Usuario;
import com.isc.tienda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/login")
    public Map<String, Object> loginUsuario(@RequestBody Map<String,String> data){
        Map<String, Object> map= new HashMap<String, Object>();
        Usuario usuario = usuarioService.validarUsuario(data.get("dni"), data.get("clave"));
        if(usuario!= null){
            map.put("valido",true);
            map.put("dni",usuario.getDni());
            map.put("nombres",usuario.getNombres()+" "+usuario.getApellidos());
            map.put("estado", usuario.getEstado());
        }else{
            map.put("valido",false);
            map.put("msj","El usuario no existe!!");
        }
        return map;
    }
}
