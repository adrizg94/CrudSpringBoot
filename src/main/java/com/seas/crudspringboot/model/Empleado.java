package com.seas.crudspringboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellidos;
    @Column(nullable = false, length = 3)
    private String edad;
    @Column(nullable = false, unique = true, length = 9)
    private String dni;
    @Column(nullable = false, unique = true, length = 9)
    private String telefono;
    @Column(nullable = false, unique = true, length = 50)
    private String email;
    @Column(nullable = false, length = 10)
    private String fechaContrato;

    public Empleado() {}

    public Empleado(Long id, String nombre, String apellidos, String edad, String dni, String telefono, String email, String fechaContrato) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
        this.fechaContrato = fechaContrato;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", fechaContrato='" + fechaContrato + '\'' +
                '}';
    }

}
