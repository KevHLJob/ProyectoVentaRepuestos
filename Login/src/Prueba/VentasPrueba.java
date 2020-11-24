/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Cliente.JF_AgregarCliente;
import Conexion.Conexion_k;
import Conexion.datosP;
import Login.JF_Login;
import Menu.JF_Menu;
import MenuSimple.JF_MenuSimple;
import Proforma.JF_Proforma;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Klope
 */
public class VentasPrueba extends javax.swing.JFrame {

    TableRowSorter trsfiltro;
    String date;
    String Hora;
    int cont;
//    Conexion_k cc = new Conexion_k();
//            Connection cn = cc.conexion();
            
            
    public VentasPrueba() {
        initComponents();
        
        setLocationRelativeTo(null);
      
        
        
        mostrardatosProducto("");
        
        
    }

//    void acceder(String usuario) {
//        String cap = "";
//        String sql = "SELECT * FROM registro_usuario WHERE Usuario='" + usuario + "'";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                cap = rs.getString("Fk_TipoUsuario");
//            }
//            if (cap.equals("1")) {
//                JF_Menu m = new JF_Menu();
//                m.setVisible(true);
//                dispose();
//
//                m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());
//            } else if (cap.equals("2")) {
//                JF_MenuSimple m = new JF_MenuSimple();
//                m.setVisible(true);
//                dispose();
//
//                m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(JF_Login.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    
    
     public void mostrardatosProducto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N.I");
        modelo.addColumn("Identificador");
        modelo.addColumn("Producto");
        modelo.addColumn("Presentación");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");

