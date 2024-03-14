/*
 * Universidad Técnica Nacional - UTN
 * Carrera de Ingeniería del Software
 * Curso ISW-311 Programación II
 * Prof. Ing. Alexánder Agüero Castillo
 */
package sisPlanSeguridad;

import java.util.Date;

/**
 * Clase Auditoria: Clase que representa los campos de auditoria para todo registro entidad
 * Referencia: Material de Curso
 * @author Ing. Alexander Agüero Castillo
 * @version 1.0
 * @since Julio 2020
 */
public class Auditoria {
    private String cod_usr_crea;
    private Date fec_creacion;
    private String cod_usr_modifica;
    private Date fec_modificacion;
    
    /**
     * Constructor de la clase
     * @param pCod_usr_crea
     * @param pFec_creacion
     * @param pCod_usr_modifica
     * @param pFec_modificacion 
     */
    public Auditoria(String pCod_usr_crea, Date pFec_creacion, String pCod_usr_modifica, Date pFec_modificacion){
        this.cod_usr_crea = pCod_usr_crea;
        this.fec_creacion = pFec_creacion;
        this.cod_usr_modifica = pCod_usr_modifica;
        this.fec_modificacion = pFec_modificacion;
    }
    
    /**
     * @return the cod_usr_crea
     */
    public String getCod_usr_crea() {
        return cod_usr_crea;
    }

    /**
     * @return the fec_creacion
     */
    public Date getFec_creacion() {
        return fec_creacion;
    }

    /**
     * @return the cod_usr_modifica
     */
    public String getCod_usr_modifica() {
        return cod_usr_modifica;
    }

    /**
     * @return the fec_modificacion
     */
    public Date getFec_modificacion() {
        return fec_modificacion;
    }

    /**
     * @param cod_usr_crea the cod_usr_crea to set
     */
    public void setCod_usr_crea(String cod_usr_crea) {
        this.cod_usr_crea = cod_usr_crea;
    }

    /**
     * @param fec_creacion the fec_creacion to set
     */
    public void setFec_creacion(Date fec_creacion) {
        this.fec_creacion = fec_creacion;
    }

    /**
     * @param cod_usr_modifica the cod_usr_modifica to set
     */
    public void setCod_usr_modifica(String cod_usr_modifica) {
        this.cod_usr_modifica = cod_usr_modifica;
    }

    /**
     * @param fec_modificacion the fec_modificacion to set
     */
    public void setFec_modificacion(Date fec_modificacion) {
        this.fec_modificacion = fec_modificacion;
    }
    
    
}
