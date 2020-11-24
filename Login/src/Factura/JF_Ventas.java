package Factura;
import Conexion.Conexion_k;
import Conexion.datosP;
import Factura.JF_ImprimirFactura;
import Factura.JF_FiltrarFacturas;
import Login.JF_Login;
import Menu.JF_Menu;
import MenuSimple.JF_MenuSimple;
import Proforma.JF_Proforma;
import Cliente.JF_AgregarCliente;
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

public class JF_Ventas extends javax.swing.JFrame {

    TableRowSorter trsfiltro;
    String date;
    String Hora;
    int cont;
    Conexion_k cc = new Conexion_k();
            Connection cn = cc.conexion();

    public JF_Ventas() {
        initComponents();
        setLocationRelativeTo(null);

        lblRequeridoCedula.setVisible(false);
        lblRequeridoCodigo.setVisible(false);
        lblRequerdioCantidad.setVisible(false);
        lblRequeridoSubtotal.setVisible(false);
        lblRequeridoTotal.setVisible(false);

        lblComprobacion.setVisible(false);
        lblusuario.setVisible(false);
        lblcontraseña.setVisible(false);
        BtnIngresar.setVisible(false);
        lblPorcentaje.setVisible(false);
        BtnPorcentaje.setVisible(false);
        txtUsuario.setVisible(false);
        txtContraseña.setVisible(false);
        PanelPermiso.setVisible(false);

    }

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

