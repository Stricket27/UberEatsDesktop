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
public class LineaDetalle {
    
    private static int contLinea = 0;
    private int numeroLinea;
    private Producto oProducto;
    private int cantidad;

    public LineaDetalle() {
    numeroLinea = contLinea++;
    }

    
    public static int getContLinea() {
        return contLinea;
    }

    public static void setContLinea(int contLinea) {
        LineaDetalle.contLinea = contLinea;
    }

    public int getNumeroLinea() {
        return numeroLinea;
    }

    public void setNumeroLinea(int numeroLinea) {
        this.numeroLinea = numeroLinea;
    }

    public Producto getoProducto() {
        return oProducto;
    }

    public void setoProducto(Producto oProducto) {
        this.oProducto = oProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double subTotal (){
        return oProducto.calcularProducto() * cantidad;
    }
    
    public String toString(){
        return "No. línea: "+ this.numeroLinea+
                "\n"+ oProducto.detalleProducto();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
