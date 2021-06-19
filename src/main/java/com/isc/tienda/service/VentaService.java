package com.isc.tienda.service;

import com.isc.tienda.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
}
