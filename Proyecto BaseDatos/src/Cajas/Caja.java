/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cajas;

import java.util.Calendar;
import Nucleo.PostgreSQL;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo D'isidoro
 */
public class Caja extends javax.swing.JFrame {
    int tipoA=0;
    Calendar fecha = Calendar.getInstance();
    int mes = fecha.get(Calendar.MONTH);
    PostgreSQL conector = new PostgreSQL();
    String sqlCliente = "SELECT \"Usuario\".documento,\"Turno\".codigo FROM \"Usuario\",\"Turno\" WHERE \"Turno\".estado=0 AND \"Usuario\".codigo = \"Turno\".codigo_usuario AND \"Turno\".codigo_atencion = "+tipoA+"ORDER BY \"Turno\".codigo;";
    ResultSet resultadoCliente = conector.consultar(sqlCliente);

    /**
     * Creates new form Caja
     *
     * @param tipoC
     */
    public Caja() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        crearModelo();
        obtenerCliente();
    }

    public void actualizarConsulta() {
        resultadoCliente = conector.consultar(sqlCliente);
    }

    public void obtenerCliente() {
        try {
            if (resultadoCliente.next()) {
                documentoCl.setText(resultadoCliente.getString("documento"));
                numeroTurn.setText(resultadoCliente.getString("codigo"));
                if (resultadoCliente.isLast()) {
                    actualizarConsulta();
                    JOptionPane.showMessageDialog(null, "Se actualizará el registro de turnos, puesto que se han atendido todos desde la última consulta", "Actualizando...", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void crearModelo() {
        String sql = "SELECT descripcion FROM \"Tipo\";";
        ResultSet resultado = conector.consultar(sql);
        try {
            while (resultado.next()) {
                tipoAten.addItem(resultado.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fechaTurn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        documentoCl = new javax.swing.JTextField();
        numeroTurn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tipoAten = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atencion al Usuario");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Caja");

        jLabel2.setText("Tipo de Atención:");

        jLabel3.setText("Fecha de Atención:");

        fechaTurn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fechaTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mes++;
        fechaTurn.setText(Integer.toString(fecha.get(Calendar.DATE))+"/"+mes+"/"+Integer.toString(fecha.get(Calendar.YEAR)));

        jLabel5.setText("Documento Cliente:");

        documentoCl.setEditable(false);

        numeroTurn.setEditable(false);

        jLabel6.setText("Numero de Turno:");

        jButton1.setText("Atender");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tipoAten.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Por favor seleccione..." }));
        tipoAten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAtenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(numeroTurn, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaTurn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(documentoCl, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tipoAten, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipoAten, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(documentoCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numeroTurn)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = "UPDATE \"Turno\" SET estado=1 WHERE codigo='" +Integer.parseInt(numeroTurn.getText())+"';";
        conector.actualizar(sql);
        obtenerCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tipoAtenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAtenActionPerformed
        tipoA = tipoAten.getSelectedIndex();
        sqlCliente = "SELECT \"Usuario\".documento,\"Turno\".codigo"
                + " FROM \"Usuario\",\"Turno\" "
                + "WHERE \"Turno\".estado=0 AND \"Usuario\".codigo = \"Turno\".codigo_usuario AND \"Turno\".codigo_atencion = "+tipoA+""
                + "ORDER BY \"Turno\".codigo;";
        actualizarConsulta();
        obtenerCliente();
    }//GEN-LAST:event_tipoAtenActionPerformed

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
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField documentoCl;
    private javax.swing.JLabel fechaTurn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField numeroTurn;
    private javax.swing.JComboBox<String> tipoAten;
    // End of variables declaration//GEN-END:variables
}
