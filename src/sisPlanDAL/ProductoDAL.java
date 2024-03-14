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
import sisPlanEntidades.Empacados;
import sisPlanEntidades.Preparados;
import sisPlanEntidades.Producto;
import sisPlanEntidades.Restaurante;
import sisPlanEntidades.TipoComida;

/**
 *
 * @author moise
 */
public class ProductoDAL {

    public static void insertarProductoRestaurante(Producto pProducto, Restaurante pRestaurante) throws SQLException, Exception {
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL InsertarProducto (?,?,?,?,?,?,?,?)}");
            comando.setString(1, pProducto.getCodigo());
            comando.setString(2, pProducto.getDescripcion());
            comando.setInt(3, pProducto.getPrecio());
            comando.setString(4, pRestaurante.getCodigo());
            if (pProducto instanceof Preparados) {
                comando.setString(5, String.valueOf(((Preparados) ((Producto) pProducto)).getTiempoPreparacion()));
                comando.setInt(6, 1);
                comando.setInt(8, ((Preparados) pProducto).getPorcentajeIVA());
            } else {
                comando.setString(5, "0");
                comando.setInt(6, ((Empacados) pProducto).getCantidad());
                comando.setInt(8, ((Empacados) pProducto).getPorcentajeImpuesto());
            }
            comando.setString(7, pProducto.getClass().getSimpleName());

            comando.execute();
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception("Hubo un error");
        }

    }

    public static boolean codigoVerificarProducto(String codigoProducto) throws Exception {
        boolean exist = false;

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL verificarCodigoProducto (?)}");
            comando.setString(1, codigoProducto);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                exist = true;
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception("Hubo un error");
        }

        return exist;
    }

    public static ArrayList<Producto> llenarProducto(String codigoRestaurante) throws Exception {

        ArrayList<Producto> lista = new ArrayList<>();

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL llenarTablaProducto (?)}");
            comando.setString(1, codigoRestaurante);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Producto producto = null;
                if (resultado.getString(7).equals("Preparados")) {
                    producto = new Preparados();
                    ((Preparados) producto).setTiempoPreparacion((int) resultado.getDouble(5));
                    ((Preparados) producto).setPorcentajeIVA(resultado.getInt(9));
                } else {
                    producto = new Empacados();
                    ((Empacados) producto).setCantidad(resultado.getInt(6));
                    ((Empacados) producto).setPorcentajeImpuesto(resultado.getInt(9));
                }
                producto.setCodigo(resultado.getString(1));
                producto.setDescripcion(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                lista.add(producto);
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return lista;

    }

    public static void modificarProductoRestaurante(Producto pProducto, Restaurante pRestaurante) throws SQLException, Exception {
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL modificarProductos (?,?,?,?,?,?,?,?)}");
            comando.setString(1, pProducto.getCodigo());
            comando.setString(2, pProducto.getDescripcion());
            comando.setInt(3, pProducto.getPrecio());
            comando.setString(4, pRestaurante.getCodigo());
            if (pProducto instanceof Preparados) {
                comando.setString(5, String.valueOf(((Preparados) ((Producto) pProducto)).getTiempoPreparacion()));
                comando.setInt(6, 1);
                comando.setInt(8, ((Preparados) pProducto).getPorcentajeIVA());

            } else {
                comando.setString(5, "Ya esta preparado");
                comando.setInt(6, ((Empacados) pProducto).getCantidad());
                comando.setInt(8, ((Empacados) pProducto).getPorcentajeImpuesto());
            }
            comando.setString(7, pProducto.getClass().getSimpleName());

            comando.execute();
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
    }

    public static void eliminarProductoRestaurante(String codigo) throws Exception {
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL eliminarProducto(?)}");
            comando.setString(1, codigo);
            comando.execute();
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
    }

    public static void actualizarStock (String codigo, int cantidad) throws Exception {
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL actualizarStock(?,?)}");
            comando.setString(1, codigo);
            comando.setInt(2, cantidad);
            comando.execute();
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
    }

    public static Producto prodcutoFactura(String idProdcuto) throws Exception {
        Producto producto = null;
        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerProducto (?)}");
            comando.setString(1, idProdcuto);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                if (resultado.getString(7).equals("Preparados")) {
                    producto = new Preparados();
                    ((Preparados) producto).setTiempoPreparacion((int) resultado.getDouble(5));
                    ((Preparados) producto).setPorcentajeIVA(resultado.getInt(9));
                } else {
                    producto = new Empacados();
                    ((Empacados) producto).setCantidad(resultado.getInt(6));
                    ((Empacados) producto).setPorcentajeImpuesto(resultado.getInt(9));
                }
                producto.setCodigo(resultado.getString(1));
                producto.setDescripcion(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return producto;
    }
    
    public static ArrayList<Producto> productosEnFactura(String IDOrden) throws Exception {

        ArrayList<Producto> lista = new ArrayList<>();

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL obtenerLineaDetalleFactura (?)}");
            comando.setString(1, IDOrden);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
               Producto producto = prodcutoFactura(resultado.getString(2));
               if(producto instanceof Empacados){
                   ((Empacados)producto).setCantidadSeleccionada(resultado.getInt(3));
               }
               lista.add(producto);
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return lista;

    }
}
