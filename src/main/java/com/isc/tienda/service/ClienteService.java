package com.isc.tienda.service;

import com.isc.tienda.model.Cliente;
import com.isc.tienda.model.Usuario;
import com.isc.tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        Cliente auxCliente= clienteRepository.findById(cliente.getId()).orElse(null);
        if(auxCliente!=null){
            return clienteRepository.save(cliente);
        }else{
            return null;
        }
    }

    public boolean deleteCliente(int idCliente){
        Cliente auxCliente= clienteRepository.findById(idCliente).orElse(null);
        if (auxCliente != null){
            clienteRepository.delete(auxCliente);
            return true;
        }else{
            return false;
        }
    }

    public List<Cliente> listClientes(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(int id){
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente validarCliente(String dni, String clave){
        String password = DigestUtils.md5DigestAsHex(String.valueOf(clave).getBytes());
        return clienteRepository.loginClient(dni,password);
    }
}
