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
    /**
     */
    
    private String tipoDocumento;
    private String numDocumento;
    private String nombre;
    private String apellido;
    private String fechaNaci;
    private String Edad;
    private String Sexo;
    private String ciudadResi;
    private String EPS;

    public Datos(File file) {
    
    }

    public Datos(String tipoDocumento, String numDocumento, String nombre, String apellido, String fechaNaci, String edad, String sexo, String ciudadResi, String EPS) {
        
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNaci = fechaNaci;
        this.Edad = edad;
        this.Sexo = sexo;
        this.ciudadResi = ciudadResi;
        this.EPS = EPS;
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
        return Edad;
    }

    public void setEdad(String edad) {
        this.Edad = edad;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        this.Sexo = sexo;
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
