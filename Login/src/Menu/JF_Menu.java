/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Cliente.JF_AgregarCliente;
import Factura.JF_FiltrarFacturas;
import Inventario.JF_Inventario;
import Proforma.JF_Proforma;
import Usuario.JF_AgregarUsuario;
import Login.JF_Login;


/**
 *
 * @author justi
 */
public class JF_Menu extends javax.swing.JFrame {

    /**
     * Creates new form JF_Menu
     */
    public JF_Menu() {
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

        jPanel1 = new javax.swing.JPanel();
        txtUsuarioIniciado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnRUsuario = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        btnRCliente = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnInventario = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnVentas = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnProformas = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnReporteProductos = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnFiltroFacturas = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuarioIniciado.setEditable(false);
        txtUsuarioIniciado.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuarioIniciado.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtUsuarioIniciado.setText("      ");
        txtUsuarioIniciado.setBorder(null);
        txtUsuarioIniciado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioIniciadoActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuarioIniciado, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 298, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 890));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel10.setText("AUTO REPUESTOS K&J");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(899, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(433, 433, 433))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1610, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel12.setText("Registrar");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 110, 30));

        btnRUsuario.setBackground(new java.awt.Color(255, 255, 255));
        btnRUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRUsuarioMouseClicked(evt);
            }
        });
        btnRUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel22.setText("Usuario");
        btnRUsuario.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/group.png"))); // NOI18N
        btnRUsuario.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 140));

        btnRCliente.setBackground(new java.awt.Color(255, 255, 255));
        btnRCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRClienteMouseClicked(evt);
            }
        });
        btnRCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel24.setText("Cliente");
        btnRCliente.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 80, 30));
        btnRCliente.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar-usuario.png"))); // NOI18N
        jLabel1.setText(".");
        btnRCliente.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 140));

        btnInventario.setBackground(new java.awt.Color(255, 255, 255));
        btnInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInventarioMouseClicked(evt);
            }
        });
        btnInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel19.setText("Inventario ");
        btnInventario.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, 30));
        btnInventario.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 120, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventario.png"))); // NOI18N
        btnInventario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 170));

        btnVentas.setBackground(new java.awt.Color(255, 255, 255));
        btnVentas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVentasMouseClicked(evt);
            }
        });
        btnVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel15.setText("Ventas");
        btnVentas.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 80, 30));
        btnVentas.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 120, 90));
        btnVentas.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ventas.png"))); // NOI18N
        btnVentas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 140));

        btnProformas.setBackground(new java.awt.Color(255, 255, 255));
        btnProformas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProformas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProformasMouseClicked(evt);
            }
        });
        btnProformas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel13.setText("Proformas");
        btnProformas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 30));
        btnProformas.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 120, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura (1).png"))); // NOI18N
        jLabel7.setText("jLabel7");
        btnProformas.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, -1));

        btnReporteProductos.setBackground(new java.awt.Color(255, 255, 255));
        btnReporteProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReporteProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReporteProductosMouseClicked(evt);
            }
        });
        btnReporteProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel11.setText("Reporte de productos");
        btnReporteProductos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        btnReporteProductos.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        btnFiltroFacturas.setBackground(new java.awt.Color(255, 255, 255));
        btnFiltroFacturas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnFiltroFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltroFacturasMouseClicked(evt);
            }
        });
        btnFiltroFacturas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Calibri Light", 1, 20)); // NOI18N
        jLabel17.setText("Reporte de facturas");
        btnFiltroFacturas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 30));
        btnFiltroFacturas.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 70, 90));
        btnFiltroFacturas.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte-de-negocios.png"))); // NOI18N
        btnFiltroFacturas.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -2, 160, 150));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95)
                .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(btnProformas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnReporteProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(294, 294, 294))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnProformas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(btnFiltroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnReporteProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 1360, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRUsuarioMouseClicked
        JF_AgregarUsuario m = new JF_AgregarUsuario();
        m.setVisible(true);
        dispose();
        m.txtUsuarioVenta.setText(txtUsuarioIniciado.getText());
    }//GEN-LAST:event_btnRUsuarioMouseClicked

    private void btnRClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRClienteMouseClicked
        JF_AgregarCliente m = new JF_AgregarCliente();
        m.setVisible(true);
        dispose();
        m.txtUsuarioVentas2.setText(txtUsuarioIniciado.getText());
    }//GEN-LAST:event_btnRClienteMouseClicked

    private void btnInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseClicked
        JF_Inventario m = new JF_Inventario();
        m.setVisible(true);
        dispose();
        m.txtUsuarioVentas3.setText(txtUsuarioIniciado.getText());
    }//GEN-LAST:event_btnInventarioMouseClicked

    private void btnVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseClicked
        //      //  JF_Ventas m = new JF_Ventas();
        //        m.setVisible(true);
        //        dispose();
        //
        //        m.txtUsuarioVentas.setText(txtUsuarioIniciado.getText());
        //
        //        m.mostrardatosProducto("");

    }//GEN-LAST:event_btnVentasMouseClicked

    private void btnProformasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProformasMouseClicked
        JF_Proforma m = new JF_Proforma();
        m.setVisible(true);
        dispose();
        m.txtUsuarioVentas3.setText(txtUsuarioIniciado.getText());
    }//GEN-LAST:event_btnProformasMouseClicked

    private void btnReporteProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteProductosMouseClicked

        //       JF_ReporteProducto m = new JF_ReporteProducto();
        //        m.setVisible(true);
        //        dispose();
        //        m.txtUsuarioVentas.setText(txtUsuarioIniciado.getText());
        //
        //        m.mostrarProductos("");
        //        m.mostrarProductosMonto("");
    }//GEN-LAST:event_btnReporteProductosMouseClicked

    private void btnFiltroFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltroFacturasMouseClicked

        JF_FiltrarFacturas m = new JF_FiltrarFacturas();
        m.setVisible(true);
        dispose();
        m.txtUsuarioVentas2.setText(txtUsuarioIniciado.getText());

        m.mostrardatos("");
    }//GEN-LAST:event_btnFiltroFacturasMouseClicked

    private void txtUsuarioIniciadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioIniciadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioIniciadoActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnFiltroFacturas;
    private javax.swing.JPanel btnInventario;
    private javax.swing.JPanel btnProformas;
    private javax.swing.JPanel btnRCliente;
    private javax.swing.JPanel btnRUsuario;
    private javax.swing.JPanel btnReporteProductos;
    private javax.swing.JPanel btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField txtUsuarioIniciado;
    // End of variables declaration//GEN-END:variables
}
