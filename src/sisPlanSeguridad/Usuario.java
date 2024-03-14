/*
 * Universidad Técnica Nacional - UTN
 * Carrera de Ingeniería del Software
 * Curso ISW-311 Programación II
 * Prof. Ing. Alexánder Agüero Castillo
 */
package sisPlanSeguridad;

/**
 * Clase Usuario: Representa una entidad Usuario para el servicio de base de datos
 * Referencia: Material de Curso
 * @author Ing. Alexander Agüero Castillo
 * @version 3.1
 * @since Julio 2019
 */
public class Usuario {
    private String codigoUsuario;
    private String nombreUsuario;
    private String claveUsuario;
    private ERolesUsuario rolUsuario;

    public Usuario() {
        this.codigoUsuario = "";
        this.nombreUsuario = "";
        this.claveUsuario = "";
        this.rolUsuario = null;
    }
    
    public Usuario(String pNumeroUsuario,
                   String pNombreUsuario,
                   String pClaveUsuario,
                   ERolesUsuario pRolUsuario) {
        this.codigoUsuario = pNumeroUsuario;
        this.nombreUsuario = pNombreUsuario;
        this.claveUsuario = pClaveUsuario;
        this.rolUsuario = pRolUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }
    
    public void setRolUsuario(ERolesUsuario rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public ERolesUsuario getRolUsuario() {
        return rolUsuario;
    }        
}
