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
public enum TipoTarjeta {
    
    VISA (2),
    MASTER_CARD(1){
        public String nombre (){
            return "Master Card";
        }
    };
    
    private final int numero;

    private TipoTarjeta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
