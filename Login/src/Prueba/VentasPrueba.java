/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prueba;

import Cliente.JF_AgregarCliente;
import Conexion.Conexion_k;
import Conexion.datosP;
import Factura.JF_ImprimirFactura;
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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Inventario.JF_Inventario;
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
            sql = "SELECT Nombre, PrimerApellido, SegundoApellido FROM registro_cliente WHERE id_Cliente= '" + txtCedula.getText() + "'";

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
        btninventario = new javax.swing.JButton();
        btnregistro = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnProforma = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        lblRequeridoCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        BtnVerificar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductosSelec = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductoInventario = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblRequeridoCodigo = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblRequeridoSubtotal = new javax.swing.JLabel();
        lblRequeridoTotal = new javax.swing.JLabel();
        txtFechaFact = new com.toedter.calendar.JDateChooser();
        txtHora = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtImpuesto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        BtnProf = new javax.swing.JButton();
        BtnPagar1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSubtotal = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        txtStock = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        lblRequerdioCantidad = new javax.swing.JLabel();
        VerSubtotal = new javax.swing.JButton();
        txtnombre = new javax.swing.JTextField();
        txtUsuarioVentas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();

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
                .addContainerGap(1513, Short.MAX_VALUE)
                .addComponent(BtnMinimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSalir))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnMinimizar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(BtnSalir)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1520, 50));

        PanelMenuV.setBackground(new java.awt.Color(0, 0, 0));
        PanelMenuV.setForeground(new java.awt.Color(255, 255, 255));
        PanelMenuV.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btninventario.setBackground(new java.awt.Color(0, 0, 0));
        btninventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inventory.png"))); // NOI18N
        btninventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btninventarioMouseClicked(evt);
            }
        });
        PanelMenuV.add(btninventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 60, 60));

        btnregistro.setBackground(new java.awt.Color(0, 0, 0));
        btnregistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/plus.png"))); // NOI18N
        btnregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistroMouseClicked(evt);
            }
        });
        PanelMenuV.add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 60, 60));

        btnsalir.setBackground(new java.awt.Color(0, 0, 0));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/evacuacion.png"))); // NOI18N
        btnsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsalirMouseClicked(evt);
            }
        });
        PanelMenuV.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 60, 60));

        btnProforma.setBackground(new java.awt.Color(0, 0, 0));
        btnProforma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        btnProforma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProformaMouseClicked(evt);
            }
        });
        PanelMenuV.add(btnProforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 60));

        jButton6.setText("jButton2");
        PanelMenuV.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 60, 60));

        getContentPane().add(PanelMenuV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 80, 880));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        lblRequeridoCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoCedula.setText("Requerido");

        txtCedula.setText("Cedula");

        BtnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        BtnVerificar.setContentAreaFilled(false);
        BtnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVerificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lblRequeridoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addComponent(BtnVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRequeridoCedula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(BtnVerificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 760, 80));

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

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 690, 220));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        tbProductoInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 710, 470));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Código");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 70, -1));

        txtCodigo.setEditable(false);
        jPanel6.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 110, -1));

        lblRequeridoCodigo.setForeground(new java.awt.Color(0, 102, 255));
        lblRequeridoCodigo.setText("Requerido");
        jPanel6.add(lblRequeridoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 60, -1));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Hora");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        lblRequeridoSubtotal.setBackground(new java.awt.Color(255, 255, 255));
        lblRequeridoSubtotal.setText("Requerido");
        jPanel4.add(lblRequeridoSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 60, -1));

        lblRequeridoTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoTotal.setText("Requerido");
        jPanel4.add(lblRequeridoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        txtFechaFact.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaFact.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtFechaFact.setEnabled(false);
        txtFechaFact.setFocusCycleRoot(true);
        jPanel4.add(txtFechaFact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 150, 40));

        txtHora.setBackground(new java.awt.Color(255, 255, 255));
        txtHora.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtHora.setDateFormatString("hh:mm:ss");
        txtHora.setEnabled(false);
        txtHora.setFocusCycleRoot(true);
        jPanel4.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 150, 40));

        jLabel8.setText("Fecha");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 150, 40));

        jLabel7.setText("Total");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 40, -1));

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 150, 40));

        jLabel6.setText("Descuento");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        txtImpuesto.setEditable(false);
        txtImpuesto.setBackground(new java.awt.Color(255, 255, 255));
        txtImpuesto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtImpuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, 40));

        jLabel20.setText("Impuesto");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, 40));

        jLabel21.setText("Subtotal");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        BtnProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        BtnProf.setText("NUEVA PROFORMA");
        BtnProf.setContentAreaFilled(false);
        BtnProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProfActionPerformed(evt);
            }
        });
        jPanel4.add(BtnProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, 50));

        BtnPagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/metodo-de-pago.png"))); // NOI18N
        BtnPagar1.setText("PAGAR");
        BtnPagar1.setContentAreaFilled(false);
        BtnPagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPagar1ActionPerformed(evt);
            }
        });
        jPanel4.add(BtnPagar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 120, 30));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 360, 410, 400));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        BtnAgregar.setBackground(new java.awt.Color(204, 204, 204));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cart.png"))); // NOI18N
        BtnAgregar.setBorder(null);
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 80, Short.MAX_VALUE)
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(BtnAgregar))
        );

        jPanel6.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 190, 160, 80));

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

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 230, 80));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel14.setText("Monto general");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        txtStock.setEditable(false);
        txtStock.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N

        txtCantidad.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Cantidad");

        lblRequerdioCantidad.setForeground(new java.awt.Color(0, 102, 255));
        lblRequerdioCantidad.setText("Requerido");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRequerdioCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRequerdioCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)))
                .addContainerGap())
        );

        jPanel6.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, 90));

        VerSubtotal.setBackground(new java.awt.Color(51, 51, 51));
        VerSubtotal.setText("Ver total");
        VerSubtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        VerSubtotal.setContentAreaFilled(false);
        VerSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerSubtotalActionPerformed(evt);
            }
        });
        jPanel6.add(VerSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 130, 30));

        txtnombre.setText("BUSCAR PRODUCTO");
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        jPanel6.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 238, 50));

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
        jPanel6.add(txtUsuarioVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        jButton1.setText("jButton1");
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 170, 50));

        txtCodigoBarras.setEditable(false);
        jPanel6.add(txtCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 590, 120, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Código de factura");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, 120, 20));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 1520, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnSalirMouseClicked

    private void BtnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_BtnMinimizarMouseClicked

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

//                    PreparedStatement pst = cn.prepareStatement("INSERT INTO orden(Cantidad,"
//                        + "Fk_Producto,Fk_Cliente, FK_Estado) VALUES (?,?,?,'3')");


                      PreparedStatement pst = cn.prepareStatement("INSERT INTO orden(Cantidad,Fk_Producto,Fk_Cliente, FK_Estado) VALUES (?,?,?,'3')");



                    pst.setString(1, txtCantidad.getText());
                    pst.setString(2, txtCodigo.getText());
                    pst.setString(3, txtCedula.getText());

                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null,"Se agregó al carrito de compras");

                } catch (Exception e) {
                       JOptionPane.showMessageDialog(null,e);
                   // System.out.print(e);
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

    
    public void Montos() {

        int Subtotal = Integer.parseInt(txtSubTotal.getText());
        Double Descuento = 0.0;
        Double Impuesto;
        Double TotalPagar;

        if (Subtotal < 250000) {

            Descuento = 0.0;

            Impuesto = (Subtotal * 0.13);

            TotalPagar = (Subtotal + Impuesto) - Descuento;

            txtImpuesto.setText("" + Impuesto);
            txtDescuento.setText("" + Descuento);
            txtTotalPagar.setText("" + TotalPagar);

        } else if (Subtotal >= 250000 && Subtotal < 500000) {

            Impuesto = (Subtotal * 0.13);

            Descuento = ((Subtotal + Impuesto) * 0.10);

            TotalPagar = (Subtotal + Impuesto) - Descuento;

            txtImpuesto.setText("" + Impuesto);
            txtDescuento.setText("" + Descuento);
            txtTotalPagar.setText("" + TotalPagar);

        } else if (Subtotal >= 500000 && Subtotal < 1000000) {

            Impuesto = (Subtotal * 0.13);

            Descuento = ((Subtotal + Impuesto) * 0.15);

            TotalPagar = (Subtotal + Impuesto) - Descuento;

            txtImpuesto.setText("" + Impuesto);
            txtDescuento.setText("" + Descuento);
            txtTotalPagar.setText("" + TotalPagar);

        } else if (Subtotal >= 1000000) {

            Impuesto = (Subtotal * 0.13);

            Descuento = ((Subtotal + Impuesto) * 0.20);

            TotalPagar = (Subtotal + Impuesto) - Descuento;

            txtImpuesto.setText("" + Impuesto);
            txtDescuento.setText("" + Descuento);
            txtTotalPagar.setText("" + TotalPagar);

        }

    }

    
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

            Montos();

           // btnAplicarDescuento.setEnabled(true);

            Calendar c2 = new GregorianCalendar();
            txtFechaFact.setCalendar(c2);

            Calendar fa = new GregorianCalendar();
            txtHora.setCalendar(fa);
        }

    }//GEN-LAST:event_VerSubtotalActionPerformed

    private void BtnProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProfActionPerformed

        cont = 0;

        if (txtTotalPagar.getText().equals("")) {
            lblRequeridoTotal.setVisible(true);
            cont++;
        } else {
            lblRequeridoTotal.setVisible(false);

        }

        if (cont == 0) {
            try {
                datosP cc = new datosP();
                Connection cn = cc.conexion();
                processCalendar();
                processHora();

                PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(Id_Factura, Fecha, Subtotal, Impuesto, "
                    + "Descuento, TotalPagar, Fk_Usuario, Hora) VALUES (?,?,?,?,?,?,?,?)");

                pst.setString(1, txtCodigoBarras.getText());
                pst.setString(2, date);
                pst.setString(3, txtSubTotal.getText());
                pst.setString(4, txtImpuesto.getText());
                pst.setString(5, txtDescuento.getText());
                pst.setString(6, txtTotalPagar.getText());
                pst.setString(7, txtUsuarioVentas.getText());
                pst.setString(8, Hora);

                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Factura=" + txtCodigoBarras.getText() + ", Fk_Estado  = 1");
                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }

            txtSubTotal.setText("");
            txtImpuesto.setText("");
            txtDescuento.setText("");
            txtTotalPagar.setText("");
            txtCodigoBarras.setText("");

            txtFechaFact.setCalendar(null);
            txtHora.setCalendar(null);

            DefaultTableModel tb = (DefaultTableModel) tbProductosSelec.getModel();
            int a = tbProductosSelec.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);
            }

            DefaultTableModel tb2 = (DefaultTableModel) tbSubtotal.getModel();
            int b = tbSubtotal.getRowCount() - 1;
            for (int i = b; i >= 0; i--) {
                tb2.removeRow(tb2.getRowCount() - 1);
            }
        }
    }//GEN-LAST:event_BtnProfActionPerformed

    private void BtnPagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagar1ActionPerformed

        cont = 0;

        if (txtTotalPagar.getText().equals("")) {
            lblRequeridoTotal.setVisible(true);
            cont++;
        } else {
            lblRequeridoTotal.setVisible(false);

        }

        if (cont == 0) {

            try {
                datosP cc = new datosP();
                Connection cn = cc.conexion();
                processCalendar();
                processHora();

//                PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(Id_Factura, Fecha, Subtotal, Impuesto, "
//                    + "Descuento, TotalPagar, Fk_Usuario, Hora) VALUES (?,?,?,?,?,?,?,?)");

                PreparedStatement pst = cn.prepareStatement("INSERT INTO factura(Id_Factura, Fecha, Subtotal, Impuesto, "
                        + "Descuento, TotalPagar) VALUES (?,?,?,?,?,?)");

                pst.setString(1, txtCodigoBarras.getText());
                pst.setString(2, date);
                pst.setString(3, txtSubTotal.getText());
                pst.setString(4, txtImpuesto.getText());
                pst.setString(5, txtDescuento.getText());
                pst.setString(6, txtTotalPagar.getText());
//cambie  txtusuarioventas por txtcedula
                //pst.setString(8, Hora); elimine hora porque en la tabla de la bd no esta

                pst.executeUpdate();

            } catch (Exception e) {
               // System.out.print(e);
                JOptionPane.showMessageDialog(null, e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Factura=" + txtCodigoBarras.getText() + ", Fk_Estado = 1 where Fk_Estado = 3");
                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }

            JF_ImprimirFactura m = new JF_ImprimirFactura();
            m.setVisible(true);
            dispose();

            m.txtCodigoFac1.setText(txtCodigoBarras.getText());

            m.mostrar1();
            m.mostrar2();
            m.mostrar3();

            m.txtUsuarioVentas3.setText(txtUsuarioVentas.getText());
            
            // a la hora de pagar que se limpie el table...
            DefaultTableModel tb = (DefaultTableModel) tbProductosSelec.getModel();
            int a = tbProductosSelec.getRowCount() - 1;
            for (int i = a; i >= 0; i--) {
                tb.removeRow(tb.getRowCount() - 1);
            }

            DefaultTableModel tb2 = (DefaultTableModel) tbSubtotal.getModel();
            int b = tbSubtotal.getRowCount() - 1;
            for (int i = b; i >= 0; i--) {
                tb2.removeRow(tb2.getRowCount() - 1);
            }

        }
    }//GEN-LAST:event_BtnPagar1ActionPerformed

    private void txtUsuarioVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentasActionPerformed

    private void btnProformaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProformaMouseClicked
        JF_Proforma p= new JF_Proforma();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProformaMouseClicked

    private void btnregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistroMouseClicked
       JF_AgregarCliente c= new JF_AgregarCliente();
       c.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnregistroMouseClicked

    private void btninventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btninventarioMouseClicked
        JF_Inventario i= new JF_Inventario();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_btninventarioMouseClicked

    private void btnsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsalirMouseClicked
       System.exit(0);
    }//GEN-LAST:event_btnsalirMouseClicked

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
    private javax.swing.JLabel BtnMinimizar;
    private javax.swing.JButton BtnPagar1;
    private javax.swing.JButton BtnProf;
    private javax.swing.JLabel BtnSalir;
    private javax.swing.JButton BtnVerificar;
    private javax.swing.JPanel PanelMenuV;
    private javax.swing.JButton VerSubtotal;
    private javax.swing.JButton btnProforma;
    private javax.swing.JButton btninventario;
    private javax.swing.JButton btnregistro;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
