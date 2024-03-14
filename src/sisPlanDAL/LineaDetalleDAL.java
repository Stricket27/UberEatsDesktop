/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.CallableStatement;
import java.sql.SQLException;
import sisPlanEntidades.Empacados;
import sisPlanEntidades.OrdenCompra;
import sisPlanEntidades.Preparados;
import sisPlanEntidades.Producto;

/**
 *
 * @author User
 */
public class LineaDetalleDAL {
    public static void insertaOrdenCompra(Producto producto, int orden) throws SQLException, Exception{
        try{
        CallableStatement comando = Conexion.getConnection().prepareCall("{CALL insertarLineaDetalle(?,?,?)}");
        comando.setString(1, producto.getCodigo());
        if(producto instanceof Preparados){
            comando.setInt(2, 1);
        }else{
            comando.setInt(2, ((Empacados)producto).getCantidadSeleccionada()); 
        }
        comando.setString(3, String.valueOf(orden));
        comando.execute();
        
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
    }
}
