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

/**
 *
 * @author justi
 */
public class JF_ImprimirFactura extends javax.swing.JFrame {

    Conexion.Conexion2 con = new Conexion.Conexion2();
    public JF_ImprimirFactura() {
        initComponents();
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
        txtUsuarioVentas3 = new javax.swing.JTextField();
        btnMenu = new javax.swing.JButton();
        btnFacturación = new javax.swing.JButton();
        btnProformas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
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

        txtUsuarioVentas3.setEditable(false);
        txtUsuarioVentas3.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuarioVentas3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtUsuarioVentas3.setText("      ");
        txtUsuarioVentas3.setBorder(null);
        txtUsuarioVentas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioVentas3ActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsuarioVentas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 200, 40));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        btnMenu.setText("jButton1");
        jPanel2.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 170, 90));

        btnFacturación.setBackground(new java.awt.Color(0, 0, 0));
        btnFacturación.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturación.setText("FACTURACIÓN");
        jPanel2.add(btnFacturación, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 315, 150, 40));

        btnProformas.setBackground(new java.awt.Color(0, 0, 0));
        btnProformas.setForeground(new java.awt.Color(255, 255, 255));
        btnProformas.setText("PROFORMAS");
        jPanel2.add(btnProformas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 150, 40));

        btnSalir.setBackground(new java.awt.Color(0, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 510, 150, 40));

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
        jLabel12.setText("Correo Electronico:autorepuestosk&j@repuestosk&j.com");
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

    private void txtUsuarioVentas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentas3ActionPerformed

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
    public javax.swing.JTextField txtUsuarioVentas3;
    // End of variables declaration//GEN-END:variables
   datosP cc = new datosP();
    Connection cn = cc.conexion();

}
