/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanDAL;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sisPlanEntidades.PaisOrigen;
import sisPlanEntidades.Perfil;
import sisPlanEntidades.Usuario;

/**
 *
 * @author moise
 */
public class UsuarioDAL {
    
    public static void insertaUsuario (Usuario pUsuario) throws SQLException, Exception{
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL InsertarUsuario(?,?,?,?,?,?)}");
        comando.setString(1, pUsuario.getCodigo());
        comando.setString(2, pUsuario.getNombre());
        comando.setString(3, pUsuario.getCorreoElectronico());
        comando.setString(4, pUsuario.getContrasenia());
        comando.setString(5, pUsuario.getPais().name());
        comando.setString(6, pUsuario.getPerfil().name()); 
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
    }
    
    
    public static boolean codigoVerificarUsuario (String codigoUsuario) throws Exception{
        boolean exist = false;
        
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL verificarCodigoUsuario (?)}");
        comando.setString(1, codigoUsuario);
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
    
    
    public static Usuario buscarUsuario (String correoElectronico, String contrasenia) throws SQLException, Exception{
        
        Usuario usuarioObtenido = null;
        
        try {
            
             CallableStatement comando = Conexion.getConnection().prepareCall("{CALL buscarUsuario (?,?)}");
             comando.setString(1, correoElectronico);
             comando.setString(2, contrasenia);
             ResultSet resultado = comando.executeQuery();
             if (resultado.next()){
                 usuarioObtenido = new Usuario ();
                 
                 usuarioObtenido.setCodigo(resultado.getString(1));
                 usuarioObtenido.setNombre(resultado.getString(2));
                 usuarioObtenido.setCorreoElectronico(resultado.getString(3));
                 usuarioObtenido.setContrasenia(resultado.getString(4));
                 
                 for (PaisOrigen value : PaisOrigen.values()) {
                     if (value.name().equals(resultado.getString(5))){
                         usuarioObtenido.setPais(value);
                     }
                 }
                 
                 for (Perfil value : Perfil.values()) {
                     if (value.name().equals(resultado.getString(6))){
                         usuarioObtenido.setPerfil(value);
                     }
                 }
             }
             Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex){
            throw new Exception ("Hubo un error");
        }
        
        return usuarioObtenido;
    }
    
    
    public static ArrayList<Usuario> ObtenerTodosUsuarios() throws Exception {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL ObtenerTodosUsuarios()}"); 
            ResultSet rs = comando.executeQuery();
            while(rs.next())
            {
                Usuario usuario = buscarUsuario(rs.getString(3), rs.getString(4));
                lista.add(usuario);
            }
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        return lista;
    }
    
}
