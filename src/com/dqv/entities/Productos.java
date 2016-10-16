package com.dqv.entities;

import java.util.Date;

/**
 * Created by DanielQuirozV on 10/29/2015.
 */
public class Productos {

    private String IdProducto;
    private String CodigoBarras;
    private String Nombre;
    private String Marca;
    private  String proveedor;
    private int Tipo;
    private Date FechaVencimiento;
    private  Date FechadeIngreso;
    private double Precio;
    private int Cantidad;

    public Productos(){

    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String idProducto) {
        IdProducto = idProducto;
    }

    public String getCodigoBarras() {
        return CodigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        CodigoBarras = codigoBarras;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }

    public Date getFechadeIngreso() {
        return FechadeIngreso;
    }

    public void setFechadeIngreso(Date fechadeIngreso) {
        FechadeIngreso = fechadeIngreso;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
