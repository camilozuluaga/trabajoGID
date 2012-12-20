/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author jucazuse
 */
public class Metodos implements JRDataSource {

    private List<Datos> atributos = new ArrayList<>();
    private int datosActuales = -1;

    @Override
    public boolean next() throws JRException {
        return ++datosActuales < atributos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if ("Numero".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getNumero();
        } else if ("TipoDocumento".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getTipoDocumento();
        } else if ("Documento".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getNumDocumento();
        } else if ("Nombre".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getNombre();
        } else if ("Apellido".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getApellido();
        } else if ("FechaNacimiento".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getFechaNaci();
        } else if ("Edad".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getEdad();
        } else if ("Sexo".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getSexo();
        } else if ("CiudadResi".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getCiudadResi();
        } else if ("EPS".equals(jrf.getName())) {
            valor = atributos.get(datosActuales).getEPS();
        }
        return valor;
    }

    public void addDatos(Datos atributos) {
        this.atributos.add(atributos);
    }
}
