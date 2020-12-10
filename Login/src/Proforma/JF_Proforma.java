/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proforma;
import Conexion.Conexion_k;
import Conexion.datosP;
import Factura.JF_ImprimirFactura;
import Inventario.JF_Inventario;
import Login.JF_Login;
import Menu.JF_Menu;
import MenuSimple.JF_MenuSimple;
import Prueba.VentasPrueba;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Klope
 */
public class JF_Proforma extends javax.swing.JFrame {

      int cont;
      
       void acceder(String usuario) {
        String cap = "";
        String sql = "SELECT * FROM registro_usuario WHERE Usuario='" + usuario + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("Fk_TipoUsuario");
            }
            if (cap.equals("1")) {
                JF_Menu m = new JF_Menu();
                m.setVisible(true);
                dispose();

                m.txtUsuarioIniciado.setText(txtUsuarioVentas3.getText());
            } else if (cap.equals("2")) {
                JF_MenuSimple m = new JF_MenuSimple();
                m.setVisible(true);
                dispose();

                m.txtUsuarioIniciado.setText(txtUsuarioVentas3.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void mostrardatos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Factura");
        modelo.addColumn("Nombre");
        modelo.addColumn("Primer A");
        modelo.addColumn("Cédula");
        modelo.addColumn("Subtotal");
        modelo.addColumn("Impuesto");
        modelo.addColumn("Descuento");
        modelo.addColumn("Total");
        modelo.addColumn("Fecha");
      

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {

            sql = "SELECT DISTINCTROW Id_Factura,Nombre,PrimerApellido, Id_Cliente, Subtotal, Impuesto, Descuento, TotalPagar,Fecha FROM factura a INNER JOIN orden b on (b.Fk_Factura = a.Id_Factura) "
                    + "INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente) where c.Id_Cliente ='" + txtBuscar.getText() + "' and Fk_Estado = 2";

        }
        String[] datos = new String[9];
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
            

                modelo.addRow(datos);
            }
            tbDatos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void mostrardatosProductos(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_Orden");
        modelo.addColumn("Nombre del producto");
        modelo.addColumn("Presentación");
        modelo.addColumn("Cantidad");

        tbProductos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {

            sql = "SELECT b.Id_Orden, d.Nombre, d.Presentacion, b.Cantidad FROM orden b INNER Join producto d on "
                    + "(d.Id_Producto = b.Fk_Producto) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente) "
                    + "where Fk_Factura ='" + txtOrdenP.getText() + "' and Fk_Estado = 2";

        }
        String[] datos = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            tbProductos.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pagar() {

    }

    public JF_Proforma() {
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
        jButton1 = new javax.swing.JButton();
        btnfacturacion = new javax.swing.JButton();
        btninventarios = new javax.swing.JButton();
        btnhistorial = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txtUsuarioVentas3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        txtOrdenP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        VerProducto = new javax.swing.JButton();
        lblRequeridoOrden = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        jButton1.setText("INICIO");
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 147, 170, 60));

        btnfacturacion.setBackground(new java.awt.Color(0, 0, 0));
        btnfacturacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnfacturacion.setText("FACTURACIÓN");
        btnfacturacion.setBorder(null);
        btnfacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnfacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 170, 39));

        btninventarios.setBackground(new java.awt.Color(0, 0, 0));
        btninventarios.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btninventarios.setText("INVENTARIOS");
        btninventarios.setBorder(null);
        btninventarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninventariosActionPerformed(evt);
            }
        });
        jPanel1.add(btninventarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 170, 34));

        btnhistorial.setBackground(new java.awt.Color(0, 0, 0));
        btnhistorial.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnhistorial.setText("HISTORIAL");
        btnhistorial.setBorder(null);
        btnhistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnhistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 170, 35));

        btnsalir.setBackground(new java.awt.Color(0, 0, 0));
        btnsalir.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 51, 51));
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 180, 34));

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
        jPanel1.add(txtUsuarioVentas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 63, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 890));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbDatos.setGridColor(new java.awt.Color(255, 255, 255));
        tbDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDatos);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 780, 370));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel14.setText("Registro de proformas");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, -1));

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tbProductos);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 230, 390, 370));

        txtOrdenP.setEditable(false);
        jPanel4.add(txtOrdenP, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 610, 170, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel17.setText("Identificador");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, -1, 30));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.setForeground(new java.awt.Color(255, 0, 0));

        btnPagar.setBackground(new java.awt.Color(255, 153, 153));
        btnPagar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setContentAreaFilled(false);
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 610, 130, -1));

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));

        VerProducto.setBackground(new java.awt.Color(255, 153, 153));
        VerProducto.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        VerProducto.setText("Ver productos");
        VerProducto.setContentAreaFilled(false);
        VerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(VerProducto)
                .addGap(14, 14, 14))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, -1, -1));

        lblRequeridoOrden.setForeground(new java.awt.Color(0, 102, 255));
        lblRequeridoOrden.setText("Requerido");
        jPanel4.add(lblRequeridoOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 650, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jLabel13.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel13.setText("Cédula vinculado a la proforma:");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic", 1, 13)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/motor-de-busqueda-web (1).png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel15.setText("Productos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel13)
                .addGap(38, 38, 38)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(jLabel15)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(26, 26, 26))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, 80));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 890));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int seleccionar = tbDatos.rowAtPoint(evt.getPoint());
        txtOrdenP.setText(String.valueOf(tbDatos.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
      mostrardatos("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed

        cont = 0;

        if (txtOrdenP.getText().equals("")) {
            lblRequeridoOrden.setVisible(true);
            cont++;
        } else {
            lblRequeridoOrden.setVisible(false);

        }
        if (cont == 0) {

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Estado = 1 where Fk_Factura=" + txtOrdenP.getText() + "");
                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }

            JF_ImprimirFactura m = new JF_ImprimirFactura();
            m.setVisible(true);
            dispose();

            m.txtCodigoFac1.setText(txtOrdenP.getText());

            m.mostrar1();
            m.mostrar2();
            m.mostrar3();

            m.txtUsuarioVentas3.setText(txtUsuarioVentas3.getText());
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void VerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerProductoActionPerformed

        cont = 0;

        if (txtOrdenP.getText().equals("")) {
            lblRequeridoOrden.setVisible(true);
            cont++;
        } else {
            lblRequeridoOrden.setVisible(false);

        }
        if (cont == 0) {

            mostrardatosProductos("");

        }
    }//GEN-LAST:event_VerProductoActionPerformed

    private void txtUsuarioVentas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentas3ActionPerformed

    private void btnfacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturacionActionPerformed
       VentasPrueba m = new VentasPrueba();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnfacturacionActionPerformed

    private void btninventariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninventariosActionPerformed
        JF_Inventario i= new JF_Inventario();
        i.setVisible(true);
        dispose();
                
    }//GEN-LAST:event_btninventariosActionPerformed

    private void btnhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhistorialActionPerformed
       
    }//GEN-LAST:event_btnhistorialActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Proforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Proforma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton VerProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnfacturacion;
    private javax.swing.JButton btnhistorial;
    private javax.swing.JButton btninventarios;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRequeridoOrden;
    private javax.swing.JTable tbDatos;
    private javax.swing.JTable tbProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtOrdenP;
    public javax.swing.JTextField txtUsuarioVentas3;
    // End of variables declaration//GEN-END:variables

  datosP cc = new datosP();
    Connection cn = cc.conexion();

}
