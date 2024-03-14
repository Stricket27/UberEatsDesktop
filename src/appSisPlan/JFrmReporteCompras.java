/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appSisPlan;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sisPlanDAL.OrdenCompraDAL;
import sisPlanDAL.RestauranteDAL;
import sisPlanDAL.UsuarioDAL;
import sisPlanEntidades.LineaDetalle;
import sisPlanEntidades.OrdenCompra;
import sisPlanEntidades.Perfil;
import sisPlanEntidades.Restaurante;
import sisPlanEntidades.Usuario;

/**
 *
 * @author moise
 */
public class JFrmReporteCompras extends javax.swing.JFrame {

    DefaultTableModel modeloOrden;

    /**
     * Creates new form jFrmReporteCompras
     */
    public JFrmReporteCompras() {
        initComponents();
        modeloOrden = (DefaultTableModel) this.jTable1.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana de Reportes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 740, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ORDEN", "CLIENTE", "RESTAURANTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 550, 230));

        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 420, 310));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sisPlanImagenes/Logo de Uber Eats.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //ACCION PARA DARLE CLICK A LA TABLA Y VER LAS COMPRAS QUE HCIERON ALGUNOS CLIENTE
        try {
            ArrayList<OrdenCompra> listaOrdenes = OrdenCompraDAL.todasFacturas();
            OrdenCompra ordenDetalle = null;
            int NoOrden = (int) this.modeloOrden.getValueAt(this.jTable1.getSelectedRow(), 0);
            for (OrdenCompra ordenes : listaOrdenes) {
                if (ordenes.getNumeroOrdenes() == NoOrden) {
                    ordenDetalle = ordenes;
                    StringBuilder detalle = new StringBuilder();
                    detalle.append("Restaurante: ").append(ordenDetalle.getRestaurante().getNombre()).append("\n");
                    for (LineaDetalle linea : ordenDetalle.getArraLineaDetalle()) {
                        detalle.append(linea.toString()).append("\n\n\n");
                    }
                    jTextArea1.setText(detalle.toString());
                    break;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    public void llenarTabla() {
        try {
            ArrayList<Usuario> listaU = UsuarioDAL.ObtenerTodosUsuarios();
            ArrayList<Restaurante> listaR = RestauranteDAL.todosRestaurantes();
            for (Usuario cliente : listaU) {
                if (cliente.getPerfil() == Perfil.CLIENTE_REGULAR) {
                    ArrayList<OrdenCompra> listaO = OrdenCompraDAL.listaFacturas(cliente.getCodigo());
                    Object[] fila = new Object[5];
                    Iterator<OrdenCompra> item = listaO.iterator();
                    while (item.hasNext()) {
                        OrdenCompra compra = item.next();
                        fila[0] = compra.getNumeroOrdenes();
                        fila[1] = cliente.getNombre();
                        fila[2] = compra.getRestaurante().getNombre();

                        modeloOrden.addRow(fila);
                    }
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

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
            java.util.logging.Logger.getLogger(JFrmReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrmReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrmReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrmReporteCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrmReporteCompras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
