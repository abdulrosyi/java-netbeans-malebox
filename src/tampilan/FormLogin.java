package tampilan;

import com.formdev.flatlaf.FlatLightLaf;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import kontrol.CekLogin;
import kontrol.DBSimpan;

public class FormLogin extends javax.swing.JFrame {
    public FormLogin() {
        initComponents();
        panel_daftar.setVisible(false);
        panel_login.setVisible(true);
    }
    private static String random(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }
         
        return sb.toString();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_daftar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_namaD = new rojeru_san.RSMTextFull();
        txt_passwordD = new rojeru_san.RSMPassView();
        btn_batal = new utilities.gradienbtn();
        btn_daptar = new utilities.gradienbtn();
        panel_login = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_nama = new rojeru_san.RSMTextFull();
        txt_password = new rojeru_san.RSMPassView();
        btn_exit = new utilities.gradienbtn();
        btn_login = new utilities.gradienbtn();
        btn_daftar = new rojeru_san.RSButton();
        gradienpanel1 = new utilities.gradienpanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_daftar.setBackground(new java.awt.Color(255, 255, 255));
        panel_daftar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 112, 192));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("daftar");
        panel_daftar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 110, 50));

        txt_namaD.setBackground(new java.awt.Color(255, 255, 255));
        txt_namaD.setPlaceholder("Masukkan Nama Pengguna");
        panel_daftar.add(txt_namaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, -1));

        txt_passwordD.setBackground(new java.awt.Color(255, 255, 255));
        txt_passwordD.setPlaceholder("Masukkan Password");
        panel_daftar.add(txt_passwordD, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 400, -1));

        btn_batal.setBorder(null);
        btn_batal.setText("BATAL");
        btn_batal.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        btn_batal.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_batal.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_batal.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_batal.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_batal.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_batal.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });
        panel_daftar.add(btn_batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        btn_daptar.setBorder(null);
        btn_daptar.setText("DAFTAR");
        btn_daptar.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        btn_daptar.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_daptar.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_daptar.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_daptar.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_daptar.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_daptar.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_daptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daptarActionPerformed(evt);
            }
        });
        panel_daftar.add(btn_daptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jPanel1.add(panel_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 490, 510));

        panel_login.setBackground(new java.awt.Color(255, 255, 255));
        panel_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 112, 192));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
        panel_login.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 110, 50));

        txt_nama.setBackground(new java.awt.Color(255, 255, 255));
        txt_nama.setPlaceholder("Masukkan Nama Pengguna");
        panel_login.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 400, -1));

        txt_password.setBackground(new java.awt.Color(255, 255, 255));
        txt_password.setPlaceholder("Masukkan Password");
        txt_password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passwordFocusGained(evt);
            }
        });
        panel_login.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 400, -1));

        btn_exit.setBorder(null);
        btn_exit.setText("KELUAR");
        btn_exit.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        btn_exit.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_exit.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_exit.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_exit.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_exit.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_exit.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        panel_login.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, -1, -1));

        btn_login.setBorder(null);
        btn_login.setText("LOGIN");
        btn_login.setFont(new java.awt.Font("Impact", 1, 18)); // NOI18N
        btn_login.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_login.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_login.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_login.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_login.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_login.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        panel_login.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        btn_daftar.setBackground(new java.awt.Color(255, 255, 255));
        btn_daftar.setBorder(null);
        btn_daftar.setForeground(new java.awt.Color(102, 102, 102));
        btn_daftar.setText("Daftar");
        btn_daftar.setColorHover(new java.awt.Color(255, 255, 255));
        btn_daftar.setColorText(new java.awt.Color(102, 102, 102));
        btn_daftar.setColorTextHover(new java.awt.Color(67, 150, 209));
        btn_daftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_daftarActionPerformed(evt);
            }
        });
        panel_login.add(btn_daftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        jPanel1.add(panel_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 490, 510));

        gradienpanel1.setkEndColor(new java.awt.Color(0, 112, 192));
        gradienpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(223, 230, 233));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo1.png"))); // NOI18N
        gradienpanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 490));

        jPanel1.add(gradienpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 510));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 510));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
         ArrayList<String> kesalahan = new ArrayList<String>();
        kesalahan.add("KESALAHAN !");
        if (txt_nama.getText().trim().isEmpty())
            kesalahan.add("Username tidak dapat di kosongkan.");
        if (txt_password.getText().trim().isEmpty())
            kesalahan.add("Password tidak dapat di kosongkan.");
         String password = null;
        try {
            password = random(Arrays.toString(txt_password.getPassword()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (kesalahan.size()<=1){
            if (!new CekLogin().CekLogin(txt_nama.getText().trim(), password))
                JOptionPane.showMessageDialog(null, "User dan Password tidak cocok !");
            else{
                dispose();
                FormHome Home = new FormHome();
                Home.setLocationRelativeTo(null);
                Home.setVisible(true);
            }
        }else
            JOptionPane.showMessageDialog(null, kesalahan.toArray());
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_daftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daftarActionPerformed
        panel_login.setVisible(false);
        panel_daftar.setVisible(true);
    }//GEN-LAST:event_btn_daftarActionPerformed

    private void txt_passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passwordFocusGained
        txt_password.setText("");
    }//GEN-LAST:event_txt_passwordFocusGained

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        panel_daftar.setVisible(false);
        panel_login.setVisible(true);
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_daptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_daptarActionPerformed
        ArrayList<String> kesalahan = new ArrayList<String>();
        kesalahan.add("KESALAHAN !");
        if (txt_namaD.getText().trim().isEmpty())
            kesalahan.add("Nama tidak dapat dikosongkan.");
        if(txt_passwordD.getText().trim().isEmpty())
            kesalahan.add("Password tidak dapat dikosongkan");
        String nama = txt_namaD.getText().trim();
        String password = Arrays.toString(txt_passwordD.getPassword());
        if (kesalahan.size()<=1){
            try {
            password = random(Arrays.toString(txt_passwordD.getPassword()));
            } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
              }
            new DBSimpan().Login(
                    nama,
                    password);
            panel_daftar.setVisible(false);
            panel_login.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, kesalahan.toArray());
        }
    }//GEN-LAST:event_btn_daptarActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
                javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
            }catch(Exception e){
                System.err.println("Failed instal theme");
            }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private utilities.gradienbtn btn_batal;
    private rojeru_san.RSButton btn_daftar;
    private utilities.gradienbtn btn_daptar;
    private utilities.gradienbtn btn_exit;
    private utilities.gradienbtn btn_login;
    private utilities.gradienpanel gradienpanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_daftar;
    private javax.swing.JPanel panel_login;
    private rojeru_san.RSMTextFull txt_nama;
    private rojeru_san.RSMTextFull txt_namaD;
    private rojeru_san.RSMPassView txt_password;
    private rojeru_san.RSMPassView txt_passwordD;
    // End of variables declaration//GEN-END:variables
}
