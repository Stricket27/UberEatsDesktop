/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appSisPlan;

import sisPlanUtilitarios.UtilitarioVentana;

/**
 *
 * @author moise
 */
public class AppProyecto {

    public static void main(String[] args) {
        UtilitarioVentana.aplicarEstiloVentas(1);
        JFrmVentanaFondo fondo = new JFrmVentanaFondo();
        sisPlanUtilitarios.UtilitarioVentana.centrarVentanaJFrame(fondo, true);

    }

}
