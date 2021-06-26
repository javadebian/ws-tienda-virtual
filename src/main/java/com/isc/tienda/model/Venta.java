package com.isc.tienda.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "TVenta", schema = "DBTiedaVirtual")
public class Venta {
    @Id
    @GeneratedValue( strategy =  GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    private Timestamp fechaReg;
    private String medioPago;
    private String nroOperacion;
    @OneToMany
    @JoinColumn(name = "idVenta")
    private List<DetalleVenta> detalleVenta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Timestamp getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Timestamp fechaReg) {
        this.fechaReg = fechaReg;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    public List<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }
}
