/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appSisPlan;

import sisPlanDAL.UsuarioDAL;
import javax.swing.JOptionPane;
import sisPlanEntidades.Perfil;
import sisPlanEntidades.Usuario;

/**
 *
 * @author moise
 */
public class JFrmVentanaPrincipal extends javax.swing.JFrame {

    Usuario oUsuario = null;

    /**
     * Creates new form JFramVentanaPrincipal
     */
    public JFrmVentanaPrincipal() {
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

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jBtnSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jBtnRegistrarse = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtCorreoElectronico = new javax.swing.JTextField();
        jPswContraseña = new javax.swing.JPasswordField();
        jBtnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vetana de Bienvenida");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Admin_Usuarios.jpg"))); // NOI18N
        jButton2.setText("Iniciar Sección");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setEnabled(false);

        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/AnteriorPagina.png"))); // NOI18N
        jBtnSalir.setText("Salir");
        jBtnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jLabel3.setText("Eres nuevo usuario o no tienes cuenta? Registrarse aqui");

        jBtnRegistrarse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Modificar.png"))); // NOI18N
        jBtnRegistrarse.setText("Registrarse");
        jBtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarseActionPerformed(evt);
            }
        });

        jLabel1.setText("Correo Electronico / Usuario");

        jLabel2.setText("Contraseña");

        jTxtCorreoElectronico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCorreoElectronicoFocusGained(evt);
            }
        });

        jPswContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPswContraseñaFocusGained(evt);
            }
        });

        jBtnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Buscar.jpg"))); // NOI18N
        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(jBtnRegistrarse))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTxtCorreoElectronico)
                                    .addComponent(jPswContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jBtnAceptar)
                                .addGap(77, 77, 77)
                                .addComponent(jBtnSalir)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPswContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBtnAceptar)
                    .addComponent(jBtnSalir))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRegistrarse)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Bienvenidos a.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Logo de Uber Eats.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Por favor.png"))); // NOI18N
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addComponent(jButton2))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        //VALIDAR EL INICIO DE SESION DEPENDIENDO DEL USUARIO
        int intentos = 3;

        try {
            oUsuario = UsuarioDAL.buscarUsuario(this.jTxtCorreoElectronico.getText(), this.jPswContraseña.getText());
            if (oUsuario != null) {
                if (oUsuario.getPerfil() == Perfil.GERENTE) {
                    JFrmMantenimientoProductoRestaurante jfmpr = new JFrmMantenimientoProductoRestaurante();
                    sisPlanUtilitarios.UtilitarioVentana.centrarVentanaJFrame(jfmpr, false);
//                    jfmpr.setVisible(true);
                    jfmpr.setUsuarioActivo(oUsuario);
//                    jfmpr.setLocationRelativeTo(this);
                } else {
                    if (oUsuario.getPerfil() == Perfil.CLIENTE_REGULAR) {
                        JFrmMenuCliente menu = new JFrmMenuCliente();
                        sisPlanUtilitarios.UtilitarioVentana.centrarVentanaJFrame(menu, false);
//                        menu.setVisible(true);
                        menu.setUsuarioActivo(oUsuario);
//                        menu.setLocationRelativeTo(null);
                    } else {
                        JFrmVentanaAdministrador admin = new JFrmVentanaAdministrador();
                        sisPlanUtilitarios.UtilitarioVentana.centrarVentanaJFrame(admin, false);
//                        admin.setLocationRelativeTo(null);
//                        admin.setVisible(true);
                        admin.setoUsuario(oUsuario);
                    }
                }
            } else {
                if (intentos == 0) {
                    JOptionPane.showMessageDialog(this, "Muchos intentos de ingreso, por favor ingrese más tarde");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Correo electronico y contraseña incorrectos, intente de nuevo");
                    intentos--;
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jBtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarseActionPerformed
        // TODO add your handling code here:

        //VENTANA PARA REGISTRASE
        JFrmCrearCuenta crearCuenta = new JFrmCrearCuenta();

        crearCuenta.setVisible(true);

        crearCuenta.setLocationRelativeTo(this);

    }//GEN-LAST:event_jBtnRegistrarseActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        this.jPanel1.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTxtCorreoElectronicoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCorreoElectronicoFocusGained
        this.jTxtCorreoElectronico.selectAll();
    }//GEN-LAST:event_jTxtCorreoElectronicoFocusGained

    private void jPswContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPswContraseñaFocusGained
        this.jPswContraseña.selectAll();
    }//GEN-LAST:event_jPswContraseñaFocusGained

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        this.jPanel1.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmVentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmVentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnRegistrarse;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPswContraseña;
    private javax.swing.JTextField jTxtCorreoElectronico;
    // End of variables declaration//GEN-END:variables
}