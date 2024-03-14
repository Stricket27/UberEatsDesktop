/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author moise
 */
public class Pago {

    private Date fechaPago;
    private double montoPagoColones;
    private double montoPagoDolares;
    private Moneda moneda;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

    public Pago(Date fechaPago, double montoPagoColones, Moneda moneda) {
        this.fechaPago = fechaPago;
        this.montoPagoColones = montoPagoColones;
        this.moneda = moneda;
    }

    public Pago() {
        fechaPago = Date.valueOf(LocalDate.now());
    }

    public double getMontoPagoColones() {
        return montoPagoColones;
    }

    public void setMontoPagoColones(double montoPagoColones) {
        this.montoPagoColones = montoPagoColones;
    }

    public double getMontoPagoDolares() {
        return montoPagoDolares;
    }

    public void setMontoPagoDolares(double montoPagoDolares) {
        this.montoPagoDolares = montoPagoDolares;
    }
  
    public void conversionColonesDolares() {
        montoPagoDolares = (montoPagoColones / moneda.getCambioDolar());
    }

    public void conversionDolaresColones() {
        montoPagoColones = (montoPagoDolares * moneda.getCambioDolar());
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String numeroALetra(int numero) {
        String cadena = "";

        if ((numero / 1000000) > 0) {
            if ((numero / 1000000) == 1) {
                cadena = "UN MILLÓN" + numeroALetra(numero % 1000000);
            } else {
                cadena = numeroALetra(numero / 1000000) + " MILLONES " + numeroALetra(numero % 1000000);
            }
        } else {
            if ((numero / 1000) > 0) {
                if ((numero / 1000) == 1) {
                    cadena = " MIL " + numeroALetra(numero % 1000);
                } else {
                    cadena = numeroALetra(numero / 1000) + " MIL " + numeroALetra(numero % 1000);
                }

            } else {
                if ((numero / 100) > 0) {
                    if ((numero / 100) == 1) {
                        if ((numero % 100) == 0) {
                            cadena = " CIEN ";
                        } else {
                            cadena = " CIENTO " + numeroALetra(numero % 100);
                        }

                    } else {
                        if ((numero / 100) == 5) {
                            cadena = " QUINIENTOS " + numeroALetra(numero % 100);
                        } else {
                            if ((numero / 100) == 9) {
                                cadena = " NOVECIENTOS " + numeroALetra(numero % 100);
                            } else {
                                if ((numero / 100) == 7) {
                                    cadena = " SETECIENTOS " + numeroALetra(numero % 100);
                                } else {

                                    cadena = numeroALetra(numero / 100) + "CIENTOS " + numeroALetra(numero % 100);
                                }
                            }
                        }
                    }
                } else {
                    if ((numero / 10) > 0) {
                        switch ((int) (numero / 10)) {
                            case 1:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " DIEZ ";
                                        break;
                                    case 1:
                                        cadena = " ONCE ";
                                        break;
                                    case 2:
                                        cadena = " DOCE ";
                                        break;
                                    case 3:
                                        cadena = " TRECE ";
                                        break;
                                    case 4:
                                        cadena = " CATORCE ";
                                        break;
                                    case 5:
                                        cadena = " QUINCE ";
                                        break;
                                    default:
                                        cadena = " DIECI" + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 2:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " VEINTE ";
                                        break;
                                    default:
                                        cadena = " VEINTI" + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 3:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " TREINTA ";
                                        break;
                                    default:
                                        cadena = " TREINTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 4:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " CUARENTA ";
                                        break;
                                    default:
                                        cadena = " CUARENTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 5:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " CINCUENTA ";
                                        break;
                                    default:
                                        cadena = " CINCUENTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 6:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " SESENTA ";
                                        break;
                                    default:
                                        cadena = " SESENTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 7:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " SETENTA ";
                                        break;
                                    default:
                                        cadena = " SETENTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 8:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " OCHENTA ";
                                        break;
                                    default:
                                        cadena = " OCHENTA Y " + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                            case 9:
                                switch ((int) (numero % 10)) {
                                    case 0:
                                        cadena = " NOVENTA ";
                                        break;
                                    default:
                                        cadena = " NOVENTA Y" + numeroALetra(numero % 10);
                                        break;
                                }
                                break;
                        }
                    } else {
                        switch ((int) (numero)) {
                            case 0:
                                cadena = " CERO ";
                                break;
                            case 1:
                                cadena = " UNO ";
                                break;
                            case 2:
                                cadena = " DOS";
                                break;
                            case 3:
                                cadena = " TRES";
                                break;
                            case 4:
                                cadena = " CUATRO";
                                break;
                            case 5:
                                cadena = " CINCO";
                                break;
                            case 6:
                                cadena = " SEIS";
                                break;
                            case 7:
                                cadena = " SIETE";
                                break;
                            case 8:
                                cadena = " OCHO";
                                break;
                            case 9:
                                cadena = " NUEVE";
                                break;
                        }
                    }
                }
            }
        }
        return cadena;
    }

    public String toString(){
       String hilera = "Fecha de pago: " + formatoFecha.format(fechaPago) +
                "\nMoneda con la que se pagó: "+ moneda.toString();
       
       if (this.getMoneda() == Moneda.Colones) {
            hilera += "\nMonto pagado en colones :" + montoPagoColones;
            hilera += "\n" + numeroALetra((int)montoPagoColones);
        } else {
            hilera += "\nMonto pagado en dólares: " + montoPagoDolares;
            hilera += "\n" + numeroALetra((int)montoPagoDolares);
        }
        return hilera;
    }
}