                m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());
            } else if (cap.equals("2")) {
                JF_MenuSimple m = new JF_MenuSimple();
                m.setVisible(true);
                dispose();

                m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());
            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Login.class.getName()).log(Level.SEVERE, null, ex);
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

    public void mostrarCliente(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("AP1");
        modelo.addColumn("AP2");

        tbCliente.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Nombre, PrimerApellido, SegundoApellido FROM registro_cliente where Id_Cliente = '" + txtCedula.getText() + "'";

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
         //    Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JLabel();
        BtnMinimizar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProductoInventario = new javax.swing.JTable();
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
        jLabel15 = new javax.swing.JLabel();
        btnAplicarDescuento = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbProductosSelec = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSubtotal = new javax.swing.JTable();
        txtCodigoBarras = new javax.swing.JTextField();
        lblRequerdioCantidad = new javax.swing.JLabel();
        lblRequeridoCodigo = new javax.swing.JLabel();
        lblRequeridoCedula = new javax.swing.JLabel();
        PanelMenuV = new javax.swing.JPanel();
        BtnMenu = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        BtnProforma = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        BtnIRegistrarCliente = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtUsuarioVentas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        PanelPermiso = new javax.swing.JPanel();
        lblComprobacion = new javax.swing.JLabel();
        lblusuario = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        lblcontraseña = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        BtnPorcentaje = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        BtnIngresar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        BtnVerificar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BtnProf = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        BtnPagar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        BtnAgregar1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        VerSubtotal = new javax.swing.JButton();
        BtnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        BtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-cerrar-ventana-48.png"))); // NOI18N
        BtnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnSalirMouseClicked(evt);
            }
        });

        BtnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8-minimizar-la-ventana-48 (1).png"))); // NOI18N
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
                .addContainerGap(1414, Short.MAX_VALUE)
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 50));

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel14.setText("Monto general");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre del producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 260, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Productos en inventario ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Productos seleccionados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 70, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 620, 310));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 300, 260, 290));

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 30)); // NOI18N
        jLabel15.setText("Catálogo de productos");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        btnAplicarDescuento.setText("Aplicar un nuevo descuento ");
        btnAplicarDescuento.setEnabled(false);
        btnAplicarDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicarDescuentoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAplicarDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Cédula");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));
        jPanel1.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 200, 30));

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Código");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 600, 70, -1));

        txtCodigo.setEditable(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 110, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Cantidad");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 640, -1, -1));
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 640, 70, -1));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 540, 190));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Cliente");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 150, -1, -1));

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

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 350, 110, 50));

        txtCodigoBarras.setEditable(false);
        jPanel1.add(txtCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 70, 120, -1));

        lblRequerdioCantidad.setForeground(new java.awt.Color(0, 102, 255));
        lblRequerdioCantidad.setText("Requerido");
        jPanel1.add(lblRequerdioCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 640, 60, -1));

        lblRequeridoCodigo.setForeground(new java.awt.Color(0, 102, 255));
        lblRequeridoCodigo.setText("Requerido");
        jPanel1.add(lblRequeridoCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 600, 60, -1));

        lblRequeridoCedula.setForeground(new java.awt.Color(255, 255, 255));
        lblRequeridoCedula.setText("Requerido");
        jPanel1.add(lblRequeridoCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 60, -1));

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

        jLabel17.setBackground(new java.awt.Color(67, 81, 141));
        jLabel17.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Proformas");
        BtnProforma.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 30));

        PanelMenuV.add(BtnProforma, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, -1));

        BtnIRegistrarCliente.setBackground(new java.awt.Color(153, 153, 153));
        BtnIRegistrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnIRegistrarClienteMouseClicked(evt);
            }
        });
        BtnIRegistrarCliente.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(67, 81, 141));
        jLabel18.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Registrar cliente");
        BtnIRegistrarCliente.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 30));

        PanelMenuV.add(BtnIRegistrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        PanelMenuV.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jPanel1.add(PanelMenuV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 190, 660));

        txtStock.setEditable(false);
        jPanel1.add(txtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 30, -1));

        PanelPermiso.setBackground(new java.awt.Color(0, 102, 204));
        PanelPermiso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblComprobacion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblComprobacion.setForeground(new java.awt.Color(255, 255, 255));
        lblComprobacion.setText("Comprobación  ");
        PanelPermiso.add(lblComprobacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblusuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblusuario.setForeground(new java.awt.Color(255, 255, 255));
        lblusuario.setText("Usuario");
        PanelPermiso.add(lblusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        lblPorcentaje.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        lblPorcentaje.setText("Porcentaje");
        PanelPermiso.add(lblPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        lblcontraseña.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblcontraseña.setForeground(new java.awt.Color(255, 255, 255));
        lblcontraseña.setText("Contraseña");
        PanelPermiso.add(lblcontraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
        PanelPermiso.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 140, 30));

        BtnPorcentaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "21", "22", "23", "24", "25" }));
        PanelPermiso.add(BtnPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 60, -1));

        txtUsuario.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        PanelPermiso.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 209, 140, 30));

        BtnIngresar.setBackground(new java.awt.Color(255, 204, 51));
        BtnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnIngresarMouseClicked(evt);
            }
        });
        BtnIngresar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(67, 81, 141));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel13.setText("Comprobar");
        BtnIngresar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        PanelPermiso.add(BtnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 140, 30));

        jPanel1.add(PanelPermiso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 170, 560));

        jLabel9.setBackground(new java.awt.Color(0, 102, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 255));
        jLabel9.setText("Requiere un administrador");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 530, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 100, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 630, 110));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Código de factura");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 50, 120, -1));

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 610, 200, 30));

        jPanel8.setBackground(new java.awt.Color(255, 204, 51));

        BtnPagar.setText("Pagar ");
        BtnPagar.setContentAreaFilled(false);
        BtnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPagarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(BtnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 650, 200, -1));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));
        jPanel7.setForeground(new java.awt.Color(0, 102, 255));

        BtnAgregar1.setBackground(new java.awt.Color(255, 255, 255));
        BtnAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar1.setText("Agregar al carrito");
        BtnAgregar1.setContentAreaFilled(false);
        BtnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAgregar1)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addComponent(BtnAgregar1))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 670, 140, 30));

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

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 410, 130, 30));

        BtnAgregar.setBackground(new java.awt.Color(51, 255, 51));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar al carrito");
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 670, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void BtnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_BtnSalirMouseClicked

    private void BtnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMinimizarMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_BtnMinimizarMouseClicked

    private void btnAplicarDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicarDescuentoActionPerformed

