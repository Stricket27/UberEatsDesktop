/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author moise
 */
public class Conexion {

    private static Connection conexion;

    public static Connection getConnection() {
        String conexionURL = "jdbc:sqlserver://localhost:1433;"
                + "databaseName=UberEats;"
                + "user=sa;"
                + "password=123456;" 
                + "encrypt=true;"
                + "trustServerCertificate=true";
        try {

            conexion = DriverManager.getConnection(conexionURL);
            return conexion;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    public static void cerrarConexionBaseDatos() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException SQLEX) {
            System.out.println(SQLEX.toString());
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
