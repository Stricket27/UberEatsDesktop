/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisPlanEntidades;

/**
 *
 * @author moise
 */
public class Usuario {
    
    protected String codigo;
    protected String nombre;
    protected String correoElectronico;
    protected String contrasenia;
    protected PaisOrigen pais;
    protected Tarjeta tarjeta;
    protected Perfil perfil;

    public Usuario() {
    }

    public Usuario(String codigo, String nombre, String correoElectronico, String contrasenia, PaisOrigen pais, Tarjeta tarjeta, Perfil perfil) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasenia = contrasenia;
        this.pais = pais;
        this.tarjeta = tarjeta;
        this.perfil = perfil;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public PaisOrigen getPais() {
        return pais;
    }

    public void setPais(PaisOrigen pais) {
        this.pais = pais;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    
    
    
    
    
    
    
    
}
