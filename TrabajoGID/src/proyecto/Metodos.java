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

    private List<Datos> datos = new ArrayList<>();
    private int datosActuales = -1;

    @Override
    public boolean next() throws JRException {
        return ++datosActuales < datos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;

        if ("Tipo Identificacion".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getTipoDocumento();
        } else if ("Documento".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getNumDocumento();
        } else if ("Nombre".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getNombre();
        } else if ("Apellido".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getApellido();
        } else if ("Fecha Nacimiento".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getFechaNaci();
        } else if ("Edad".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getEdad();
        } else if ("Sexo".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getSexo();
        } else if ("Ciudad Residencia".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getCiudadResi();
        } else if ("EPS".equals(jrf.getName())) {
            valor = datos.get(datosActuales).getEPS();
        }
        return valor;
    }

    public void addDatos(Datos datos) {
        this.datos.add(datos);
    }
}
