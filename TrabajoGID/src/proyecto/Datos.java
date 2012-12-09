/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;

/**
 *
 * @author jucazuse
 */
public class Datos {
    
    private String numero;
    private String tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String apellido;
    private String fechaNaci;
    private String edad;
    private String sexo;
    private String ciudadResi;
    private String EPS;

    public Datos(File file) {
    
    }

    public Datos(String numero, String tipoDocumento, String numDocumento, String nombre, String apellido, String fechaNaci, String edad, String sexo, String ciudadResi, String EPS) {
        this.numero = numero;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaci = fechaNaci;
        this.edad = edad;
        this.sexo = sexo;
        this.ciudadResi = ciudadResi;
        this.EPS = EPS;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(String fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCiudadResi() {
        return ciudadResi;
    }

    public void setCiudadResi(String ciudadResi) {
        this.ciudadResi = ciudadResi;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }
   
    
}
