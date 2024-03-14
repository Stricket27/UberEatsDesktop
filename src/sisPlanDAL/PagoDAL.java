/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.CallableStatement;
import java.sql.SQLException;
import sisPlanEntidades.Moneda;
import sisPlanEntidades.OrdenCompra;
import sisPlanEntidades.Pago;

/**
 *
 * @author User
 */
public class PagoDAL {
    public static void insertaOrdenCompra(Pago pago, int orden) throws SQLException, Exception{
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL insertarPago(?,?,?,?)}");
        comando.setDate(1, (java.sql.Date)pago.getFechaPago());
        if(pago.getMoneda() == Moneda.Colones){
            comando.setFloat(2, (float) pago.getMontoPagoColones());
        }else{
            comando.setFloat(2, (float) pago.getMontoPagoDolares());
        }
        comando.setString(3, pago.getMoneda().toString());
        comando.setString(4, String.valueOf(orden));
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
    }
}
