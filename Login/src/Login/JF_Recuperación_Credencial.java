package Login;

import Conexion.datosP;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JF_Recuperación_Credencial extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public JF_Recuperación_Credencial() {
        initComponents();
        setLocationRelativeTo(null);
    }

    void mostrarusu(String valor) {

        modelo.addColumn("User");
        modelo.addColumn("Pass");

        tbusu.setModel(modelo);
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT Usuario, Contraseña FROM `registro_usuario` WHERE CorreoElectronico ='" + txtCorreoEnviar.getText() + "'";

        }
        String[] datos = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                txtusu.setText(datos[0] = rs.getString(1));
                txtpass.setText(datos[1] = rs.getString(2));

                modelo.addRow(datos);
            }
            tbusu.setModel(modelo);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtusu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbusu = new javax.swing.JTable();
        txtpass = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreoEnviar = new javax.swing.JTextField();
        BtnEnviarCorreo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        tbusu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbusu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbusuKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbusu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("INICIAR SESIÓN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Auto repuestos k&j2.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel2)
                .addGap(104, 104, 104)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(447, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 890));

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1610, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1610, 90));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Por favor ingrese su correo electrónico ");

        txtCorreoEnviar.setBackground(new java.awt.Color(245, 245, 245));
        txtCorreoEnviar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        txtCorreoEnviar.setBorder(null);

        BtnEnviarCorreo.setBackground(new java.awt.Color(0, 0, 0));
        BtnEnviarCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnEnviarCorreoMouseClicked(evt);
            }
        });
        BtnEnviarCorreo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 102, 102));
        jLabel11.setText("Enviar");
        BtnEnviarCorreo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 80, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtCorreoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(BtnEnviarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(txtCorreoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(BtnEnviarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 720, 280));

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel3.setText("Recuperar Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnviarCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnEnviarCorreoMouseClicked

        mostrarusu("");

        try {

            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

          String correoRemitente = "autorepuestoskj@gmail.com";
            String passwordRemitente = "autoskyj";
            String correoReceptor = txtCorreoEnviar.getText();
            String asunto = "Recuperación de usuario y contraseña";
            String mensaje = "Su Usuario es: " + txtusu.getText() + "  // Su Contraseña es: " + txtpass.getText();

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje, "ISO-8859-1", "html");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();

            JOptionPane.showMessageDialog(null, "Correo Electronico Enviado");

        } catch (AddressException ex) {
            Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtCorreoEnviar.setText("");

    }//GEN-LAST:event_BtnEnviarCorreoMouseClicked

    private void tbusuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbusuKeyPressed

    }//GEN-LAST:event_tbusuKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        JF_Login l = new JF_Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_Recuperación_Credencial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_Recuperación_Credencial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BtnEnviarCorreo;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tbusu;
    public javax.swing.JTextField txtCorreoEnviar;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtusu;
    // End of variables declaration//GEN-END:variables

    datosP cc = new datosP();
    Connection cn = cc.conexion();
}
