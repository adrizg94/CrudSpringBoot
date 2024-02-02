package com.seas.crudspringboot.model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fecha;
    @Column(nullable = false)
    private float precio;
    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;
    @ManyToMany(targetEntity = Producto.class, fetch = FetchType.LAZY)
    private List<Producto> productos;

    public Factura() {
        fecha = new SimpleDateFormat("dddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
    }

    public Factura(Long id, Cliente cliente, Empleado empleado, List<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.productos = productos;
        fecha = new SimpleDateFormat("dddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", precio=" + precio +
                ", cliente=" + cliente +
                ", empleado=" + empleado +
                ", productos=" + productos +
                '}';
    }
}
