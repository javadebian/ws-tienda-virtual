package com.isc.tienda.service;

import com.isc.tienda.model.DetalleVenta;
import com.isc.tienda.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public DetalleVenta crearDetalleVenta(DetalleVenta detalleVenta){
        return detalleVentaRepository.save(detalleVenta);
    }

    public DetalleVenta updateDetalleVenta(DetalleVenta detalleVenta){
        DetalleVenta auxDetalle= detalleVentaRepository.findById(detalleVenta.getId()).orElse(null);
        if(auxDetalle!=null){
            return detalleVentaRepository.save(detalleVenta);
        }else{
            return null;
        }
    }

    public boolean deleteDetalleVenta(int idDetalleVenta){
        DetalleVenta auxDetalle= detalleVentaRepository.findById(idDetalleVenta).orElse(null);
        if (auxDetalle != null){
            detalleVentaRepository.delete(auxDetalle);
            return true;
        }else{
            return false;
        }
    }

    public List<DetalleVenta> listDetalleVenta(int idVenta){
        return detalleVentaRepository.listarDetalleVenta(idVenta);
    }

    public DetalleVenta getDetalleVentaById(int id){
        return detalleVentaRepository.findById(id).orElse(null);
    }
}
