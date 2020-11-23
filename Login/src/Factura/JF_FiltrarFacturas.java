/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factura;

import Conexion.datosP;
import Menu.JF_Menu;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Klope
 */
public class JF_FiltrarFacturas extends javax.swing.JFrame {
  String date;
    String date2;
    public JF_FiltrarFacturas() {
        initComponents();
    }
    
     public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        date = dateFormat.format(txtFecha.getDate());

    }

    public void processCalendar2() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date2 = dateFormat.format(txtFecha2.getDate());

    }
 public void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cédula");
        modelo.addColumn("Correo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("Total");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {

//CONSULTA CON SOLO 1 INNER JOIN
//   sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
//                    + " FROM factura a  INNER Join registro_cliente c on (c.Id_Cliente = a.Fk_Usuario)";

//CONSULTA QUE FUNCIONA CON INNERJOIN
   sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cantidad,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)";
      
   
  
   
       
        
        }

        String[] datos = new String[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarFiltroporfecha(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cédula");
        modelo.addColumn("Correo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("Total");

        tbDatos.setModel(modelo);
        processCalendar();
        String sql = "";

        if (valor.equals("")) {
//            //Cambié Nombre_cliente y Cedula_cliente
//            sql = "SELECT Nombre,Cédula,FK_Producto,Cantidad,TotalPagar,Fecha "
//                    + "FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"
//                    + " AND Fecha='" + date + "'";

           sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a  INNER Join registro_cliente c on (c.Id_Cliente = a.Fk_Usuario)" + " AND Fecha='" + date + "'";
                    
                    
                 

        }

        String[] datos = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarFiltro2Fechas(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cédula");
        modelo.addColumn("Correo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("Total");

        tbDatos.setModel(modelo);
        processCalendar();
        processCalendar2();
        String sql = "";

        if (valor.equals("")) {
            //Cambié Nombre_cliente y Cedula_cliente
//            sql = "SELECT Nombre,Cédula,FK_Producto,Cantidad,TotalPagar,Fecha "
//                    + "FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"
//                    + " AND Fecha between'" + date + "' and '" + date2 + "'  ";

            sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a  INNER Join registro_cliente c on (c.Id_Cliente = a.Fk_Usuario)"  + " AND Fecha between'" + date + "' and '" + date2 + "'  ";

        }

        String[] datos = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }

    void mostrarDatosPorCedula(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Cédula");
        modelo.addColumn("Correo");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("Total");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {

            //Cambié Nombre_cliente y Cedula_cliente
            sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a  INNER Join registro_cliente c on (c.Id_Cliente = a.Fk_Usuario)" + " AND Cédula='" + txtCedula.getText() + "'";

        }

        String[] datos = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtUsuarioVentas2 = new javax.swing.JTextField();
        Btnmenu = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnFiltrarCedula = new javax.swing.JButton();
        txtCedula = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnFiltrarRango = new javax.swing.JButton();
        txtFecha2 = new com.toedter.calendar.JDateChooser();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        txtUsuarioVentas2.setEditable(false);
        txtUsuarioVentas2.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuarioVentas2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtUsuarioVentas2.setText("      ");
        txtUsuarioVentas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioVentas2ActionPerformed(evt);
            }
        });

        Btnmenu.setBackground(new java.awt.Color(153, 153, 153));
        Btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnmenuMouseClicked(evt);
            }
        });
        Btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(67, 81, 141));
        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Menu");
        Btnmenu.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addComponent(txtUsuarioVentas2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(Btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(txtUsuarioVentas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(551, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(361, 361, 361)
                    .addComponent(Btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(362, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 753));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Historial de ventas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(456, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(404, 404, 404))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 0, 1070, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnFiltrarCedula.setText("Buscar");
        btnFiltrarCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarCedulaActionPerformed(evt);
            }
        });

        txtCedula.setForeground(new java.awt.Color(204, 204, 204));
        txtCedula.setText("Cedula");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnFiltrarRango.setText("Filtrar por rango");
        btnFiltrarRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarRangoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnFiltrarCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrarRango))
                .addGap(74, 74, 74))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrarCedula)
                    .addComponent(btnFiltrar)
                    .addComponent(btnFiltrarRango))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 810, -1));

        tbDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 810, 190));

        jButton2.setText("Ver todas");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarCedulaActionPerformed
      
           mostrarDatosPorCedula("");

        txtCedula.setText("");
        
        
    }//GEN-LAST:event_btnFiltrarCedulaActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
       
          try {

            txtFecha2.setEnabled(false);
            txtFecha2.setDate(null);
            mostrarFiltroporfecha("");

        } catch (Exception i) {

        }
                
        
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnFiltrarRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarRangoActionPerformed
        {
            try {

                txtFecha2.setEnabled(true);
                mostrarFiltro2Fechas("");
            } catch (Exception i) {

            }

        }
        
        
    }//GEN-LAST:event_btnFiltrarRangoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    mostrardatos("");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtUsuarioVentas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentas2ActionPerformed

    private void BtnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnmenuMouseClicked
        JF_Menu men=new JF_Menu();
        men.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnmenuMouseClicked

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
            java.util.logging.Logger.getLogger(JF_FiltrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_FiltrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_FiltrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_FiltrarFacturas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_FiltrarFacturas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btnmenu;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFiltrarCedula;
    private javax.swing.JButton btnFiltrarRango;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTextField txtCedula;
    private com.toedter.calendar.JDateChooser txtFecha;
    private com.toedter.calendar.JDateChooser txtFecha2;
    public javax.swing.JTextField txtUsuarioVentas2;
    // End of variables declaration//GEN-END:variables
 datosP cc = new datosP();
    Connection cn = cc.conexion();

}
