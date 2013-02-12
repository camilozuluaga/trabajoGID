/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jucazuse
 */
public final class Hilo extends Thread {

    JRCsvDataSource dataSource;
    String separador=System.getProperty("file.separator");
  

    private JRCsvDataSource getDataSource() throws URISyntaxException, JRException {
        String[] nombreColumnas = new String[]{"Tipo Identificacion", "Identificacion", "Nombre", "Apellido", "Fecha Nacimiento", "Edad", "Genero", "Ciudad Residencia", "EPS"};
        File f1 = new File(System.getProperty("user.dir").concat(separador).concat("registro.txt"));
        String filePath = f1.getAbsolutePath().toString();
        dataSource = new JRCsvDataSource(filePath);
        dataSource.setFieldDelimiter(';');
        dataSource.setColumnNames(nombreColumnas);
        return dataSource;
    }

    public void reporte() {
        try {
            File f = new File(System.getProperty("user.dir").concat(separador).concat("registrados.jasper"));
            String rutaAbsoluta = f.getAbsolutePath().toString();
            System.out.println("ruta "+rutaAbsoluta);
            System.out.println("f "+ f);
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(rutaAbsoluta);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, getDataSource());
            
            /*esto nos permite visualizar nuestro reporte de forma mas ligera
             sin necesidad de buscar el archivo pdf*/
            JasperViewer ver = new JasperViewer(jasperPrint);
            ver.setTitle("Registrados");
            ver.setVisible(true);
           
            /*este nos imprime el archivo y no lo guarda en la carpeta del proyecto*/
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Usuarios Registrados.pdf"));
            exporter.exportReport();

        } catch (URISyntaxException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            System.out.println("error generando el reporte " + ex);
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        reporte();
    }
    /**
     * En este caso cree la clase Hilo, que hereda de un Thread. en su
     * constructor utilize un String que es opcional para poner el nombre del
     * nuevo thread creado y mediante "super()" se llama al constructor de la
     * super-clase Thread asi mismo se redefine al metodo run() que define la
     * principal actividad del thread
     */
}