//        int posicion = PanelMenuV.getX();
//        if (posicion > -1) {
//            Animacion.Animacion.mover_izquierda(0, -264, 2, 2, PanelMenuV);
//        } else {
//            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, PanelMenuV);
//        }

        lblComprobacion.setVisible(true);
        lblusuario.setVisible(true);
        lblcontraseña.setVisible(true);
        BtnIngresar.setVisible(true);
        lblPorcentaje.setVisible(true);
        BtnPorcentaje.setVisible(true);
        txtUsuario.setVisible(true);
        txtContraseña.setVisible(true);
        PanelPermiso.setVisible(true);


    }//GEN-LAST:event_btnAplicarDescuentoActionPerformed

    private void BtnMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMenuMouseClicked
        JF_Menu m = new JF_Menu();

        m.txtUsuarioIniciado.setText(txtUsuarioVentas.getText());

        String usu = txtUsuarioVentas.getText();
        acceder(usu);

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

    private void BtnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPagarActionPerformed

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

            //m.txtUsuarioVentas.setText(txtUsuarioVentas.getText());

        }

    }//GEN-LAST:event_BtnPagarActionPerformed

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
                    datosP cc = new datosP();
                    Connection cn = cc.conexion();

                    PreparedStatement pst = cn.prepareStatement("INSERT INTO orden(Cantidad,"
                            + "Fk_Producto,Fk_Cliente, FK_Estado) VALUES (?,?,?,'3')");

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


    private void BtnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVerificarActionPerformed
        mostrarCliente("");
    }//GEN-LAST:event_BtnVerificarActionPerformed

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

            btnAplicarDescuento.setEnabled(true);

            Calendar c2 = new GregorianCalendar();
            txtFechaFact.setCalendar(c2);

            Calendar fa = new GregorianCalendar();
            txtHora.setCalendar(fa);
        }


    }//GEN-LAST:event_VerSubtotalActionPerformed

    private void tbSubtotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSubtotalMouseClicked

        int seleccionar = tbSubtotal.rowAtPoint(evt.getPoint());
        txtSubTotal.setText(String.valueOf(tbSubtotal.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_tbSubtotalMouseClicked

    private void tbProductoInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductoInventarioMouseClicked
        int seleccionar = tbProductoInventario.rowAtPoint(evt.getPoint());
        txtCodigo.setText(String.valueOf(tbProductoInventario.getValueAt(seleccionar, 1)));

        int seleccionar2 = tbProductoInventario.rowAtPoint(evt.getPoint());
        txtStock.setText(String.valueOf(tbProductoInventario.getValueAt(seleccionar2, 5)));
    }//GEN-LAST:event_tbProductoInventarioMouseClicked

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
                PreparedStatement pst = cn.prepareStatement("UPDATE orden SET Fk_Factura=" + txtCodigoBarras.getText() + ", Fk_Estado = 2 where Fk_Estado = 3");
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

    private void txtUsuarioVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentasActionPerformed

    void acceder(String usuario, String clave) {
        String cap = "";
        String sql = "SELECT * FROM registro_usuario WHERE Usuario='" + usuario + "' && contraseña='" + clave + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("Fk_TipoUsuario");
            }
            if (cap.equals("1")) {

                MontosDescuento();

                JOptionPane.showMessageDialog(null, "Descuento aplicado");

                int posicion = PanelMenuV.getX();
                if (posicion > -1) {
                   // Animacion.Animacion.mover_izquierda(0, -264, 2, 2, PanelMenuV);
                } else {
                   // Animacion.Animacion.mover_derecha(-264, 0, 2, 2, PanelMenuV);
                }

                lblComprobacion.setVisible(false);
                lblusuario.setVisible(false);
                lblcontraseña.setVisible(false);
                BtnIngresar.setVisible(false);
                lblPorcentaje.setVisible(false);
                BtnPorcentaje.setVisible(false);
                txtUsuario.setVisible(false);
                txtContraseña.setVisible(false);
                PanelPermiso.setVisible(false);

                txtUsuario.setText("");
                txtContraseña.setText("");

            } else if (cap.equals("2")) {

                JOptionPane.showMessageDialog(null, "No concedido");
                txtUsuario.setText("");
                txtContraseña.setText("");

            }
            if ((!cap.equals("1")) && (!cap.equals("2"))) {
                JOptionPane.showMessageDialog(this, "No concedido");
                txtUsuario.setText("");
                txtContraseña.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JF_Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void MontosDescuento() {

        int Subtotal = Integer.parseInt(txtSubTotal.getText());
        Double Descuento = Double.parseDouble((String) BtnPorcentaje.getSelectedItem());

        Double Porcentaje;
        Double MontoDescuento;
        Double Impuesto;
        Double TotalPagar;
        Double totalImpuesto;

        Porcentaje = (Descuento / 100);

        Impuesto = (Subtotal * 0.13);

        totalImpuesto = (Subtotal + Impuesto);

        MontoDescuento = (totalImpuesto * Porcentaje);

        TotalPagar = (totalImpuesto - MontoDescuento);

        txtImpuesto.setText("");
        txtDescuento.setText("");
        txtTotalPagar.setText("");

        txtImpuesto.setText("" + Impuesto);
        txtDescuento.setText("" + MontoDescuento);
        txtTotalPagar.setText("" + TotalPagar);

    }


    private void BtnIngresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnIngresarMouseClicked

        String usu = txtUsuario.getText();
        String cla = txtContraseña.getText();
        acceder(usu, cla);


    }//GEN-LAST:event_BtnIngresarMouseClicked

    private void BtnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregar1ActionPerformed

        //        cont = 0;
        //
        //        if (txtCedula.getText().equals("")) {
            //            lblRequeridoCedula.setVisible(true);
            //            cont++;
            //        } else {
            //            lblRequeridoCedula.setVisible(false);
            //
            //        }
        //        if (txtCodigo.getText().equals("")) {
            //            lblRequeridoCodigo.setVisible(true);
            //            cont++;
            //        } else {
            //            lblRequeridoCodigo.setVisible(false);
            //
            //        }
        //
        //        if (txtCantidad.getText().equals("")) {
            //            lblRequerdioCantidad.setVisible(true);
            //            cont++;
            //        } else {
            //            lblRequerdioCantidad.setVisible(false);
            //
            //        }
        //
        //        if (cont == 0) {
            //
            //            int Stock = Integer.parseInt(txtStock.getText());
            //            int Cantidad = Integer.parseInt(txtCantidad.getText());
            //            int NuevoStock;
            //
            //            NuevoStock = (Stock - Cantidad);
            //
            //            if (Stock == 0) {
                //                JOptionPane.showMessageDialog(this, "No hay Stock");
                //                txtCantidad.setText("");
                //
                //            } else if (Cantidad <= Stock) {
                //
                //                try {
                    //                    datosP cc = new datosP();
                    //                    Connection cn = cc.conexion();
                    //
                    //                    PreparedStatement pst = cn.prepareStatement("INSERT INTO orden(Cantidad,"
                        //                        + "Fk_Producto,Fk_Cliente, FK_Estado) VALUES (?,?,?,'3')");
                    //
                    //                    pst.setString(1, txtCantidad.getText());
                    //                    pst.setString(2, txtCodigo.getText());
                    //                    pst.setString(3, txtCedula.getText());
                    //
                    //                    pst.executeUpdate();
                    //
                    //                } catch (Exception e) {
                    //                    System.out.print(e);
                    //                }
                //
                //                try {
                    //                    PreparedStatement pst = cn.prepareStatement("UPDATE producto SET Cantidad=" + NuevoStock + " where Id_Producto = " + txtCodigo.getText() + "");
                    //                    pst.executeUpdate();
                    //
                    //                } catch (Exception e) {
                    //                    System.out.print(e.getMessage());
                    //                }
                //
                //                txtCantidad.setText("");
                //                txtCodigo.setText("");
                //                txtnombre.setText("");
                //
                //                txtSubTotal.setText("");
                //                txtImpuesto.setText("");
                //                txtDescuento.setText("");
                //                txtTotalPagar.setText("");
                //                txtStock.setText("");
                //
                //                mostrarProductosSeleccionados("");
                //
                //                mostrardatoSubtotal("");
                //
                //                mostrarBusquedaProducto("");
                //
                //            } else if (Cantidad > Stock) {
                //
                //                JOptionPane.showMessageDialog(this, "Superas el Stock");
                //                txtCantidad.setText("");
                //
                //            }
            //
            //        }
    }//GEN-LAST:event_BtnAgregar1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregar1;
    private javax.swing.JPanel BtnIRegistrarCliente;
    private javax.swing.JPanel BtnIngresar;
    private javax.swing.JPanel BtnMenu;
    private javax.swing.JLabel BtnMinimizar;
    private javax.swing.JButton BtnPagar;
    private javax.swing.JComboBox<String> BtnPorcentaje;
    private javax.swing.JButton BtnProf;
    private javax.swing.JPanel BtnProforma;
    private javax.swing.JLabel BtnSalir;
    private javax.swing.JButton BtnVerificar;
    private javax.swing.JPanel PanelMenuV;
    public javax.swing.JPanel PanelPermiso;
    private javax.swing.JButton VerSubtotal;
    private javax.swing.JButton btnAplicarDescuento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JLabel lblComprobacion;
    private javax.swing.JLabel lblPorcentaje;
    private javax.swing.JLabel lblRequerdioCantidad;
    private javax.swing.JLabel lblRequeridoCedula;
    private javax.swing.JLabel lblRequeridoCodigo;
    private javax.swing.JLabel lblRequeridoSubtotal;
    private javax.swing.JLabel lblRequeridoTotal;
    private javax.swing.JLabel lblcontraseña;
    private javax.swing.JLabel lblusuario;
    private javax.swing.JTable tbCliente;
    public javax.swing.JTable tbProductoInventario;
    private javax.swing.JTable tbProductosSelec;
    private javax.swing.JTable tbSubtotal;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JPasswordField txtContraseña;
    public javax.swing.JTextField txtDescuento;
    private com.toedter.calendar.JDateChooser txtFechaFact;
    public com.toedter.calendar.JDateChooser txtHora;
    public javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtSubTotal;
    public javax.swing.JTextField txtTotalPagar;
    public javax.swing.JTextField txtUsuario;
    public javax.swing.JTextField txtUsuarioVentas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
  
   /* datosP cc = new datosP();
            Connection cn = cc.conexion();*/
}
