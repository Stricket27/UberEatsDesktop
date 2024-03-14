/*
 * Universidad Técnica Nacional - UTN
 * Carrera de Ingeniería del Software
 * Curso ISW-311 Programación II
 * Prof. Ing. Alexánder Agüero Castillo
 */
package sisPlanUtilitarios;

import java.util.Stack;

/**
 * Clase Pila: Clase para trasportar valores
 * Referencia: Material de Curso
 * @author Ing. Alexander Agüero Castillo
 * @version 3.0
 * @since Julio 2019
 */
public class Pila {
    private static final Stack oPila = new Stack();

    /**
     * Retornar si la pila está vacía
     * @return True si la pila está vacía
     */
    public static boolean pilaVacia(){
        return oPila.isEmpty();
    }
    
    /**
     * Extraer el último elemento de la pila
     * Si la pila está vacía, retorna vacío
     * @return último elemento de la pila
     */
    public static String sacarUltimoElemento(){
        String vResultado = "";
        
        if (!oPila.isEmpty()){
            vResultado = (String)oPila.pop();
        }
        return vResultado;
    }
    
    /**
     * Agregar un valor a la pila
     * @param pValor Valor a agregar
     */
    public static void agregarElemento(String pValor){
        oPila.push(pValor);
    }    
}
