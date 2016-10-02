package com.dqv.entities;


import java.util.Date;


/**
 * Created by DanielQuirozV on 10/24/2015.
 */
public class Clientes {
    //Atributos Usuarios
    private String idCliente;
    private int tipoIdenty;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefono;
    private int Cuidad;
    private Date fechaNacimiento;
    private Date fechaIngreso;

    //Constructor
    public Clientes(String idCliente, int tipoIdenty, String nombres, String apellidos, String direccion,
                    String telefono, int cuidad, Date fechaNacimiento, Date fechaIngreso) {
        this.idCliente = idCliente;
        this.tipoIdenty = tipoIdenty;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        Cuidad = cuidad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;


    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public int getTipoIdenty() {
        return tipoIdenty;
    }

    public void setTipoIdenty(int tipoIdenty) {
        this.tipoIdenty = tipoIdenty;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCuidad() {
        return Cuidad;
    }

    public void setCuidad(int cuidad) {
        Cuidad = cuidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
