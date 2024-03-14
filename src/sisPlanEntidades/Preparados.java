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
public class Preparados extends Producto{
    
    private int tiempoPreparacion;
    private int porcentajeIVA;

    public Preparados (){
        
    }

    public Preparados(int tiempoPreparacion, String codigo, String descripcion, int precio, Restaurante restaurante) {
        super(codigo, descripcion, precio, restaurante);
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public int getPorcentajeIVA() {
        return porcentajeIVA;
    }

    public void setPorcentajeIVA(int porcentajeIVA) {
        this.porcentajeIVA = porcentajeIVA;
    }
    
    @Override
    public double calcularProducto() {
        return this.getPrecio() + this.getPrecio() * 0.10;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    @Override
    public double calcularImpuesto() {
        return this.getPrecio() * (getPorcentajeIVA()/100.0);
    }
   
    public String detalleProducto(){    
        return super.detalleProducto() +
                "\nCantidad: 1";
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
