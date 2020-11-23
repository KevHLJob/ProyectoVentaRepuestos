/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proforma;
import Conexion.Conexion_k;
import Conexion.datosP;
import Factura.JF_ImprimirFactura;
import Login.JF_Login;
import Menu.JF_Menu;
import MenuSimple.JF_MenuSimple;
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
        modelo.addColumn("Hora");

        tbDatos.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {

            sql = "SELECT DISTINCTROW Id_Factura,Nombre,PrimerApellido, Id_Cliente, Subtotal, Impuesto, Descuento, TotalPagar,Fecha, Hora FROM factura a INNER JOIN orden b on (b.Fk_Factura = a.Id_Factura) "
                    + "INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente) where c.Id_Cliente ='" + txtBuscar.getText() + "' and Fk_Estado = 2";

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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuarioVentas3 = new javax.swing.JTextField();
        Btnmenu = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtOrdenP = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        VerProducto = new javax.swing.JButton();
        lblRequeridoOrden = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(181, 62, 12));
        jButton1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jButton1.setText("INICIO");
        jButton1.setBorder(null);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 129, 166, 37));

        jButton2.setBackground(new java.awt.Color(181, 62, 12));
        jButton2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jButton2.setText("FACTURACION");
        jButton2.setBorder(null);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, 166, 39));

        jButton3.setBackground(new java.awt.Color(181, 62, 12));
        jButton3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jButton3.setText("INVENTARIOS");
        jButton3.setBorder(null);
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 264, 166, 34));

        jButton4.setBackground(new java.awt.Color(181, 62, 12));
        jButton4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jButton4.setText("HISTORIAL DE VENTAS");
        jButton4.setBorder(null);
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 335, 166, 35));

        jButton5.setBackground(new java.awt.Color(181, 62, 12));
        jButton5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        jButton5.setText("SALIR");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 441, 166, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventory.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 256, 31, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        jLabel2.setText("jLabel1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 325, 42, 54));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comprar.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 190, 42, 48));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/oficina-en-casa.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 42, 43));

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
        jPanel1.add(txtUsuarioVentas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 80, 100, -1));

        Btnmenu.setBackground(new java.awt.Color(153, 153, 153));
        Btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnmenuMouseClicked(evt);
            }
        });
        Btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(67, 81, 141));
        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Menu");
        Btnmenu.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        jPanel1.add(Btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 640));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1180, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 0, 1180, 50));

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

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 740, 370));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel14.setText("Registro de proformas");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

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

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 360, 370));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cédula vinculado a la proforma:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Productos");

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
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
            .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(20, 20, 20)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(87, 87, 87))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBuscar)
                        .addGap(2, 2, 2))
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 1000, 50));

        txtOrdenP.setEditable(false);
        jPanel4.add(txtOrdenP, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 610, 140, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Identificador");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, 30));

        jPanel7.setBackground(new java.awt.Color(255, 102, 102));
        jPanel7.setForeground(new java.awt.Color(255, 0, 0));

        btnPagar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
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

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 610, 130, -1));

        jPanel8.setBackground(new java.awt.Color(255, 102, 102));

        VerProducto.setBackground(new java.awt.Color(255, 102, 102));
        VerProducto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        VerProducto.setForeground(new java.awt.Color(255, 255, 255));
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VerProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        jPanel4.add(lblRequeridoOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 650, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1380, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDatosMouseClicked
        int seleccionar = tbDatos.rowAtPoint(evt.getPoint());
        txtOrdenP.setText(String.valueOf(tbDatos.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tbDatosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//        mostrardatos("");
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
    private javax.swing.JPanel Btnmenu;
    private javax.swing.JButton VerProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
