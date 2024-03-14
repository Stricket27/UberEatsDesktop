/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

/**
 *
 * @author moise
 */
public class Empacados extends Producto{
    
    private int cantidad;
    private int porcentajeImpuesto;
    private int cantidadSeleccionada;
    
    public int getPorcentajeImpuesto() {
        return porcentajeImpuesto;
    }

    public void setPorcentajeImpuesto(int porcentajeImpuesto) {
        this.porcentajeImpuesto = porcentajeImpuesto;
    }

    public Empacados(int cantidad, String codigo, String descripcion, int precio, Restaurante restaurante) {
        super(codigo, descripcion, precio, restaurante);
        this.cantidad = cantidad;
    }

    public Empacados() {} 

    public int getCantidadSeleccionada() {
        return cantidadSeleccionada;
    }

    public void setCantidadSeleccionada(int cantidadSeleccionada) {
        this.cantidadSeleccionada = cantidadSeleccionada;
    }
    
    
    @Override
    public double calcularProducto() {
        return this.getPrecio();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double calcularImpuesto() {
        return  this.getPrecio() * (getPorcentajeImpuesto()/100.0);
    }
    
    public String detalleProducto(){    
        return super.detalleProducto() +
                "\nCantidad: "+ getCantidadSeleccionada();
    }
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
