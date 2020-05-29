
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import java.util.Map;
import java.util.Set;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cinfe
 */
public class UserInterface extends javax.swing.JFrame {

    private String path;
    

    public UserInterface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField18 = new javax.swing.JTextField();
        chooseDyrectory = new java.awt.Button();
        selectedFileLabel = new java.awt.Label();
        methodSelect = new java.awt.Choice();
        label1 = new java.awt.Label();
        codigo = new javax.swing.JTextField();
        porcComent = new javax.swing.JTextField();
        blanco = new javax.swing.JTextField();
        comentarios = new javax.swing.JTextField();
        lineasTotales = new javax.swing.JTextField();
        fanin = new javax.swing.JTextField();
        ccResult = new javax.swing.JTextField();
        fanout = new javax.swing.JTextField();
        longitud = new javax.swing.JTextField();
        velocidad = new javax.swing.JTextField();
        esfuerzo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        evaluateButton = new java.awt.Button();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        recomendaciones = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TestingTool");
        setBackground(new java.awt.Color(203, 204, 207));
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(720, 450));
        setMinimumSize(new java.awt.Dimension(720, 450));
        setPreferredSize(new java.awt.Dimension(720, 450));
        getContentPane().setLayout(null);

        chooseDyrectory.setLabel("Explorar directorio");
        chooseDyrectory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chooseDyrectoryMouseClicked(evt);
            }
        });
        chooseDyrectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseDyrectoryActionPerformed(evt);
            }
        });
        getContentPane().add(chooseDyrectory);
        chooseDyrectory.setBounds(20, 20, 115, 24);

        selectedFileLabel.setBackground(new java.awt.Color(203, 204, 207));
        selectedFileLabel.setName(""); // NOI18N
        selectedFileLabel.setText("[Ruta de archivo seleccionado]");
        getContentPane().add(selectedFileLabel);
        selectedFileLabel.setBounds(160, 20, 505, 24);
        getContentPane().add(methodSelect);
        methodSelect.setBounds(210, 50, 197, 20);

        label1.setBackground(new java.awt.Color(203, 204, 207));
        label1.setText("Selecione el m\u00e9todo a evaluar:");
        getContentPane().add(label1);
        label1.setBounds(20, 50, 173, 20);

        codigo.setEditable(false);
        getContentPane().add(codigo);
        codigo.setBounds(160, 140, 70, 30);

        porcComent.setEditable(false);
        getContentPane().add(porcComent);
        porcComent.setBounds(370, 100, 70, 30);

        blanco.setEditable(false);
        getContentPane().add(blanco);
        blanco.setBounds(160, 220, 70, 30);

        comentarios.setEditable(false);
        getContentPane().add(comentarios);
        comentarios.setBounds(160, 180, 70, 30);

        lineasTotales.setEditable(false);
        getContentPane().add(lineasTotales);
        lineasTotales.setBounds(160, 100, 70, 30);

        fanin.setEditable(false);
        getContentPane().add(fanin);
        fanin.setBounds(370, 180, 70, 30);

        ccResult.setEditable(false);
        ccResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccResultActionPerformed(evt);
            }
        });
        getContentPane().add(ccResult);
        ccResult.setBounds(370, 140, 70, 30);

        fanout.setEditable(false);
        getContentPane().add(fanout);
        fanout.setBounds(370, 220, 70, 30);

        longitud.setEditable(false);
        getContentPane().add(longitud);
        longitud.setBounds(620, 100, 70, 30);

        velocidad.setEditable(false);
        getContentPane().add(velocidad);
        velocidad.setBounds(620, 140, 70, 30);

        esfuerzo.setEditable(false);
        getContentPane().add(esfuerzo);
        esfuerzo.setBounds(620, 180, 70, 30);

        jLabel2.setText("L\u00edneas comentadas:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 180, 120, 20);

        jLabel3.setText("L\u00edneas totales:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 100, 120, 20);

        jLabel4.setText("L\u00edneas de c\u00f3digo:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 140, 120, 20);

        jLabel5.setText("L\u00edneas en blanco:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 220, 120, 20);

        jLabel6.setText("% comentarios:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 100, 118, 20);

        jLabel7.setText("Comp. Clicom\u00e1tica:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(250, 140, 118, 20);

        jLabel8.setText("Fan in:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(250, 180, 118, 20);

        jLabel9.setText("Fan out:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(250, 220, 118, 20);

        jLabel10.setText("Halstead - Volumen: ");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(470, 140, 140, 20);

        jLabel11.setText("L\u00edneas - Esfuerzo:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(470, 180, 118, 20);

        jLabel13.setText("Halstead - Longitud: ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(470, 100, 118, 20);

        evaluateButton.setEnabled(false);
        evaluateButton.setLabel("Evaluar m\u00e9todo");
        evaluateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evaluateButtonMouseClicked(evt);
            }
        });
        getContentPane().add(evaluateButton);
        evaluateButton.setBounds(420, 50, 102, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondo.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(720, 270));
        jLabel1.setMinimumSize(new java.awt.Dimension(720, 270));
        jLabel1.setPreferredSize(new java.awt.Dimension(720, 270));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 710, 290);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 282, 690, 0);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);

        recomendaciones.setColumns(20);
        recomendaciones.setRows(5);
        jScrollPane1.setViewportView(recomendaciones);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 300, 680, 70);

        jLabel12.setText("Recomendaciones: ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(10, 280, 130, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseDyrectoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chooseDyrectoryMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result;
        result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            this.path = path;

            selectedFileLabel.setText(path);
            try {
                ArrayList<String> methodsNames = Gestor.getMethodsNames(path);
                for (String methodName : methodsNames) {
                    methodSelect.addItem(methodName);
                }
                evaluateButton.setEnabled(true);
            } catch (IOException ex) {
                Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_chooseDyrectoryMouseClicked

    @Override
    public Image getIconImage() {
        Image retValue;
        retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("icon.png"));

        return retValue;
    }


    private void chooseDyrectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseDyrectoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseDyrectoryActionPerformed

    private void evaluateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evaluateButtonMouseClicked
        try {
            //---CLEAN ALL --------
            ccResult.setText("");
            lineasTotales.setText("");
            comentarios.setText("");
            codigo.setText("");
            String comentariosText=("");
            
            Map results = Gestor.getResults(this.path, methodSelect.getSelectedItem());
            int cc = (int) results.get("cc");
            
            //RECOMENDACIONES
            //CC= Se Pinta el color de campo cc segun resultado y se da recomendaciones si es mayor que 10  
            if(cc <=10){
                ccResult.setBackground(Color.green);
            }else{	
            	if(cc>10 && cc<=20) {
            		ccResult.setBackground(Color.yellow);
            	}else{
                ccResult.setBackground(Color.red);
            	}
            	comentariosText+="Complejidad Ciclom\u00e1tica: Se recomienda modularizas el c\u00f3digo y as\u00ed lograr una mejor mantenibilidad del mismo."+"\n";
                recomendaciones.setText(comentariosText);
            }
            //PorcComentarios= Se recomienda mas comentarios si es menor a 30 el porcentaje
            String porcComenta =  results.get("porcComentarios").toString();
            Locale spanish = new Locale("es", "ES");
            NumberFormat nf= NumberFormat.getInstance(spanish);
            
            float porcComentario=0;
			try {
				porcComentario = nf.parse(porcComenta).floatValue();
			} catch (ParseException e) {
				e.printStackTrace();
			}
            if(porcComentario<=29) {
            	comentariosText+="Porcentaje de comentarios: Se recomienda agregar mas comentarios para que el codigo sea mas entendible \n";
            	recomendaciones.setText(comentariosText);
            }
            
            //Fan out= Se recomienda 
            /*int fanO = (int) results.get("fanout");
            if(fanO > 3) {
            	comentariosText+="Fan-Out alto \n";
        		recomendaciones.setText(comentariosText);
            }*/
          
            //Fan in= Se recomienda 
            int fanI = (int) results.get("fanin");
            if(fanI > 3) {	
        		comentariosText+="Fan-In alto: Se recomienda utilizar un metodo de cobertura exahustiva como el metodo de McCabe(Prueba del Camino Basico)\n"
        				+ "para comprobar que no haya errores ya que podrian afectar a muchos metodos\n";
    			recomendaciones.setText(comentariosText);
            }
            
            ccResult.setText(Integer.toString(cc));
            lineasTotales.setText(results.get("totalLines").toString());
            comentarios.setText(results.get("comentarios").toString());
            codigo.setText(results.get("codigo").toString());
            blanco.setText(results.get("blancos").toString());
            porcComent.setText(results.get("porcComentarios").toString());
            longitud.setText(results.get("longitud").toString());
            velocidad.setText(results.get("velocidad").toString());
            esfuerzo.setText(results.get("esfuerzo").toString());
            fanin.setText(results.get("fanin").toString());
            fanout.setText(results.get("fanout").toString());
           
            
        } catch (IOException ex) {
            Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_evaluateButtonMouseClicked

    private void ccResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccResultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ccResultActionPerformed

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
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blanco;
    private javax.swing.JTextField ccResult;
    private java.awt.Button chooseDyrectory;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField comentarios;
    private javax.swing.JTextField esfuerzo;
    private java.awt.Button evaluateButton;
    private javax.swing.JTextField fanin;
    private javax.swing.JTextField fanout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField18;
    private java.awt.Label label1;
    private javax.swing.JTextField lineasTotales;
    private javax.swing.JTextField longitud;
    private java.awt.Choice methodSelect;
    private javax.swing.JTextField porcComent;
    private javax.swing.JTextArea recomendaciones;
    private java.awt.Label selectedFileLabel;
    private javax.swing.JTextField velocidad;
    // End of variables declaration//GEN-END:variables

}
