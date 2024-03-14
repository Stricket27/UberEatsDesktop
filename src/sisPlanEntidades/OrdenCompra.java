/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author moise
 */
public class OrdenCompra {
    

    private int numeroOrdenes;
    private Usuario cliente;
    private ArrayList <LineaDetalle> arraLineaDetalle;
    private Pago pago;
    private Date fechaOrden;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private Restaurante restaurante;

    public OrdenCompra(int numeroOrdenes, Usuario cliente, Pago pago, Date fechaOrden) {
        this.numeroOrdenes = numeroOrdenes;
        this.cliente = cliente;
        this.pago = pago;
        this.fechaOrden = fechaOrden;      
        this.arraLineaDetalle = new ArrayList <> ();
    }

    public OrdenCompra() {
        this.arraLineaDetalle = new ArrayList<>();
        fechaOrden = Date.valueOf(LocalDate.now());
        
    }
    
    public double tiempoTotalPreparacion(){
        return 0;
    }
    
    public double subTotal (){
        double subtotal = 0;
        for (LineaDetalle lineaDetalle : arraLineaDetalle) {
            subtotal += lineaDetalle.subTotal();
        }
        return subtotal;
    }
    
    public double totalImpuestos (){
     double impuesto = 0;
        for (LineaDetalle lineaDetalle : arraLineaDetalle) {
            impuesto += lineaDetalle.getoProducto().calcularImpuesto();
        }
        return impuesto; 
    }
    
    public double totalOrden (){
        return subTotal() + totalImpuestos();
    }
    
    public void realizarPago (double montoPago, Moneda oMoneda){
        pago = new Pago();
        pago.setMoneda(oMoneda);
        if(oMoneda == Moneda.Colones){
            pago.setMontoPagoColones(montoPago);
        }else{
            pago.setMontoPagoDolares(montoPago);
        }
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
    
    public void agregarLineaDetalle (LineaDetalle detalle){
        arraLineaDetalle.add(detalle);
    }
    
    public void eliminarLineaDetalle (int posicion){
        arraLineaDetalle.remove(posicion);
    }

    public int getNumeroOrdenes() {
        return numeroOrdenes;
    }

    public void setNumeroOrdenes(int numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public List<LineaDetalle> getArraLineaDetalle() {
        return arraLineaDetalle;
    }

    public void setArraLineaDetalle(ArrayList <LineaDetalle> arraLineaDetalle) {
        this.arraLineaDetalle = arraLineaDetalle;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }
    
    public String detalleFactura(){
        StringBuilder detalle = new StringBuilder();
        detalle.append("No. orden: ").append(numeroOrdenes).append("\n");
        detalle.append("Fecha: ").append(formatoFecha.format(fechaOrden)).append("\n");
        detalle.append("Cliente: ").append(cliente.getNombre()).append("\n");
        detalle.append("Restaurante seleccionado: ").append(restaurante.getNombre()).append("\n\n");
        detalle.append("**********************************************************************************************************************************************************\n");
        detalle.append("Detalle factura").append("\n");
        for (LineaDetalle lineaDetalle : arraLineaDetalle) {
            detalle.append(lineaDetalle.toString()).append("\n");
            detalle.append("******************************************************************************************************************************************************\n");
        }
        int tiempo = 0;
        for (LineaDetalle lineaDetalle : arraLineaDetalle) {
            if(lineaDetalle.getoProducto() instanceof Preparados){
                tiempo += ((Preparados)lineaDetalle.getoProducto()).getTiempoPreparacion();
            }
        }
        detalle.append("Total de tiempo por productos preparados: \n").append(tiempo).append(" minutos. ").append("\n");
        detalle.append("**********************************************************************************************************************************************************\n");
        detalle.append("\n***********************************************************************************************\n");
        detalle.append("Costos totales").append("\n\n");
        detalle.append("Subtotal: ").append(subTotal()).append("\n");
        detalle.append("Impuestos totales: ").append(totalImpuestos()).append("\n");
        detalle.append("Total a pagar: ").append(totalOrden()).append("\n");
        detalle.append("********************************************************************************************************************************************************\n\n");
        detalle.append("Información del pago\n\n").append(pago.toString());
        
        return detalle.toString();
    }
    
    public String toString(){
        return String.valueOf(numeroOrdenes);
    }
}
