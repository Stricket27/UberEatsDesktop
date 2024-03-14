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
public enum Moneda {
    
    Colones (0.0),
    Dolares (575.0){
        @Override
        public String toString (){
            return "Dólares";
        }
    };
    
    private double cambioDolar;

    private Moneda(double cambioDolar) {
        this.cambioDolar = cambioDolar;
    }

    public double getCambioDolar() {
        return cambioDolar;
    }
    
    
    
    
    
    
    
}
