/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factura;

import Conexion.datosP;
import Menu.JF_Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Prueba.VentasPrueba;
import Proforma.JF_Proforma;
/**
 *
 * @author justi
 */
public class JF_ImprimirFactura extends javax.swing.JFrame {

    Conexion.Conexion2 con = new Conexion.Conexion2();
    public JF_ImprimirFactura() {
        initComponents();
        setLocationRelativeTo(null);
    }
  public void mostrar1() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        DefaultTableModel modelo = new DefaultTableModel();
        tbCliente1.setModel(modelo);

        
        try {
            ps = con.conectar().prepareStatement("SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Id_Cliente,CorreoElectronico"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente) where Id_Factura= '" + txtCodigoFac1.getText() + "'");
            rs = ps.executeQuery();

            ResultSetMetaData rsmt = rs.getMetaData();
            int cantcolum = rsmt.getColumnCount();

            modelo.addColumn("ID Factura");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Cédula");
            modelo.addColumn("Correo");

            while (rs.next()) {
                Object[] filas = new Object[cantcolum];

                for (int i = 0; i < cantcolum; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar... " + e);
        }

    }

    public void mostrar2() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        DefaultTableModel modelo2 = new DefaultTableModel();
        tbCompra1.setModel(modelo2);

        try {
//            ps = con.conectar().prepareStatement("SELECT id_Factura,Cantidad,Impuesto,Descuento,TotalPagar,Fecha "
//                    + "FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)order by Id_Factura desc limit 1");

            ps = con.conectar().prepareStatement("SELECT DISTINCTROW Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente) "
                    + "where Id_Factura = '" + txtCodigoFac1.getText() + "'");
            rs = ps.executeQuery();

            ResultSetMetaData rsmt = rs.getMetaData();
            int cantcolum = rsmt.getColumnCount();

            modelo2.addColumn("Fecha");
          
            modelo2.addColumn("Subtotal");
            modelo2.addColumn("Impuesto");
            modelo2.addColumn("Descuento");
            modelo2.addColumn("Total");

            while (rs.next()) {
                Object[] filas = new Object[cantcolum];

                for (int i = 0; i < cantcolum; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo2.addRow(filas);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar... " + e);
        }

    }

    public void mostrar3() {

        PreparedStatement ps = null;
        ResultSet rs = null;

        DefaultTableModel modelo3 = new DefaultTableModel();
        tbProducto.setModel(modelo3);

        try {
//            ps = con.conectar().prepareStatement("SELECT id_Factura,Cantidad,Impuesto,Descuento,TotalPagar,Fecha "
//                    + "FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)order by Id_Factura desc limit 1");

            ps = con.conectar().prepareStatement("SELECT Id_Orden, b.Cantidad, d.Nombre"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"
                    + " INNER Join producto d on (b.Fk_Producto = d.Id_Producto) where Id_Factura ='" + txtCodigoFac1.getText() + "'");

            rs = ps.executeQuery();

            ResultSetMetaData rsmt = rs.getMetaData();
            int cantcolum = rsmt.getColumnCount();

            modelo3.addColumn("ID Orden");
            modelo3.addColumn("Cantidad");
            modelo3.addColumn("Producto");

            while (rs.next()) {
                Object[] filas = new Object[cantcolum];

                for (int i = 0; i < cantcolum; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo3.addRow(filas);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar... " + e);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        btnFacturación = new javax.swing.JButton();
        btnProformas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbCompra1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbCliente1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodigoFac1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        btnMenu.setText("jButton1");
        btnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuMouseClicked(evt);
            }
        });
        jPanel2.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 170, 90));

        btnFacturación.setBackground(new java.awt.Color(0, 0, 0));
        btnFacturación.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnFacturación.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturación.setText("FACTURACIÓN");
        btnFacturación.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaciónActionPerformed(evt);
            }
        });
        jPanel2.add(btnFacturación, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 150, 30));

        btnProformas.setBackground(new java.awt.Color(0, 0, 0));
        btnProformas.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnProformas.setForeground(new java.awt.Color(255, 255, 255));
        btnProformas.setText("PROFORMAS");
        btnProformas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProformasActionPerformed(evt);
            }
        });
        jPanel2.add(btnProformas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 409, 150, -1));

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 153, 153));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 150, 30));

        jPanel12.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jPanel14.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jPanel13.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 250, 890));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 1370, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCompra1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbCompra1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbCompra1);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 308, 860, 51));

        tbCliente1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbCliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(tbCliente1);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 860, 60));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("--------Ultima linea---------");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 197, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 180, 147));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Auto repuestos K&J");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Tel:2710-84-84");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 66, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Correo Electronico:autorepuestosk&j@gmail.com");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 114, -1, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Direccion: 50 mts sur de la universidad Latina de Costa Rica");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Código");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        txtCodigoFac1.setEditable(false);
        txtCodigoFac1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoFac1ActionPerformed(evt);
            }
        });
        jPanel7.add(txtCodigoFac1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 118, -1));

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 600, 150));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Cliente:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Compra:");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 286, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Producto:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        tbProducto.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tbProducto);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 399, 860, 110));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 960, 640));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("Factura");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoFac1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoFac1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoFac1ActionPerformed

    private void btnFacturaciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaciónActionPerformed
       VentasPrueba v= new VentasPrueba();
       v.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnFacturaciónActionPerformed

    private void btnProformasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProformasActionPerformed
       JF_Proforma p= new JF_Proforma();
       p.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnProformasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuMouseClicked
         JF_Menu me = new JF_Menu();
      me.setVisible(true);
      dispose();
    }//GEN-LAST:event_btnMenuMouseClicked

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
            java.util.logging.Logger.getLogger(JF_ImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_ImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_ImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_ImprimirFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_ImprimirFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFacturación;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnProformas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tbCliente1;
    private javax.swing.JTable tbCompra1;
    private javax.swing.JTable tbProducto;
    public javax.swing.JTextField txtCodigoFac1;
    // End of variables declaration//GEN-END:variables
   datosP cc = new datosP();
    Connection cn = cc.conexion();

}
