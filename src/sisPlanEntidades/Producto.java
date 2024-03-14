/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

import java.text.DecimalFormat;

/**
 *
 * @author moise
 */
public abstract class Producto {
    
    private String codigo;
    private String descripcion;
    private int precio;
    private Restaurante restaurante;
    private boolean nombreClase;

    public abstract double  calcularProducto();
    public abstract double  calcularImpuesto();

    public Producto() {
    }

    public Producto(String codigo, String descripcion, int precio, Restaurante restaurante) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.restaurante = restaurante;
        nombreClase = false;
    }

    public boolean isNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(boolean nombreClase) {
        this.nombreClase = nombreClase;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    @Override
    public String toString() {
        if (nombreClase) {
            return this.getClass().getSimpleName();
        } else {
            return this.descripcion;
        }
    }
    
    public String detalleProducto(){
        return "Tipo de producto: "+ this.getClass().getSimpleName()+
                "\nNombre: "+ this.getDescripcion()+
                "\nPrecio base: "+ this.getPrecio();
                
    }

    
    
    
}
