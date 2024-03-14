/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sisPlanEntidades.Restaurante;
import sisPlanEntidades.TipoComida;
import sisPlanEntidades.Usuario;

/**
 *
 * @author moise
 */
public class RestauranteDAL {
    
    public static void insertaRestaurante (Restaurante pRestaurante, Usuario usuario) throws Exception{
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL InsertarRestaurante (?,?,?,?,?)}");
        comando.setString(1, pRestaurante.getCodigo());
        comando.setString(2, pRestaurante.getNombre());
        comando.setString(3, pRestaurante.getLocalizacion());
        comando.setString(4, pRestaurante.getTipoComida().name());
        comando.setString(5, usuario.getCodigo());
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
 
    
    }
        
public static boolean codigoVerificarRestaurante (String codigoRestaurante) throws Exception{
        boolean exist = false;
        
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL verficiarCodigoRestaurante (?)}");
        comando.setString(1, codigoRestaurante);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                exist = true;
            }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        
        return exist;
    }
    
    public static ArrayList <Restaurante> restaurantePorGerente (String codigoG) throws Exception{
        
        ArrayList <Restaurante> lista = new ArrayList<>();
        
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL buscarRestauranteGerente (?)}");
        comando.setString(1, codigoG);
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            Restaurante restaurante = new Restaurante ();
            restaurante.setCodigo(resultado.getString(1));
            restaurante.setNombre(resultado.getString(2));
            restaurante.setLocalizacion(resultado.getString(3));
            for (TipoComida value : TipoComida.values()) {
                if (value.name().equals(resultado.getString(4))){
                    restaurante.setTipoComida(value);
                }
            }
            lista.add(restaurante);
        }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        return lista;
    }
    
    
//    public static void modificarRestaurante (Restaurante pRestaurante) throws Exception{
//        try{
//           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL modificarTablaRestaurantes (?,?,?,?)}");
//        comando.setString(1, pRestaurante.getCodigo());
//        comando.setString(2, pRestaurante.getNombre());
//        comando.setString(3, pRestaurante.getLocalizacion());
//        comando.setString(4, pRestaurante.getTipoComida().name());
//        comando.execute();
//        Conexion.cerrarConexionBaseDatos();
//        } catch (Exception ex) {
//            throw new Exception ("Hubo un error");
//        }
// 
//    
//    }
//    
//    public static void eliminarRestaurante (String codigo) throws Exception{
//        try{
//           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL eliminarRestaurante (?)}");
//        comando.setString(1, codigo);
//        comando.execute();
//        Conexion.cerrarConexionBaseDatos();
//        } catch (Exception ex) {
//            throw new Exception ("Hubo un error");
//        }
// 
//    
//    }
    
    public static ArrayList <Restaurante> buscarRestauranteporTipoComida (String comida) throws Exception{
        ArrayList <Restaurante> lista = new ArrayList<>();
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerRestaurantePorTipoComida (?)}");
        comando.setString(1, comida);
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            Restaurante restaurante = new Restaurante ();
            restaurante.setCodigo(resultado.getString(1));
            restaurante.setNombre(resultado.getString(2));
            restaurante.setLocalizacion(resultado.getString(3));
            for (TipoComida value : TipoComida.values()) {
                if (value.name().equals(resultado.getString(4))){
                    restaurante.setTipoComida(value);
                }
            }
            restaurante.setMostrarCaificacion(true);
            restaurante.setArrayCalificaciones(obtenerCalificacionesRestaurante(restaurante.getCodigo()));
            lista.add(restaurante);
        }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        return lista;
    }
    
    public static ArrayList <Restaurante> todosRestaurantes () throws Exception{
        ArrayList <Restaurante> lista = new ArrayList<>();
        try{
        CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerRestaurantes ()}");
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            Restaurante restaurante = new Restaurante ();
            restaurante.setCodigo(resultado.getString(1));
            restaurante.setNombre(resultado.getString(2));
            restaurante.setLocalizacion(resultado.getString(3));
            for (TipoComida value : TipoComida.values()) {
                if (value.name().equals(resultado.getString(4))){
                    restaurante.setTipoComida(value);
                }
            }
            restaurante.setMostrarCaificacion(true);
            restaurante.setArrayCalificaciones(obtenerCalificacionesRestaurante(restaurante.getCodigo()));
            lista.add(restaurante);
        }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        return lista;
    }
    
    public static Restaurante buscarRestaurante (String id) throws Exception{
        Restaurante restaurante = new Restaurante ();
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerRestaurante (?)}");
        comando.setString(1, id);
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            restaurante.setCodigo(resultado.getString(1));
            restaurante.setNombre(resultado.getString(2));
            restaurante.setLocalizacion(resultado.getString(3));
            for (TipoComida value : TipoComida.values()) {
                if (value.name().equals(resultado.getString(4))){
                    restaurante.setTipoComida(value);
                }
            }
            restaurante.setMostrarCaificacion(true);
            restaurante.setArrayCalificaciones(obtenerCalificacionesRestaurante(restaurante.getCodigo()));
        }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        return restaurante;
    }
    
    public static ArrayList <Integer> obtenerCalificacionesRestaurante (String IDRestaurante) throws Exception{
        ArrayList <Integer> lista = new ArrayList<>();
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerCalificacionRestaurante (?)}");
        comando.setString(1, IDRestaurante);
        ResultSet resultado = comando.executeQuery();
        while (resultado.next()){
            lista.add(resultado.getInt(1));
        }
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
        return lista;
    }
    
    public static void insertaCalificacionRestaurante (Restaurante pRestaurante, int Calificacion) throws Exception{
        try{
        CallableStatement comando = Conexion.getConnection().prepareCall("{CALL InsertarCalificacion (?,?)}");
        comando.setInt(1, Calificacion);
        comando.setString(2, pRestaurante.getCodigo());
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }   
    }
}
