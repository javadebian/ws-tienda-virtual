package com.isc.tienda.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TDetalleVenta", schema = "DBTiendaVirtual")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private BigDecimal precio;

    //bi-directional many-to-one association to TProducto
    @ManyToOne
    @JoinColumn(name="idProducto")
    private Producto producto;
    //bi-directional many-to-one association to TVenta
    @ManyToOne
    @JoinColumn(name="idVenta")
    private Venta venta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
}
