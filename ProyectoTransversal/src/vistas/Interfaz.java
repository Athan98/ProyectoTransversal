/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/fondoEscritorio.jpg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);}
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmFormularioAlum = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmFormMateria = new javax.swing.JMenuItem();
        jmAdm = new javax.swing.JMenu();
        jmInscripciones = new javax.swing.JMenuItem();
        jmNotas = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmAlumnosXMat = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administracion");

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");

        jmFormularioAlum.setText("Formulario Alumno");
        jmFormularioAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormularioAlumActionPerformed(evt);
            }
        });
        jmAlumno.add(jmFormularioAlum);

        jMenuBar1.add(jmAlumno);

        jmMateria.setText("Materia");

        jmFormMateria.setText("Formulario Materia");
        jmMateria.add(jmFormMateria);

        jMenuBar1.add(jmMateria);

        jmAdm.setText("Administracion");

        jmInscripciones.setText("Manejo de Inscripciones");
        jmInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscripcionesActionPerformed(evt);
            }
        });
        jmAdm.add(jmInscripciones);

        jmNotas.setText("Manipulacion de Notas");
        jmAdm.add(jmNotas);

        jMenuBar1.add(jmAdm);

        jmConsultas.setText("Consultas");

        jmAlumnosXMat.setText("Alumnos por Materia");
        jmConsultas.add(jmAlumnosXMat);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmFormularioAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormularioAlumActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        GestionAlumnos gt = new GestionAlumnos();
        gt.setVisible(true);
        escritorio.add(gt);
        escritorio.moveToFront(gt);
        
        
         
    }//GEN-LAST:event_jmFormularioAlumActionPerformed

    private void jmInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscripcionesActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        GestionInscripcion gi = new GestionInscripcion();
        gi.setVisible(true);
        escritorio.add(gi);
        escritorio.moveToFront(gi);
    }//GEN-LAST:event_jmInscripcionesActionPerformed

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
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmAdm;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenuItem jmAlumnosXMat;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenuItem jmFormMateria;
    private javax.swing.JMenuItem jmFormularioAlum;
    private javax.swing.JMenuItem jmInscripciones;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenuItem jmNotas;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}
