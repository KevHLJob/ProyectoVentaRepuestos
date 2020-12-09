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

            //Cambié Nombre_cliente y Cedula_cliente
//            sql = "SELECT Id_Factura,Nombre,Cédula,FK_Producto,Cantidad,TotalPagar,Fecha "
//                    + "FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)";
            sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)";

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

//           sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cantidad,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
//                    + " FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)" + " AND Fecha='" + date + "'";
                    
           sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"+ " AND Fecha='" + date + "'";          
                 

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

//            sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cantidad,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
//                    + " FROM factura a INNER JOIN orden b on (b.Id_Orden = a.Fk_orden) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"  + " AND Fecha between'" + date + "' and '" + date2 + "'  ";
                 sql = "SELECT DISTINCTROW id_Factura,Nombre,PrimerApellido,Cédula,CorreoElectronico,Fecha,Subtotal,Impuesto,Descuento, TotalPagar"
                    + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"+ " AND Fecha between'" + date + "' and '" + date2 + "'  ";  
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
                      + " FROM factura a INNER JOIN orden b on (a.Id_Factura = b.Fk_Factura) INNER Join registro_cliente c on (c.Id_Cliente = b.Fk_Cliente)"+ " AND Cédula='" + txtCedula.getText() + "'";

            
            
          
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
        jButton1 = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();
        btnregistros = new javax.swing.JButton();
        btnProformas = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDatos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnFiltrarRango = new javax.swing.JButton();
        txtFecha2 = new com.toedter.calendar.JDateChooser();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jPanel7 = new javax.swing.JPanel();
        btnFiltrarCedula = new javax.swing.JButton();

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

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFacturacion.setBackground(new java.awt.Color(0, 0, 0));
        btnFacturacion.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnFacturacion.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturacion.setText("FACTURACIÓN");

        btnregistros.setBackground(new java.awt.Color(0, 0, 0));
        btnregistros.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnregistros.setForeground(new java.awt.Color(255, 255, 255));
        btnregistros.setText("REGISTROS");

        btnProformas.setBackground(new java.awt.Color(0, 0, 0));
        btnProformas.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnProformas.setForeground(new java.awt.Color(255, 255, 255));
        btnProformas.setText("PROFORMAS");

        btnsalir.setBackground(new java.awt.Color(0, 0, 0));
        btnsalir.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 102, 102));
        btnsalir.setText("SALIR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUsuarioVentas2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(btnregistros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProformas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(txtUsuarioVentas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnregistros, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnProformas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnsalir)
                .addContainerGap(366, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 260, 890));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setText("Historial de ventas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(621, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(559, 559, 559))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 1390, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButton2.setText("VER TODAS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbDatos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1105, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 1380, 730));

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnFiltrarCedula.setBackground(new java.awt.Color(255, 255, 255));
        btnFiltrarCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/motor-de-busqueda-web (1).png"))); // NOI18N
        btnFiltrarCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarCedulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFiltrarCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFiltrarCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(218, 218, 218)
                        .addComponent(btnFiltrarRango)
                        .addGap(172, 172, 172))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(txtFecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrarRango)
                    .addComponent(btnFiltrar))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 1380, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnFiltrarCedula;
    private javax.swing.JButton btnFiltrarRango;
    private javax.swing.JButton btnProformas;
    private javax.swing.JButton btnregistros;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