        tbProductoInventario.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Id_Disponibilidad , Id_Producto, Nombre , Presentacion, PrecioUnitario, Cantidad, NombreProveedor "
                    + "FROM inventario a INNER JOIN producto b on (b.Id_Producto = a.Fk_Productos) INNER Join proveedor c on (c.Id_Proveedor = a.Fk_Proveedor)";

        }
        String[] datos = new String[7];
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

                modelo.addRow(datos);
            }
            tbProductoInventario.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
     public void mostrarCliente(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("AP1");
        modelo.addColumn("AP2");

        tbCliente.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Nombre, PrimerApellido, SegundoApellido FROM registro_cliente WHERE Cédula = '" + txtCedula.getText() + "'";

        }
        String[] datos = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);
            }
            tbCliente.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
           //  Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void processCalendar() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //yyyy-MM-dd
        date = dateFormat.format(txtFechaFact.getDate());

    }

    public void processHora() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        //yyyy-MM-dd
        Hora = dateFormat.format(txtHora.getDate());

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JLabel();
        BtnMinimizar = new javax.swing.JLabel();
        PanelMenuV = new javax.swing.JPanel();
        BtnMenu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        BtnProforma = new javax.swing.JPanel();
        btnProformas = new javax.swing.JLabel();
        BtnIRegistrarCliente = new javax.swing.JPanel();
        btnregistrarcliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsuarioVentas = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        BtnVerificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        txtCedula = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblRequeridoCedula = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductosSelec = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductoInventario = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblRequeridoSubtotal = new javax.swing.JLabel();
        lblRequeridoTotal = new javax.swing.JLabel();
        txtFechaFact = new com.toedter.calendar.JDateChooser();
        txtHora = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSubtotal = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        VerSubtotal = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        BtnProf = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BtnPagar1 = new javax.swing.JButton();
        lblRequerdioCantidad = new javax.swing.JLabel();
        lblRequeridoCodigo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        BtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSalirMouseClicked(evt);
            }
        });

        BtnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnMinimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(1504, Short.MAX_VALUE)
                .addComponent(BtnMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSalir))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(BtnSalir)
                .addGap(0, 50, Short.MAX_VALUE))
            .addComponent(BtnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 50));

        PanelMenuV.setBackground(new java.awt.Color(0, 0, 0));
        PanelMenuV.setForeground(new java.awt.Color(255, 255, 255));
        PanelMenuV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnMenu.setBackground(new java.awt.Color(255, 0, 0));
        BtnMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnMenuMouseClicked(evt);
            }
        });
        BtnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(67, 81, 141));
        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Menú");
        BtnMenu.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 60, 30));

        PanelMenuV.add(BtnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 150, -1));

        BtnProforma.setBackground(new java.awt.Color(153, 153, 153));
        BtnProforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnProformaMouseClicked(evt);
            }
        });
        BtnProforma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProformas.setBackground(new java.awt.Color(67, 81, 141));
        btnProformas.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        btnProformas.setForeground(new java.awt.Color(255, 255, 255));
        btnProformas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProformas.setText("Proformas");
        BtnProforma.add(btnProformas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        PanelMenuV.add(BtnProforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, -1));

        BtnIRegistrarCliente.setBackground(new java.awt.Color(153, 153, 153));
        BtnIRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnIRegistrarClienteMouseClicked(evt);
            }
        });
        BtnIRegistrarCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistrarcliente.setBackground(new java.awt.Color(67, 81, 141));
        btnregistrarcliente.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        btnregistrarcliente.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarcliente.setText("Registrar cliente");
        BtnIRegistrarCliente.add(btnregistrarcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        PanelMenuV.add(BtnIRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        PanelMenuV.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        txtUsuarioVentas.setEditable(false);
        txtUsuarioVentas.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuarioVentas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtUsuarioVentas.setText("      ");
        txtUsuarioVentas.setBorder(null);
        txtUsuarioVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioVentasActionPerformed(evt);
            }
        });
        PanelMenuV.add(txtUsuarioVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 120, 40));

        getContentPane().add(PanelMenuV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 660));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel15.setText("Catálogo de productos");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel10.setBackground(new java.awt.Color(255, 204, 51));

        BtnVerificar.setText("Verificar");
        BtnVerificar.setContentAreaFilled(false);
        BtnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(BtnVerificar)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbCliente.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbCliente);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cliente");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cédula");

        lblRequeridoCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoCedula.setText("Requerido");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel11)
                        .addGap(26, 26, 26)
                        .addComponent(lblRequeridoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(127, 127, 127))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblRequeridoCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 630, 120));

        tbProductosSelec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductosSelec.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tbProductosSelec);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 110, 540, 190));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Productos seleccionados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 80, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Código de factura");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 120, -1));

        txtCodigoBarras.setEditable(false);
        getContentPane().add(txtCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 80, 120, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Productos en inventario ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, 30));

        tbProductoInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProductoInventario.setGridColor(new java.awt.Color(255, 255, 255));
        tbProductoInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductoInventarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbProductoInventario);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 620, 310));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre del producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, -1, -1));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 660, 160, 30));

        txtCodigo.setEditable(false);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 640, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Código");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, 70, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Cantidad");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 670, -1, -1));

        txtStock.setEditable(false);
        getContentPane().add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, 30, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 670, 70, -1));

        jPanel4.setBackground(new java.awt.Color(0, 102, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hora");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descuento");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total a pagar");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, -1));

        txtImpuesto.setEditable(false);
        jPanel4.add(txtImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 140, -1));

        txtDescuento.setEditable(false);
        jPanel4.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, -1));

        txtTotalPagar.setEditable(false);
        jPanel4.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 140, 20));

        txtSubTotal.setEditable(false);
        jPanel4.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 140, -1));

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Impuesto");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Subtotal");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblRequeridoSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoSubtotal.setText("Requerido");
        jPanel4.add(lblRequeridoSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 60, -1));

        lblRequeridoTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoTotal.setText("Requerido");
        jPanel4.add(lblRequeridoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        txtFechaFact.setEnabled(false);
        txtFechaFact.setFocusCycleRoot(true);
        jPanel4.add(txtFechaFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 100, 20));

        txtHora.setDateFormatString("hh:mm:ss");
        txtHora.setEnabled(false);
        txtHora.setFocusCycleRoot(true);
        jPanel4.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 100, 20));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 320, 260, 290));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setForeground(new java.awt.Color(0, 102, 255));

        BtnAgregar.setBackground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar al carrito");
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(BtnAgregar))
        );

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 640, 140, 30));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel14.setText("Monto general");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, -1, -1));

        tbSubtotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbSubtotal.setGridColor(new java.awt.Color(255, 255, 255));
        tbSubtotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSubtotalMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbSubtotal);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, 110, 50));

        jPanel9.setBackground(new java.awt.Color(0, 102, 255));

        VerSubtotal.setForeground(new java.awt.Color(255, 255, 255));
        VerSubtotal.setText("Ver total");
        VerSubtotal.setContentAreaFilled(false);
        VerSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerSubtotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VerSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(VerSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 130, 30));

        jPanel5.setBackground(new java.awt.Color(51, 102, 255));

        BtnProf.setForeground(new java.awt.Color(255, 255, 255));
        BtnProf.setText("Guardar como proforma");
        BtnProf.setContentAreaFilled(false);
        BtnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnProf, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnProf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 620, 200, 30));

        jPanel8.setBackground(new java.awt.Color(255, 204, 51));

        BtnPagar1.setText("Pagar ");
        BtnPagar1.setContentAreaFilled(false);
        BtnPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPagar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(BtnPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnPagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 660, 200, -1));

        lblRequerdioCantidad.setForeground(new java.awt.Color(0, 102, 255));
        lblRequerdioCantidad.setText("Requerido");
        getContentPane().add(lblRequerdioCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 670, 60, -1));

        lblRequeridoCodigo.setForeground(new java.awt.Color(0, 102, 255));
        lblRequeridoCodigo.setText("Requerido");
        getContentPane().add(lblRequeridoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 620, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnSalirMouseClicked

    private void BtnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_BtnMinimizarMouseClicked

    private void BtnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMenuMouseClicked
//        JF_Menu m = new JF_Menu();
//
//        m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());
//
//        String usu = txtUsuarioVentas.getText();
//        //acceder(usu);
    }//GEN-LAST:event_BtnMenuMouseClicked

    private void BtnProformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnProformaMouseClicked
        JF_Proforma m = new JF_Proforma();
        m.setVisible(true);
        dispose();
        // m.txtUsuarioVentas.setText(txtUsuarioVentas.getText());
    }//GEN-LAST:event_BtnProformaMouseClicked

    private void BtnIRegistrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIRegistrarClienteMouseClicked
        JF_AgregarCliente m = new JF_AgregarCliente();
        m.setVisible(true);
        dispose();
        //     m.txtUsuarioVentas.setText(txtUsuarioVentas.getText());
    }//GEN-LAST:event_BtnIRegistrarClienteMouseClicked

    private void BtnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerificarActionPerformed
        mostrarCliente("");
    }//GEN-LAST:event_BtnVerificarActionPerformed

    private void tbProductoInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductoInventarioMouseClicked
        int seleccionar = tbProductoInventario.rowAtPoint(evt.getPoint());
        txtCodigo.setText(String.valueOf(tbProductoInventario.getValueAt(seleccionar, 1)));

        int seleccionar2 = tbProductoInventario.rowAtPoint(evt.getPoint());
        txtStock.setText(String.valueOf(tbProductoInventario.getValueAt(seleccionar2, 5)));
    }//GEN-LAST:event_tbProductoInventarioMouseClicked

     private void filtro() {
        int columnatb = 2;
        trsfiltro.setRowFilter(RowFilter.regexFilter(txtnombre.getText(), columnatb));

    }
    
    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        // TODO add your handling code here:
        txtnombre.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                String cadena = (txtnombre.getText());
                txtnombre.setText(cadena);
                filtro();
            }
        });
        trsfiltro = new TableRowSorter(tbProductoInventario.getModel());
        tbProductoInventario.setRowSorter(trsfiltro);
    }//GEN-LAST:event_txtnombreKeyTyped

    
    
      public void mostrarProductosSeleccionados(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id_Producto");
        modelo.addColumn("Producto");
        modelo.addColumn("Presentacion");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Cantidad");

        tbProductosSelec.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT b.Id_Producto, b.Nombre, b.Presentacion, b.PrecioUnitario, a.Cantidad"
                    + " FROM orden a INNER JOIN producto b on (b.Id_Producto = a.Fk_Producto) where Fk_Estado = 3";

        }
        String[] datos = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);

                modelo.addRow(datos);
            }
            tbProductosSelec.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void mostrardatoSubtotal(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Monto inicial");

        tbSubtotal.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "select sum( a.Cantidad * b.PrecioUnitario ) as Monto from orden a INNER JOIN producto b on (b.Id_Producto = a.Fk_Producto) where Fk_Estado = 3";

        }
        String[] datos = new String[1];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);

                modelo.addRow(datos);
            }
            tbSubtotal.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
      
      public void mostrarBusquedaProducto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("N.I");
        modelo.addColumn("Identificador");
        modelo.addColumn("Producto");
        modelo.addColumn("Presentación");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Proveedor");

        tbProductoInventario.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Id_Disponibilidad ,Id_Producto, Nombre , Presentacion, PrecioUnitario, Cantidad, NombreProveedor FROM inventario a INNER JOIN producto b on (b.Id_Producto = a.Fk_Productos) "
                    + "INNER Join proveedor c on (c.Id_Proveedor = a.Fk_Proveedor)";

        }
        String[] datos = new String[7];
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

                modelo.addRow(datos);
            }
            tbProductoInventario.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed

        cont = 0;

        if (txtCedula.getText().equals("")) {
            lblRequeridoCedula.setVisible(true);
            cont++;
        } else {
            lblRequeridoCedula.setVisible(false);

        }
        if (txtCodigo.getText().equals("")) {
            lblRequeridoCodigo.setVisible(true);
            cont++;
        } else {
            lblRequeridoCodigo.setVisible(false);

        }

        if (txtCantidad.getText().equals("")) {
            lblRequerdioCantidad.setVisible(true);
            cont++;
        } else {
            lblRequerdioCantidad.setVisible(false);

        }

        if (cont == 0) {

            int Stock = Integer.parseInt(txtStock.getText());
            int Cantidad = Integer.parseInt(txtCantidad.getText());
            int NuevoStock;

            NuevoStock = (Stock - Cantidad);

            if (Stock == 0) {
                JOptionPane.showMessageDialog(this, "No hay Stock");
                txtCantidad.setText("");

            } else if (Cantidad <= Stock) {

                try {
//                    Conexion_k cc = new Conexion_k();
//                    Connection cn = cc.conexion();

 datosP cc = new datosP();
            Connection cn = cc.conexion();

                    PreparedStatement pst = cn.prepareStatement("INSERT INTO orden(Cantidad,"
                        + "Fk_Producto,Fk_Cliente, FK_Estado) VALUES (?,?,?,'2')");

                    pst.setString(1, txtCantidad.getText());
                    pst.setString(2, txtCodigo.getText());
                    pst.setString(3, txtCedula.getText());

                    pst.executeUpdate();

                } catch (Exception e) {
                    System.out.print(e);
                }

                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE producto SET Cantidad=" + NuevoStock + " where Id_Producto = " + txtCodigo.getText() + "");
                    pst.executeUpdate();

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }

                txtCantidad.setText("");
                txtCodigo.setText("");
                txtnombre.setText("");

                txtSubTotal.setText("");
                txtImpuesto.setText("");
                txtDescuento.setText("");
                txtTotalPagar.setText("");
                txtStock.setText("");

                mostrarProductosSeleccionados("");

                mostrardatoSubtotal("");

                mostrarBusquedaProducto("");

            } else if (Cantidad > Stock) {

                JOptionPane.showMessageDialog(this, "Superas el Stock");
                txtCantidad.setText("");

            }

        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void tbSubtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSubtotalMouseClicked

        int seleccionar = tbSubtotal.rowAtPoint(evt.getPoint());
        txtSubTotal.setText(String.valueOf(tbSubtotal.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tbSubtotalMouseClicked

    private void VerSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerSubtotalActionPerformed

        cont = 0;

        if (txtSubTotal.getText().equals("")) {
            lblRequeridoSubtotal.setVisible(true);
            cont++;
        } else {
            lblRequeridoSubtotal.setVisible(false);

        }
        if (cont == 0) {
            int numero;
            numero = (int) (Math.random() * 1000000000) + 1;
            txtCodigoBarras.setText("" + numero);

//            Montos();
//
//            btnAplicarDescuento.setEnabled(true);
//
//            Calendar c2 = new GregorianCalendar();
//            txtFechaFact.setCalendar(c2);
//
//            Calendar fa = new GregorianCalendar();
//            txtHora.setCalendar(fa);
        }

    }//GEN-LAST:event_VerSubtotalActionPerformed

    private void BtnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProfActionPerformed
//
//        cont = 0;
//
//        if (txtTotalPagar.getText().equals("")) {
//            lblRequeridoTotal.setVisible(true);
//            cont++;
//        } else {
//            lblRequeridoTotal.setVisible(false);
//
//        }
//
//        if (cont == 0) {
//            try {
//                datosP cc = new datosP();
//                Connection cn = cc.conexion();
//                processCalendar();
//                processHora();
//
//                PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(Id_Factura, Fecha, Subtotal, Impuesto, "
//                    + "Descuento, TotalPagar, Fk_Usuario, Hora) VALUES (?,?,?,?,?,?,?,?)");
//
//                pst.setString(1, txtCodigoBarras.getText());
//                pst.setString(2, date);
//                pst.setString(3, txtSubTotal.getText());
//                pst.setString(4, txtImpuesto.getText());
//                pst.setString(5, txtDescuento.getText());
//                pst.setString(6, txtTotalPagar.getText());
//                pst.setString(7, txtUsuarioVentas.getText());
//                pst.setString(8, Hora);
//
//                pst.executeUpdate();
//
//            } catch (Exception e) {
//                System.out.print(e);
//            }
//
//            try {
//                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Factura=" + txtCodigoBarras.getText() + ", Fk_Estado = 2 where Fk_Estado = 3");
//                pst.executeUpdate();
//
//            } catch (Exception e) {
//                System.out.print(e.getMessage());
//            }
//
//            txtSubTotal.setText("");
//            txtImpuesto.setText("");
//            txtDescuento.setText("");
//            txtTotalPagar.setText("");
//            txtCodigoBarras.setText("");
//
//            txtFechaFact.setCalendar(null);
//            txtHora.setCalendar(null);
//
//            DefaultTableModel tb = (DefaultTableModel) tbProductosSelec.getModel();
//            int a = tbProductosSelec.getRowCount() - 1;
//            for (int i = a; i >= 0; i--) {
//                tb.removeRow(tb.getRowCount() - 1);
//            }
//
//            DefaultTableModel tb2 = (DefaultTableModel) tbSubtotal.getModel();
//            int b = tbSubtotal.getRowCount() - 1;
//            for (int i = b; i >= 0; i--) {
//                tb2.removeRow(tb2.getRowCount() - 1);
//            }
//        }
    }//GEN-LAST:event_BtnProfActionPerformed

    private void BtnPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagar1ActionPerformed

