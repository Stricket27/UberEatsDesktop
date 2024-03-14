/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.CallableStatement;
import java.sql.SQLException;
import sisPlanEntidades.Tarjeta;
import sisPlanEntidades.Usuario;

/**
 *
 * @author moise
 */
public class TarjetaDAL {
    
    public static void insertaTarjeta (Tarjeta pTarjeta, Usuario pUsuario) throws SQLException, Exception{
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL InsertarTarjeta(?,?,?,?,?,?)}");
        comando.setString(1, pTarjeta.getNumero());
        comando.setString(2, String.valueOf(pTarjeta.getMesVencimiento()));
        comando.setString(3, String.valueOf(pTarjeta.getAnnoVencimiento()));
        comando.setString(4, pTarjeta.getCodigo());
        comando.setInt(5, pTarjeta.getTipoTarjeta().getNumero());
        comando.setString(6, pUsuario.getCodigo()); 
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
    }


    
    
    
    
    
    
    
    
    
    
    
}
