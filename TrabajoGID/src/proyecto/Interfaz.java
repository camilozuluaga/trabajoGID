/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public final class Interfaz extends javax.swing.JFrame {

    /* variable que sirve para guardar lo obtenido en la caja de texto 
     * Identificacion*/
    public String nDocumento;
    /*tamaño del string Identificacion*/
    public int tam;
    /*indice de la tabla */
    public int contador = 1;
    /*variable para capturar el año de nacimiento del Usuario*/
    public int annoNaci;
    /*variable donde se guarda el calculo de la edad del Usuario. 
     *parametro: año nacimiento usuario y año del sistema.
     * resultados: se restan y ahi da la edad del usuario.
     */
    public int edad;
    /*Variable donde se guarda el genero del usuari@*/
    public String sexo;
    /*variable a la que se le pasa si hay mas token en la cadena determinada*/
    public String line;
    /*Clase para escribir (Archivos)*/
    FileWriter fichero = null;
    /*Clase para escribir diferentes tipos de elementos*/
    PrintWriter pw = null;
    /*Variable que sirve para guardar la siguiente linea 
     del texto leido */
    String fila;
    /*Array de tipo String que despues de cortar la linea del archivo
     leido guarda los datos obtenidos*/
    String[] posiciones;
    /*Variable de tipo File donde le damos la ruta donde se encuentra nuestro 
     archivo tanto para ser leido como modificado*/
    File file = new File("C:/Users/jucazuse/Documents/NetBeansProjects/TrabajoGID/src/archivo/registro.txt");
    Calendar annoSistema = new GregorianCalendar();
    /*esta variable es el año del sistema */
    int anno = annoSistema.get(Calendar.YEAR);
    /**/
    DefaultTableModel modeloTabla;
    String[] rowfields;
    private String tipoDoc, documento, nombre, apellido,
            fechaNaci, edad1, genero, ciudadRe, ePS;
    /*lee una secuencia de archivo CSV*/
    JRCsvDataSource dataSource;
    private String idioma;

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        llenarCbIdentificacion();
        llenarCbCiudadResidencia();
        llenarCbEPS();
        cargarTabla();
        idioma=configLenguage();
        obtenerLenguage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbTipoIdentificacion = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbFechaNacimiento = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        cbIdentificacion = new javax.swing.JComboBox();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        cbCiudadR = new javax.swing.JComboBox();
        lbCiudadResidencia = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbIdentificacion = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbSexo = new javax.swing.JLabel();
        lbEPS = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        rbFemenino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        cbEPS = new javax.swing.JComboBox();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        lbBuscar = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRegistro = new javax.swing.JTable();
        btnInforme = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Usuario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 255)));
        lbTipoIdentificacion.setBounds(20, 24, 100, 20);
        jLayeredPane1.add(lbTipoIdentificacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbNombre.setBounds(20, 64, 110, 20);
        jLayeredPane1.add(lbNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbFechaNacimiento.setBounds(20, 110, 150, 30);
        jLayeredPane1.add(lbFechaNacimiento, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnGuardarMouseReleased(evt);
            }
        });
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.setBounds(20, 230, 130, 30);
        jLayeredPane1.add(btnGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbIdentificacion.setBounds(170, 20, 180, 30);
        jLayeredPane1.add(cbIdentificacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDateFecha.setBounds(170, 110, 180, 30);
        jLayeredPane1.add(jDateFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbCiudadR.setBounds(170, 160, 180, 30);
        jLayeredPane1.add(cbCiudadR, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbCiudadResidencia.setBounds(20, 170, 120, 20);
        jLayeredPane1.add(lbCiudadResidencia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        txtNombre.setBounds(170, 60, 180, 30);
        jLayeredPane1.add(txtNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbIdentificacion.setBounds(400, 20, 110, 30);
        jLayeredPane1.add(lbIdentificacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbApellido.setBounds(400, 60, 90, 30);
        jLayeredPane1.add(lbApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lbSexo.setBounds(400, 110, 80, 30);
        jLayeredPane1.add(lbSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lbEPS.setText("EPS");
        lbEPS.setBounds(400, 160, 50, 30);
        jLayeredPane1.add(lbEPS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtIdentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdentificacionKeyReleased(evt);
            }
        });
        txtIdentificacion.setBounds(510, 20, 190, 30);
        jLayeredPane1.add(txtIdentificacion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });
        txtApellidos.setBounds(510, 60, 190, 30);
        jLayeredPane1.add(txtApellidos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(rbFemenino);
        rbFemenino.setBounds(510, 110, 80, 21);
        jLayeredPane1.add(rbFemenino, javax.swing.JLayeredPane.DEFAULT_LAYER);

        buttonGroup1.add(rbMasculino);
        rbMasculino.setBounds(610, 110, 80, 21);
        jLayeredPane1.add(rbMasculino, javax.swing.JLayeredPane.DEFAULT_LAYER);

        cbEPS.setBounds(510, 160, 190, 30);
        jLayeredPane1.add(cbEPS, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Usuarios"));
        lbBuscar.setBounds(10, 30, 160, 30);
        jLayeredPane2.add(lbBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Tipo Identificacion", "Identificacion", "Nombre", "Apellido", "Fecha Nacimiento", "Edad", "Sexo", "Ciudad Residencia", "EPS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTRegistro);

        jScrollPane2.setBounds(10, 70, 1080, 120);
        jLayeredPane2.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });
        btnInforme.setBounds(20, 260, 160, 30);
        jLayeredPane2.add(btnInforme, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        txtBuscar.setBounds(190, 30, 190, 30);
        jLayeredPane2.add(txtBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        /*esta variable obtiene el año de nacimiento*/
        annoNaci = jDateFecha.getCalendar().get(Calendar.YEAR);

        /*esta variable nos muestra la edad*/
        edad = (anno - annoNaci);

        /*Aqui obtenemos la fecha del JDateChooser*/
        Date date = jDateFecha.getDate();

        /*preparamos el formato que se le dara a la fecha.
         de esta forma es que se le da el formato a la fecha
         dt.format(date)*/
        SimpleDateFormat dt = new SimpleDateFormat("dd/MMM/yyyy");

        /*este es una condicion con operadores ternarios para ver el sexo */
        sexo = (rbMasculino.isSelected()) ? "Masculino" : "Femenino";

        /*con esto le damos el modelo a la tabla */
        modeloTabla = (DefaultTableModel) jTRegistro.getModel();

        /*Nombre de las filas que va a tener la tabla*/
        Object nuevo[] = {
            contador++, cbIdentificacion.getSelectedItem(), txtIdentificacion.getText(), txtNombre.getText(),
            txtApellidos.getText(), dt.format(date), edad, sexo,
            cbCiudadR.getSelectedItem(), cbEPS.getSelectedItem()
        };

        /*añadimos las filas a la tabla */
        modeloTabla.addRow(nuevo);

        /*metodo para guardar el archivo */
        guardarArchivo(file);
        
        /*limpiamos los campos de texto despues de haber guardado 
         la informacion*/
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        reporte();
    }//GEN-LAST:event_btnInformeActionPerformed

    private void txtIdentificacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentificacionKeyReleased
        compararDocumento();

        /*condicion para validar los campos de texto para que solo contengan 
         numeros*/
        if (!txtIdentificacion.getText().matches("[ 0-9 ]*")) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosInvalidos"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtIdentificacion.setText("");
        }
        nDocumento = txtIdentificacion.getText();
        tam = nDocumento.length();

        /*condicion para validar que los  campos de texto no excedan el tamaño. 
         en este caso una cedula que tiene 10 digitos por ejemplo*/
        if (tam > 12) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosCedula"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtIdentificacion.setText("");
        }
    }//GEN-LAST:event_txtIdentificacionKeyReleased

    private void btnGuardarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseReleased
        /*para activar el boton despues de haber sido bloqueado si el numero
         de cedula ya aparece registrado*/
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarMouseReleased

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        buscarRegistrados();
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        /*condicion para validar que en el campo de texto solo hayan 
         letras*/
        if (!txtNombre.getText().matches("[ /s a-zA-z]*")) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosInvalidos"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtNombre.setText("");
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        if (!txtApellidos.getText().matches("[ /s a-zA-z]*")) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosInvalidos"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtApellidos.setText("");
        }
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        if (!txtBuscar.getText().matches("[ 0-9 ]*")) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosInvalidos"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtBuscar.setText("");
        }
        /*variable de la cedula*/
        nDocumento = txtBuscar.getText();
        /*tamaño del String*/
        tam = nDocumento.length();
        if (tam > 12) {
            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("datosCedula"), "VALIDACION", JOptionPane.ERROR_MESSAGE);
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnInforme;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbCiudadR;
    private javax.swing.JComboBox cbEPS;
    private javax.swing.JComboBox cbIdentificacion;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRegistro;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JLabel lbCiudadResidencia;
    private javax.swing.JLabel lbEPS;
    private javax.swing.JLabel lbFechaNacimiento;
    private javax.swing.JLabel lbIdentificacion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbSexo;
    private javax.swing.JLabel lbTipoIdentificacion;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void llenarCbIdentificacion() {
        cbIdentificacion.addItem("Cedula");
        cbIdentificacion.addItem("Tarjeta Identidad");
        cbIdentificacion.addItem("NN");
    }

    private void llenarCbCiudadResidencia() {
        cbCiudadR.addItem("Alcala");
        cbCiudadR.addItem("Andalucia");
        cbCiudadR.addItem("Ansermanuevo");
        cbCiudadR.addItem("Argelia");
        cbCiudadR.addItem("Bolivar");
        cbCiudadR.addItem("Buenaventura");
        cbCiudadR.addItem("Buga");
        cbCiudadR.addItem("Bugalagrande");
        cbCiudadR.addItem("Caicedonia");
        cbCiudadR.addItem("Cali");
        cbCiudadR.addItem("Calima Darien");
        cbCiudadR.addItem("Candelaria");
        cbCiudadR.addItem("Cartago");
        cbCiudadR.addItem("Dagua");
        cbCiudadR.addItem("El Aguila");
        cbCiudadR.addItem("El Cairo");
        cbCiudadR.addItem("El Cerrito");
        cbCiudadR.addItem("El Dovio");
        cbCiudadR.addItem("Florida");
        cbCiudadR.addItem("Ginebra");
        cbCiudadR.addItem("Guacari");
        cbCiudadR.addItem("Jamundi");
        cbCiudadR.addItem("La Cumbre");
        cbCiudadR.addItem("La Union");
        cbCiudadR.addItem("La Victoria");
        cbCiudadR.addItem("Obando");
        cbCiudadR.addItem("Palmira");
        cbCiudadR.addItem("Pradera");
        cbCiudadR.addItem("Restrepo");
        cbCiudadR.addItem("Riofrío");
        cbCiudadR.addItem("Roldanillo");
        cbCiudadR.addItem("San Pedro");
        cbCiudadR.addItem("Sevilla");
        cbCiudadR.addItem("Toro");
        cbCiudadR.addItem("Trujillo");
        cbCiudadR.addItem("Tulua");
        cbCiudadR.addItem("Ulloa");
        cbCiudadR.addItem("Versalles");
        cbCiudadR.addItem("Vijes");
        cbCiudadR.addItem("Yotoco");
        cbCiudadR.addItem("Yumbo");
        cbCiudadR.addItem("Zarzal");
    }

    private void llenarCbEPS() {
        cbEPS.addItem("Saludcoop");
        cbEPS.addItem("Coomeva");
        cbEPS.addItem("Quiron");
        cbEPS.addItem("Emssanar");
        cbEPS.addItem("Casur");
        cbEPS.addItem("Cosmited");
    }

    /**
     * Este metodo funciona de la siguiente manera:
     * 1.
     */
    private void guardarArchivo(File file) {
        /*esta es la fecha del jDateChooser*/
        Date date = jDateFecha.getDate();
        SimpleDateFormat dt = new SimpleDateFormat("dd/MMM/yyyy");

        /*token: subString*/
        
        /*divide una cadena en tokens. atendiendo a un delimitador en concreto*/
        StringTokenizer st = new StringTokenizer("/n",";");

        /*hasMoreTokens: Mira si hay mas tokens en el array de token que tiene 
         StringTokenizer*/
        
        /*nextToken: devuelve el siguiente token*/
        try {
            fichero = new FileWriter(file, true);
            pw = new PrintWriter(fichero);
            //se guarda linea por linea en el archivo
            while (st.hasMoreTokens()) {
                line = st.nextToken();
                pw.print(cbIdentificacion.getSelectedItem());
                pw.print(";");
                pw.print(txtIdentificacion.getText());
                pw.print(";");
                pw.print(txtNombre.getText());
                pw.print(";");
                pw.print(txtApellidos.getText());
                pw.print(";");
                pw.print(dt.format(date));
                pw.print(";");
                pw.print(edad);
                pw.print(";");
                pw.print(sexo);
                pw.print(";");
                pw.print(cbCiudadR.getSelectedItem());
                pw.print(";");
                pw.print(cbEPS.getSelectedItem());
                pw.print(";");
                pw.println();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Este metodo lo que hace es leer el archivo y comparar si el numero de
     * Documento Inscrito en el jTextField es igual al que hay en el archivo
     * plano. si son iguales mandara un mensaje de informacion al usuario
     */
    public void compararDocumento() {
        try {
            Scanner scan;
            try {
                scan = new Scanner(new File(getClass().getResource("/archivo/registro.txt").toURI()));
                while (scan.hasNext()) {
                    fila = scan.nextLine();
                    fila = fila.replace(", ", ","); //Quitamos los espacios en blanco despues de la coma 
                    posiciones = fila.split(";");
                    for (int i = 0; i < posiciones.length; i++) {
                        if (posiciones[i].equals(txtIdentificacion.getText())) {
                            JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("validarCedula"),
                                    ("Validacion"), JOptionPane.INFORMATION_MESSAGE);
                            btnGuardar.setEnabled(false);
                            txtIdentificacion.setText("");
                        }

                    }
                    posiciones = null;
                }
            } catch (URISyntaxException ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException x) {
            System.out.println("No se pudo encontrar el archivo");
        }
    }

    /**
     * Este metodo lee el documento y lo separa en un String de vectores (Array)
     * y se obtiene la posiciones en que estan guardados los datos en el archivo
     * plano para despues pasarselos a un array de Objetos que seran pasados al
     * modelo de la tabla para que esta los acomode en u respectiva columna
     */
    public void cargarTabla() {
        try {
            modeloTabla = (DefaultTableModel) jTRegistro.getModel();
            Scanner scan = new Scanner(new File(getClass().getResource("/archivo/registro.txt").toURI()));
            while (scan.hasNext()) {
                fila = scan.nextLine();
                fila = fila.replace(", ", ","); //Quitamos los espacios en blanco despues de la coma 
                posiciones = fila.split(";");
                tipoDoc = posiciones[0];
                documento = posiciones[1];
                nombre = posiciones[2];
                apellido = posiciones[3];
                fechaNaci = posiciones[4];
                edad1 = posiciones[5];
                genero = posiciones[6];
                ciudadRe = posiciones[7];
                ePS = posiciones[8];
                Object[] tabla = {contador++, tipoDoc, documento, nombre, apellido,
                    fechaNaci, edad1, genero, ciudadRe, ePS};
                modeloTabla.addRow(tabla);
                posiciones = null;
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException x) {
            System.out.println("No se pudo encontrar el archivo");
        }
    }

    /**
     * Este metodo lo que hace es leer el archivo y obtener la posicion en donde
     * se encuentra el numero de documento (en este caso es el que se va a
     * comparar) y los compara si son iguales lanza un mensaje diciendole al
     * usuario que el "usuario" ya se encuentra registrado
     */
    public void buscarRegistrados() {
        try {
            Scanner scan = new Scanner(new File(getClass().getResource("/archivo/registro.txt").toURI()));
            while (scan.hasNext()) {
                fila = scan.nextLine();
                fila = fila.replace(", ", ","); //Quitamos los espacios en blanco despues de la coma 
                posiciones = fila.split(";");
                documento = posiciones[1];
                nombre = posiciones[2];
                apellido = posiciones[3];
                if (txtBuscar.getText().equals(documento)) {
                    JOptionPane.showMessageDialog(this, ResourceBundle.getBundle(idioma).getString("usuarioRegistrado").concat(nombre).concat(" ")
                            .concat(apellido), "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    txtBuscar.setText("");
                }
                posiciones = null;

            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException x) {
            System.out.println("No se pudo encontrar el archivo");
        }

    }

    private JRCsvDataSource getDataSource() throws URISyntaxException, JRException {

        String[] nombreColumnas = new String[]{"Tipo Identificacion", "Identificacion", "Nombre", "Apellido", "Fecha Nacimiento", "Edad", "Genero", "Ciudad Residencia", "EPS"};
        File f1 = null;
        f1 = new File(getClass().getResource("/archivo/registro.txt").toURI());
        String filePath = f1.getAbsolutePath().toString();
        dataSource = new JRCsvDataSource(filePath);
        dataSource.setFieldDelimiter(';');
        dataSource.setColumnNames(nombreColumnas);
        return dataSource;
    }

    public void reporte() {
        try {
            File f = null;
            f = new File(getClass().getResource("/archivo/registrados.jasper").toURI());
            String rutaAbsoluta = f.getAbsolutePath().toString();
            JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(rutaAbsoluta);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, getDataSource());
            JasperViewer ver = new JasperViewer(jasperPrint);
            ver.setTitle("Registrados");
            ver.setVisible(true);
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

    private String configLenguage() {
        ResourceBundle config;
        String propiedades = "Español_es";
        config = ResourceBundle.getBundle("Configuracion");
        if ("es".equals(config.getString("lenguage"))) {
            propiedades = "Espannol_es";
        } else if ("en".equals(config.getString("lenguage"))) {
            propiedades = "Ingles_en";
        }
        return propiedades;
    }

    private void obtenerLenguage() {
        try{
        btnGuardar.setText(ResourceBundle.getBundle(idioma).getString("btnGuardar"));
        btnInforme.setText(ResourceBundle.getBundle(idioma).getString("btnInforme"));
        lbTipoIdentificacion.setText(ResourceBundle.getBundle(idioma).getString("lbTipoIdentificacion"));
        lbIdentificacion.setText(ResourceBundle.getBundle(idioma).getString("lbIdentificacion"));
        lbNombre.setText(ResourceBundle.getBundle(idioma).getString("lbNombre"));
        lbApellido.setText(ResourceBundle.getBundle(idioma).getString("lbApellido"));
        lbFechaNacimiento.setText(ResourceBundle.getBundle(idioma).getString("lbFechaNacimiento"));
        lbSexo.setText(ResourceBundle.getBundle(idioma).getString("lbSexo"));
        lbCiudadResidencia.setText(ResourceBundle.getBundle(idioma).getString("lbCiudadResidencia"));
        lbBuscar.setText(ResourceBundle.getBundle(idioma).getString("lbBuscar"));
        rbFemenino.setText(ResourceBundle.getBundle(idioma).getString("rbFemenino"));
        rbMasculino.setText(ResourceBundle.getBundle(idioma).getString("rbMasculino"));
        } catch (ExceptionInInitializerError e) {
            System.out.println("error no se pudo encontrar el archivo " + e);
        }
        catch(Exception e){
            System.out.println("error general " + e );
        }
    }
}
