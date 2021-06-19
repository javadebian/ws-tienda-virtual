package com.isc.tienda.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TVenta", schema = "DBTiendaVirtual")
public class Venta {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(mappedBy = "idCliente")
    private Cliente cliente;
    private Date  fechaReg;
    private String medioPago;
    private String nroOperacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
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
}
