/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

import java.util.Calendar;

/**
 *
 * @author moise
 */
public class Tarjeta {

    private String numero;
    private TipoTarjeta tipoTarjeta;
    private int mesVencimiento;
    private int annoVencimiento;
    private String codigo;

    public Tarjeta(String numero, TipoTarjeta tipoTarjeta, int mesVencimiento, int annoVencimiento, String codigo) {
        this.numero = numero;
        this.tipoTarjeta = tipoTarjeta;
        this.mesVencimiento = mesVencimiento;
        this.annoVencimiento = annoVencimiento;
        this.codigo = codigo;
    }

    public Tarjeta() {

    }

    public boolean validarTarjeta() {
        int digitoFinal = 0;
        boolean estado = false;
        int[] validar = new int[16];

        int suma = 0, suma2 = 0, unidad, decena, total,
                digitoValidacion, cont = 0, num;

        for (int t = 0; t < validar.length; t++) {

            validar[t] = numero.charAt(cont);
            num = Character.getNumericValue(validar[t]);
            validar[t] = num;
            if (t == 15) {
                digitoFinal = validar[t];
            }
            cont++;
        }

        for (int i = validar.length - 2; i >= 0; i = i - 2) {
            validar[i] = validar[i] * 2;
            if (validar[i] > 9) {
                unidad = (int) validar[i] % 10;
                decena = (int) (validar[i] / 10);
                suma += unidad + decena;
            } else {
                suma += validar[i];

            }
        }

        for (int j = 1; j <= validar.length - 3; j = j + 2) {
            suma2 += validar[j];
        }

        total = (suma + suma2) * 9;
        digitoValidacion = total % 10;
        if (digitoValidacion == digitoFinal) {
            estado = true;
        }
        return estado;
    }

    public boolean validarFecha() {
        Calendar calendario = Calendar.getInstance();

        boolean estado = false;

        int annoAct = (calendario.get(Calendar.YEAR) % 100);

        int mesAct = calendario.get(Calendar.MONTH);

        if (annoAct < this.annoVencimiento) {
            estado = true;
        } else {
            if (annoAct == this.annoVencimiento) {
                if (mesAct < this.mesVencimiento) {
                    estado = true;
                }
            }
        }
        return estado;

    }

    public boolean validarTipoTarjeta(int digitoValidacion) {
        boolean estado = false;
        switch (tipoTarjeta) {
            case MASTER_CARD:
                if (digitoValidacion >= 51 && digitoValidacion <= 55) {
                    estado = true;
                }
            case VISA:
                if (digitoValidacion == 4) {
                    estado = true;
                }
        }
        return estado;
    }

    public String censuraTarjeta() {
        String hilera = "";
        for (int p = 0; p < numero.length(); p++) {
            if (p == 3 || p == 7 || p == 11) {
                hilera += numero.charAt(p) + "-";
            } else {
                if (p >= 12) {
                    hilera += "X";
                } else {
                    hilera += numero.charAt(p);
                }
            }
        }
        return hilera;
    }

    public String toString() {
        StringBuilder h = new StringBuilder();
        h.append("Numero de tarjeta afiliado: ").append(this.censuraTarjeta()).append("\n");
        h.append("Tipo de tarjeta: ").append(tipoTarjeta.toString()).append("\n");

        return h.toString();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public int getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(int mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public int getAnnoVencimiento() {
        return annoVencimiento;
    }

    public void setAnnoVencimiento(int annoVencimiento) {
        this.annoVencimiento = annoVencimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
