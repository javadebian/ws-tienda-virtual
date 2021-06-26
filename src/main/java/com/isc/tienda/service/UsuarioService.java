package com.isc.tienda.service;

import com.isc.tienda.model.Usuario;
import com.isc.tienda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        String password = DigestUtils.md5DigestAsHex(String.valueOf(usuario.getDni()).getBytes());
        usuario.setPassword(password);
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

    public Usuario validarUsuario(String dni,String clave){
        String password = DigestUtils.md5DigestAsHex(String.valueOf(clave).getBytes());
        return usuarioRepository.loginUser(dni,password);
    }
}
