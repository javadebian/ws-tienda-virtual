package com.isc.tienda.service;

import com.isc.tienda.model.Usuario;
import com.isc.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUsuario(Usuario usuario){
        Usuario exitUser= usuarioRepository.findById(usuario.getId()).orElse(null);
        if(exitUser != null){
            return usuarioRepository.save(usuario);
        }else{
            return null;
        }
    }
}
