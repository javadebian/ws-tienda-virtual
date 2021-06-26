package com.isc.tienda.service;

import com.isc.tienda.model.Cliente;
import com.isc.tienda.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClienteById(int id){
        return clienteRepository.findById(id).orElse(null);
    }
}
