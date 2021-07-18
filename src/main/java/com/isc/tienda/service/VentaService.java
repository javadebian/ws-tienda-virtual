package com.isc.tienda.service;

import com.isc.tienda.model.Venta;
import com.isc.tienda.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    public Venta crearVenta(Venta venta){
        return ventaRepository.save(venta);
    }

    public Venta updateVenta(Venta venta){
        Venta auxVenta= ventaRepository.findById(venta.getId()).orElse(null);
        if(auxVenta!=null){
            return ventaRepository.save(venta);
        }else{
            return null;
        }
    }

    public boolean deleteVenta(int idVenta){
        Venta auxVenta= ventaRepository.findById(idVenta).orElse(null);
        if (auxVenta != null){
            ventaRepository.delete(auxVenta);
            return true;
        }else{
            return false;
        }
    }

    public List<Venta> listVentasMes(Date fechaI, Date fechaF){
        return ventaRepository.listarVentasMes(fechaI, fechaF);
    }

    public Venta getVentaById(int id){
        return ventaRepository.findById(id).orElse(null);
    }
}