//        cont = 0;
//
//        if (txtTotalPagar.getText().equals("")) {
//            lblRequeridoTotal.setVisible(true);
//            cont++;
//        } else {
//            lblRequeridoTotal.setVisible(false);
//
//        }
//
//        if (cont == 0) {
//
//            try {
//                datosP cc = new datosP();
//                Connection cn = cc.conexion();
//                processCalendar();
//                processHora();
//
//                PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(Id_Factura, Fecha, Subtotal, Impuesto, "
//                    + "Descuento, TotalPagar, Fk_Usuario, Hora) VALUES (?,?,?,?,?,?,?,?)");
//
//                pst.setString(1, txtCodigoBarras.getText());
//                pst.setString(2, date);
//                pst.setString(3, txtSubTotal.getText());
//                pst.setString(4, txtImpuesto.getText());
//                pst.setString(5, txtDescuento.getText());
//                pst.setString(6, txtTotalPagar.getText());
//                pst.setString(7, txtUsuarioVentas.getText());
//                pst.setString(8, Hora);
//
//                pst.executeUpdate();
//
//            } catch (Exception e) {
//                System.out.print(e);
//            }
//
//            try {
//                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Factura=" + txtCodigoBarras.getText() + ", Fk_Estado = 1 where Fk_Estado = 3");
//                pst.executeUpdate();
//
//            } catch (Exception e) {
//                System.out.print(e.getMessage());
//            }
//
//            JF_ImprimirFactura m = new JF_ImprimirFactura();
//            m.setVisible(true);
//            dispose();
//
//            m.txtCodigoFac1.setText(txtCodigoBarras.getText());
//
//            m.mostrar1();
//            m.mostrar2();
//            m.mostrar3();
//
//            //m.txtUsuarioVentas.setText(txtUsuarioVentas.getText());
//
//        }
    }//GEN-LAST:event_BtnPagar1ActionPerformed

    private void txtUsuarioVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentasActionPerformed

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
            java.util.logging.Logger.getLogger(VentasPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasPrueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JPanel BtnIRegistrarCliente;
    private javax.swing.JPanel BtnMenu;
    private javax.swing.JLabel BtnMinimizar;
    private javax.swing.JButton BtnPagar1;
    private javax.swing.JButton BtnProf;
    private javax.swing.JPanel BtnProforma;
    private javax.swing.JLabel BtnSalir;
    private javax.swing.JButton BtnVerificar;
    private javax.swing.JPanel PanelMenuV;
    private javax.swing.JButton VerSubtotal;
    private javax.swing.JLabel btnProformas;
    private javax.swing.JLabel btnregistrarcliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblRequerdioCantidad;
    private javax.swing.JLabel lblRequeridoCedula;
    private javax.swing.JLabel lblRequeridoCodigo;
    private javax.swing.JLabel lblRequeridoSubtotal;
    private javax.swing.JLabel lblRequeridoTotal;
    private javax.swing.JTable tbCliente;
    public javax.swing.JTable tbProductoInventario;
    private javax.swing.JTable tbProductosSelec;
    private javax.swing.JTable tbSubtotal;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBarras;
    public javax.swing.JTextField txtDescuento;
    private com.toedter.calendar.JDateChooser txtFechaFact;
    public com.toedter.calendar.JDateChooser txtHora;
    public javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubTotal;
    public javax.swing.JTextField txtTotalPagar;
    public javax.swing.JTextField txtUsuarioVentas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
 datosP cc = new datosP();
            Connection cn = cc.conexion();

}
