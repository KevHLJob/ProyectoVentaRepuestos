/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;
import Conexion.Conexion_k;
import Inventario.JF_Inventario;
import Menu.JF_Menu;
import javax.swing.JOptionPane;
import Conexion.Conexion_k;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author justi
 */
public class JF_AgregarProducto extends javax.swing.JFrame {
 ResultSet rs;
        PreparedStatement pst;
        Conexion_k con= new Conexion_k();
    /**
     * Creates new form JF_AgregarUsuario
     */
    public JF_AgregarProducto() {
        initComponents();
        
               mostrarProducto("");
        mostrarProveedor("");

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
        Btnproveedor = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Btninventario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Btnmenu = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtUsuarioVentas3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtIdbuscar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btneditar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnagregar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        btneliminar = new javax.swing.JButton();
        lblRequeridoCantidad = new javax.swing.JLabel();
        lblRequeridoNombreP = new javax.swing.JLabel();
        lblRequeridoPrecio = new javax.swing.JLabel();
        lblRequeridoBusqueda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbpresentacion = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbProducto = new javax.swing.JTable();
        txtProducto = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbProveedor = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnAgregarinventario = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblRequeridoProvee = new javax.swing.JLabel();
        lblRequeridoCodigoPro = new javax.swing.JLabel();
        Btnproducto = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        Btnproveedor.setBackground(new java.awt.Color(153, 153, 153));
        Btnproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnproveedorMouseClicked(evt);
            }
        });
        Btnproveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(67, 81, 141));
        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Proveedor");
        Btnproveedor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

        Btninventario.setBackground(new java.awt.Color(153, 153, 153));
        Btninventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtninventarioMouseClicked(evt);
            }
        });
        Btninventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(67, 81, 141));
        jLabel15.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Inventario");
        Btninventario.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        Btnmenu.setBackground(new java.awt.Color(153, 153, 153));
        Btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnmenuMouseClicked(evt);
            }
        });
        Btnmenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setBackground(new java.awt.Color(67, 81, 141));
        jLabel16.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Menu");
        Btnmenu.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 30));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuarioVentas3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Btnproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(83, Short.MAX_VALUE)
                    .addComponent(Btninventario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(txtUsuarioVentas3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(Btnmenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172)
                .addComponent(Btnproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(277, 277, 277))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(361, Short.MAX_VALUE)
                    .addComponent(Btninventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(362, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 753));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("Agregar Producto");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(jLabel4)
                .addContainerGap(445, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(283, 0, 1070, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setForeground(new java.awt.Color(0, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Información de producto");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Producto");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, -1, -1));
        jPanel4.add(txtnombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Precio ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));
        jPanel4.add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Herramientas");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));
        jPanel4.add(txtIdbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 140, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Nombre");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jPanel9.setBackground(new java.awt.Color(204, 204, 255));

        btnbuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 150, -1));

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        btneditar.setBackground(new java.awt.Color(204, 204, 255));
        btneditar.setText("Editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneditar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 150, 30));

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        btnagregar.setBackground(new java.awt.Color(204, 204, 255));
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 150, 30));

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        btneliminar.setBackground(new java.awt.Color(204, 204, 255));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 150, 30));

        lblRequeridoCantidad.setForeground(new java.awt.Color(255, 51, 51));
        lblRequeridoCantidad.setText("Requerido");
        jPanel4.add(lblRequeridoCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        lblRequeridoNombreP.setBackground(new java.awt.Color(255, 255, 255));
        lblRequeridoNombreP.setForeground(new java.awt.Color(255, 51, 51));
        lblRequeridoNombreP.setText("Requerido");
        jPanel4.add(lblRequeridoNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        lblRequeridoPrecio.setForeground(new java.awt.Color(255, 0, 0));
        lblRequeridoPrecio.setText("Requerido");
        jPanel4.add(lblRequeridoPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        lblRequeridoBusqueda.setForeground(new java.awt.Color(255, 51, 51));
        lblRequeridoBusqueda.setText("Requerido");
        jPanel4.add(lblRequeridoBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Presentación");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        cbpresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad", "Galon", "Accesorio" }));
        jPanel4.add(cbpresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 140, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 730, 360));

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setForeground(new java.awt.Color(0, 102, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Producto");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 19, -1, -1));

        TbProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbProductoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbProducto);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 97, 240, 180));

        txtProducto.setEditable(false);
        jPanel6.add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 68, 93, -1));

        txtProveedor.setEditable(false);
        jPanel6.add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 333, 86, -1));

        TbProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbProveedor);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 362, 240, 150));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Proveedor");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 285, -1, -1));

        jLabel10.setText("Código");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 71, -1, -1));

        jLabel11.setText("Código");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 336, -1, -1));

        btnAgregarinventario.setBackground(new java.awt.Color(51, 255, 51));
        btnAgregarinventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarinventarioMouseClicked(evt);
            }
        });

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Añadir Inventario");

        javax.swing.GroupLayout btnAgregarinventarioLayout = new javax.swing.GroupLayout(btnAgregarinventario);
        btnAgregarinventario.setLayout(btnAgregarinventarioLayout);
        btnAgregarinventarioLayout.setHorizontalGroup(
            btnAgregarinventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarinventarioLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        btnAgregarinventarioLayout.setVerticalGroup(
            btnAgregarinventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAgregarinventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.add(btnAgregarinventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 210, -1));

        lblRequeridoProvee.setForeground(new java.awt.Color(255, 51, 51));
        lblRequeridoProvee.setText("Requerido");
        jPanel6.add(lblRequeridoProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 314, -1, -1));

        lblRequeridoCodigoPro.setForeground(new java.awt.Color(255, 51, 51));
        lblRequeridoCodigoPro.setText("Requerido");
        jPanel6.add(lblRequeridoCodigoPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 48, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 110, 260, 570));

        Btnproducto.setBackground(new java.awt.Color(153, 153, 153));
        Btnproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnproductoMouseClicked(evt);
            }
        });
        Btnproducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(67, 81, 141));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Producto");
        Btnproducto.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 30));

        jPanel1.add(Btnproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    public void mostrarProducto(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");

        TbProducto.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Id_Producto, Nombre FROM producto";

        }
        String[] datos = new String[6];
        try {
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                modelo.addRow(datos);
            }
            TbProducto.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarProveedor(String valor) {

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");

        TbProveedor.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Id_Proveedor, NombreProveedor FROM proveedor";

        }
        String[] datos = new String[2];
        try {
            Statement st = con.conexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);

                modelo.addRow(datos);
            }
            TbProveedor.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
            // Logger.getLogger(ingresoproductos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void TbProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProductoMouseClicked
        int seleccionar = TbProducto.rowAtPoint(evt.getPoint());
        txtProducto.setText(String.valueOf(TbProducto.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_TbProductoMouseClicked

    private void TbProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProveedorMouseClicked
        int seleccionar = TbProveedor.rowAtPoint(evt.getPoint());
        txtProveedor.setText(String.valueOf(TbProveedor.getValueAt(seleccionar, 0)));
    }//GEN-LAST:event_TbProveedorMouseClicked

    private void BtnproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnproductoMouseClicked
        JF_AgregarProducto p = new JF_AgregarProducto();
        p.setVisible(true);
        dispose();

        // p.txtUsuarioProducto.setText(txtUsuarioProveedor.getText());
    }//GEN-LAST:event_BtnproductoMouseClicked

    private void BtninventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtninventarioMouseClicked
        JF_Inventario i = new JF_Inventario();
        i.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtninventarioMouseClicked

    private void BtnproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnproveedorMouseClicked
        JF_Provedor p = new JF_Provedor();
        p.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnproveedorMouseClicked

    private void BtnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnmenuMouseClicked
        JF_Menu m = new JF_Menu();
        m.setVisible(true);
        dispose();
    }//GEN-LAST:event_BtnmenuMouseClicked

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

        try {
            pst = con.conexion().prepareStatement("INSERT INTO producto (Nombre,Presentacion,PrecioUnitario,Cantidad) "
                    + "VALUES(?,?,?,?)");
            pst.setString(1, txtnombre1.getText());

            int seleccion = cbpresentacion.getSelectedIndex();
            pst.setString(2, cbpresentacion.getItemAt(seleccion));

            pst.setInt(3, Integer.parseInt(txtprecio.getText()));
            pst.setInt(4, Integer.parseInt(txtCantidad.getText()));
            pst.execute();
            //Limpiar();
            JOptionPane.showMessageDialog(null, "Producto guardado");

            con.Desconectar();
        } catch (Exception e) {

        }
        mostrarProducto("");
        mostrarProveedor("");
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        try {
            pst = con.conexion().prepareStatement("SELECT * FROM producto WHERE Id_Producto=?");
            pst.setInt(1, Integer.parseInt(txtIdbuscar.getText()));

            rs = pst.executeQuery();

            if (rs.next()) {
                txtnombre1.setText(rs.getString("Nombre"));
                cbpresentacion.setSelectedItem(rs.getString("Presentacion"));
                txtprecio.setText(rs.getString("PrecioUnitario"));
                txtCantidad.setText(rs.getString("Cantidad"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe un producto con el codigo ingresado...");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar producto: " + e);
        }
        mostrarProducto("");
        mostrarProveedor("");

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed

        
        try {
            //CONSULTA PARA LA MODIFICACIÓN
            pst = con.conexion().prepareStatement("UPDATE producto SET Nombre=?,Presentacion=?,PrecioUnitario=?,Cantidad=? WHERE Id_Producto=? ");
            // 

            pst.setString(1, txtnombre1.getText());
            int seleccion = cbpresentacion.getSelectedIndex();
            pst.setString(2, cbpresentacion.getItemAt(seleccion));

            pst.setInt(3, Integer.parseInt(txtprecio.getText()));
            pst.setInt(4, Integer.parseInt(txtCantidad.getText()));
            pst.setInt(5, Integer.parseInt(txtIdbuscar.getText()));
            pst.execute();

            JOptionPane.showMessageDialog(null, "Producto Modificado");

            con.Desconectar();
            Limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Modificar producto: " + e);
        }
        mostrarProducto("");
        mostrarProveedor("");
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        try {
            pst = con.conexion().prepareStatement("DELETE FROM producto WHERE Id_Producto=?");
            pst.setInt(1, Integer.parseInt(txtIdbuscar.getText()));

            pst.execute();

            JOptionPane.showMessageDialog(null, "Producto Eliminado");

            con.Desconectar();
            Limpiar();
        } catch (Exception e) {
            System.err.println("Error al eliminar el producto " + e);

        }
        mostrarProducto("");
        mostrarProveedor("");
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnAgregarinventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarinventarioMouseClicked
       try {
                //consulta de insercion al inventario
                pst = con.conexion().prepareStatement("INSERT INTO inventario (Fk_Productos,Fk_Proveedor) "
                        + "VALUES(?,?)");

                //Parametros que voy a introducir...
                pst.setInt(1, Integer.parseInt(txtProducto.getText()));
                pst.setInt(2, Integer.parseInt(txtProveedor.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "Agregado a Inventario");

                txtProducto.setText("");
                txtProveedor.setText("");

                con.Desconectar();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al Ingresar en Inventario: " + e);
            }
    }//GEN-LAST:event_btnAgregarinventarioMouseClicked

    private void txtUsuarioVentas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioVentas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioVentas3ActionPerformed

    private void Limpiar() {
        txtnombre1.setText("");
        txtprecio.setText("");
        txtIdbuscar.setText("");
        txtCantidad.setText("");
    }

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
            java.util.logging.Logger.getLogger(JF_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_AgregarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btninventario;
    private javax.swing.JPanel Btnmenu;
    private javax.swing.JPanel Btnproducto;
    private javax.swing.JPanel Btnproveedor;
    private javax.swing.JTable TbProducto;
    private javax.swing.JTable TbProveedor;
    private javax.swing.JPanel btnAgregarinventario;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JComboBox<String> cbpresentacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRequeridoBusqueda;
    private javax.swing.JLabel lblRequeridoCantidad;
    private javax.swing.JLabel lblRequeridoCodigoPro;
    private javax.swing.JLabel lblRequeridoNombreP;
    private javax.swing.JLabel lblRequeridoPrecio;
    private javax.swing.JLabel lblRequeridoProvee;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdbuscar;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProveedor;
    public javax.swing.JTextField txtUsuarioVentas3;
    private javax.swing.JTextField txtnombre1;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
