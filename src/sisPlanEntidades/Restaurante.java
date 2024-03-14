/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moise
 */
public class Restaurante {
    
    protected String codigo;
    protected String nombre;
    protected String localizacion;
    protected TipoComida tipoComida;
    protected Usuario gerente;
    private ArrayList arrayCalificaciones;
    private List <Producto> arrayProductos;
    private List <OrdenCompra> arrayOrdenes;
    private boolean mostrarCaificacion;

    public Restaurante(String codigo, String nombre, String localizacion, TipoComida tipoComida, Usuario gerente) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.tipoComida = tipoComida;
        this.gerente = gerente;
        mostrarCaificacion = false;
        
        this.arrayCalificaciones = new ArrayList();
        
        this.arrayOrdenes = new ArrayList <> ();
        
        this.arrayProductos = new ArrayList <> ();
    }

    public Restaurante() {
        
        this.arrayCalificaciones = new ArrayList ();
        
        this.arrayOrdenes = new ArrayList <> ();
        
        this.arrayProductos = new ArrayList <> ();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public TipoComida getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }

    public Usuario getGerente() {
        return gerente;
    }

    public void setGerente(Usuario gerente) {
        this.gerente = gerente;
    }

    public ArrayList getArrayCalificaciones() {
        return arrayCalificaciones;
    }

    public void setArrayCalificaciones(ArrayList arrayCalificaciones) {
        this.arrayCalificaciones = arrayCalificaciones;
    }

    public List<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(List<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }

    public List<OrdenCompra> getArrayOrdenes() {
        return arrayOrdenes;
    }

    public void setArrayOrdenes(List<OrdenCompra> arrayOrdenes) {
        this.arrayOrdenes = arrayOrdenes;
    }

    public boolean isMostrarCaificacion() {
        return mostrarCaificacion;
    }

    public void setMostrarCaificacion(boolean mostrarCaificacion) {
        this.mostrarCaificacion = mostrarCaificacion;
    }

    @Override 
    public String toString() {
        if (mostrarCaificacion) {
            return this.nombre + " - "+ retornaPromedioPuntuado()+ " ★";
        } else {
            return this.nombre;
        }
    }
      
    public int retornaPromedioPuntuado() {
        if (!arrayCalificaciones.isEmpty()) {
            DecimalFormat formato = new DecimalFormat("#.00");
            double promedio = 0;
            double suma = 0;
            for (int i = 0; i < arrayCalificaciones.size(); i++) {

                suma += (int) arrayCalificaciones.get(i);
            }
            promedio = suma / arrayCalificaciones.size();
            return (int) promedio;
        } else {
            return 0;
        }
    }
    
    
    
    
    
    
    
}
