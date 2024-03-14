/*
 * Universidad Técnica Nacional - UTN
 * Carrera de Ingeniería del Software
 * Curso ISW-311 Programación II
 * Prof. Ing. Alexánder Agüero Castillo
 */
package sisPlanSeguridad;

/**
 * Clase EEstadoPlanilla: Lista numerada de los roles de usuarios
 * Referencia: Material de Curso
 * @author Ing. Alexander Agüero Castillo
 * @version 3.1
 * @since Julio 2020
 */
public enum ERolesUsuario {
    ADMINISTRADOR(1, "Rol Administrador"),
    MANTENIMIENTO(2, "Rol Mantenimiento"),
    CONSULTAS(3, "Rol Consultas");
    
    private int numeroRol;
    private String descripcionRol;
    
    private ERolesUsuario(int pNumeroRol, String pDescripcionRol){
        this.numeroRol = pNumeroRol;
        this.descripcionRol = pDescripcionRol;
    }

    public void setNumeroRol(int numeroRol) {
        this.numeroRol = numeroRol;
    }

    public int getNumeroRol() {
        return numeroRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }
    
    @Override
    public String toString(){
        return this.numeroRol + " - " + this.descripcionRol;
    }

    public static ERolesUsuario buscarRol(int pNumeroRol){
        ERolesUsuario oRoleUsuario = null;

        switch (pNumeroRol){
            case 1:
                oRoleUsuario = ERolesUsuario.ADMINISTRADOR;
                break;
            case 2:
                oRoleUsuario = ERolesUsuario.MANTENIMIENTO;
                break;
            case 3:
                oRoleUsuario = ERolesUsuario.CONSULTAS;
                break;                    
        }
        
        return oRoleUsuario;
    }
}
