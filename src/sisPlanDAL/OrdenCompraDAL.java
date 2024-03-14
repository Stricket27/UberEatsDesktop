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
import sisPlanEntidades.LineaDetalle;
import sisPlanEntidades.OrdenCompra;
import sisPlanEntidades.Preparados;
import sisPlanEntidades.Producto;
import sisPlanEntidades.Usuario;

/**
 *
 * @author User
 */
public class OrdenCompraDAL {
    
        public static boolean ficharOrden(String numeroOrden) throws Exception {
        boolean exist = false;

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL ficharOrden (?)}");
            comando.setString(1, numeroOrden);
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
        
            
    public static void insertaOrdenCompra(OrdenCompra orden) throws SQLException, Exception{
        try{
           CallableStatement comando = Conexion.getConnection().prepareCall("{CALL insertarOrdenCompra(?,?,?,?)}");
        comando.setString(1, String.valueOf(orden.getNumeroOrdenes()));
        comando.setDate(2, (java.sql.Date)orden.getFechaOrden());
        comando.setString(3, orden.getCliente().getCodigo());
        comando.setString(4, orden.getRestaurante().getCodigo());
        comando.execute();
        Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception ("Hubo un error");
        }
    }
    
    public static ArrayList<OrdenCompra> listaFacturas(String idCliente) throws Exception {
        ArrayList<OrdenCompra> lista = new ArrayList<>();

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL ObtenerFacturaCliente (?)}");
            comando.setString(1, idCliente);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                OrdenCompra orden = new OrdenCompra();
                orden.setNumeroOrdenes(Integer.parseInt(resultado.getString(1)));
                ArrayList<Producto> listaP = ProductoDAL.productosEnFactura(String.valueOf(orden.getNumeroOrdenes()));
                for (Producto producto : listaP) {
                    LineaDetalle linea =  new LineaDetalle();
                    linea.setoProducto(producto);
                    if(producto instanceof Empacados){
                        linea.setCantidad(((Empacados)producto).getCantidadSeleccionada());
                    }else{
                        linea.setCantidad(1);
                    }
                    orden.agregarLineaDetalle(linea);
                }
                orden.setRestaurante(RestauranteDAL.buscarRestaurante(resultado.getString(4)));
                lista.add(orden);
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return lista;
    }
    
    public static ArrayList<OrdenCompra> todasFacturas() throws Exception {
        ArrayList<OrdenCompra> lista = new ArrayList<>();

        try {
            CallableStatement comando = Conexion.getConnection().prepareCall("{CALL todasFacturas()}");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                OrdenCompra orden = new OrdenCompra();
                orden.setNumeroOrdenes(Integer.parseInt(resultado.getString(1)));
                ArrayList<Producto> listaP = ProductoDAL.productosEnFactura(String.valueOf(orden.getNumeroOrdenes()));
                for (Producto producto : listaP) {
                    LineaDetalle linea =  new LineaDetalle();
                    linea.setoProducto(producto);
                    if(producto instanceof Empacados){
                        linea.setCantidad(((Empacados)producto).getCantidadSeleccionada());
                    }else{
                        linea.setCantidad(1);
                    }
                    orden.agregarLineaDetalle(linea);
                }
                orden.setRestaurante(RestauranteDAL.buscarRestaurante(resultado.getString(4)));
                lista.add(orden);
            }
            Conexion.cerrarConexionBaseDatos();
        } catch (Exception ex) {
            throw new Exception(ex.toString());
        }
        return lista;
    }
}
