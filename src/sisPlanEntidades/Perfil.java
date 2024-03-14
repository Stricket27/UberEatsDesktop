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
public enum Perfil {
    
    ADMINISTRADOR,
    GERENTE,
    CLIENTE_REGULAR (){
        public String nombre (){
            return "Cliente Regular";
        }
    }
    
    
}
