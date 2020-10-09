/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;

import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.jdbc.PreparedStatement;
import database.KoneksiDatabase;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import kontrol.DBUbah;
import kontrol.LoginSession;
import kontrol.Pencarian;
import kontrol.PencarianIntegrasi;
import kontrol.TDModel;

/**
 *
 * @author ASUS PC
 */
public class FormPenerimaanBarang extends javax.swing.JFrame {
    private Pencarian PencarianData = new Pencarian();
    private Connection koneksi = new KoneksiDatabase().KoneksiDatabase();
    private PreparedStatement db_query;
    private Statement state_db = null;
    private ResultSet aksi_db = null;
    private String nama=LoginSession.getUsername();
    public FormPenerimaanBarang() {
        initComponents();
        tanggal();
        txt_user.setText(nama);
        setTabelDataPemesanan(); 
    }
    public void tanggal(){
        Date tggl=new Date();
        SimpleDateFormat simpel=new SimpleDateFormat("yyyy-MM-dd");
        txt_tgl.setText(simpel.format(tggl));
    }
    private void setTabelDataPemesanan(){
        tabel_pemesanan.setModel(new TDModel().Pemesanan(PencarianData));
        tabel_pemesanan.setSelectionMode(0);
        for (int i=0; i<tabel_pemesanan.getColumnCount(); i++){
            tabel_pemesanan.getColumnModel().getColumn(i).setResizable(false);
        }
        tabel_pemesanan.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabel_pemesanan.getTableHeader().setOpaque(false);
        tabel_pemesanan.getTableHeader().setBackground(new Color(232, 67, 147));
        tabel_pemesanan.getTableHeader().setForeground(new Color(255,255,255));
        tabel_pemesanan.setRowHeight(25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int a=0; a<tabel_pemesanan.getColumnCount(); a++)
        {
            tabel_pemesanan.getColumnModel().getColumn(a).setCellRenderer(centerRenderer);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradienpanel1 = new utilities.gradienpanel();
        btn_back = new javax.swing.JLabel();
        txt_tgl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_x = new javax.swing.JLabel();
        txt_user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_pemesanan = new javax.swing.JTable();
        cari_kolom = new javax.swing.JComboBox();
        btn_tambah = new utilities.gradienbtn();
        cari_data = new rojeru_san.RSMTextFull();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 820));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1360, 820));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradienpanel1.setkEndColor(new java.awt.Color(108, 92, 231));
        gradienpanel1.setkStartColor(new java.awt.Color(232, 67, 147));
        gradienpanel1.setPreferredSize(new java.awt.Dimension(1360, 280));

        btn_back.setFont(new java.awt.Font("Wide Latin", 1, 36)); // NOI18N
        btn_back.setForeground(new java.awt.Color(223, 230, 233));
        btn_back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_back.setText("<");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
        });

        txt_tgl.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txt_tgl.setForeground(new java.awt.Color(223, 230, 233));
        txt_tgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_tgl.setText("tanggal");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(223, 230, 233));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo_11.png"))); // NOI18N

        btn_x.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        btn_x.setForeground(new java.awt.Color(223, 230, 233));
        btn_x.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_x.setText("X");
        btn_x.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_xMousePressed(evt);
            }
        });

        txt_user.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        txt_user.setForeground(new java.awt.Color(223, 230, 233));
        txt_user.setText("username");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(223, 230, 233));
        jLabel5.setText("Nama User : ");

        javax.swing.GroupLayout gradienpanel1Layout = new javax.swing.GroupLayout(gradienpanel1);
        gradienpanel1.setLayout(gradienpanel1Layout);
        gradienpanel1Layout.setHorizontalGroup(
            gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradienpanel1Layout.createSequentialGroup()
                .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gradienpanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(87, 87, 87)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradienpanel1Layout.createSequentialGroup()
                        .addComponent(btn_x, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(txt_tgl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        gradienpanel1Layout.setVerticalGroup(
            gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradienpanel1Layout.createSequentialGroup()
                .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(gradienpanel1Layout.createSequentialGroup()
                        .addComponent(btn_x, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gradienpanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gradienpanel1Layout.createSequentialGroup()
                                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        getContentPane().add(gradienpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 290));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1360, 770));
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 770));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Kategori");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 692, 121, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(65, 31));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 693, 205, -1));

        tabel_pemesanan.setBackground(new java.awt.Color(255, 255, 255));
        tabel_pemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Pemesanan", "Kode Barang", "Nama Barang", "Jumlah Beli", "Kategori", "Tanggal"
            }
        ));
        tabel_pemesanan.setGridColor(new java.awt.Color(255, 255, 255));
        tabel_pemesanan.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_pemesanan.setName(""); // NOI18N
        tabel_pemesanan.setSelectionBackground(new java.awt.Color(232, 67, 147));
        tabel_pemesanan.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabel_pemesanan.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tabel_pemesanan);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 1250, 275));

        cari_kolom.setBackground(new java.awt.Color(255, 255, 255));
        cari_kolom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Pemesanan", "Kode Barang", "Nama Barang" }));
        cari_kolom.setFocusable(false);
        cari_kolom.setPreferredSize(new java.awt.Dimension(78, 25));
        jPanel1.add(cari_kolom, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 170, 41));

        btn_tambah.setBorder(null);
        btn_tambah.setText("Konfirmasi");
        btn_tambah.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_tambah.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_tambah.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_tambah.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_tambah.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_tambah.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });
        jPanel1.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, 330, -1));

        cari_data.setBackground(new java.awt.Color(255, 255, 255));
        cari_data.setPlaceholder("Cari Data");
        cari_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cari_dataKeyReleased(evt);
            }
        });
        jPanel1.add(cari_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 240, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 289, -1, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        FormHome Home = new FormHome();
        Home.setLocationRelativeTo(null);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_xMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMousePressed
        int ok = JOptionPane.showConfirmDialog(null,
            "Apakah anda yakin ingin keluar?",
            "WARNING!!!",
            JOptionPane.YES_NO_OPTION);
        if(ok==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_xMousePressed

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        if(tabel_pemesanan.getSelectedRowCount()>0){
            String $kode_pemesanan=String.valueOf(tabel_pemesanan.getValueAt(tabel_pemesanan.getSelectedRow(),0));
            String $kode_barang=String.valueOf(tabel_pemesanan.getValueAt(tabel_pemesanan.getSelectedRow(),1));
            int jumlah_beli=Integer.parseInt(String.valueOf(tabel_pemesanan.getValueAt(tabel_pemesanan.getSelectedRow(),3)));
            int stok=Integer.parseInt(new PencarianIntegrasi().getTunggal("tabel_stok", "kode", $kode_barang, "stok"));
            int hasil_jumlah=jumlah_beli-jumlah_beli;
            int hasil_stok=stok+jumlah_beli;
            new DBUbah().PemesananJumlah($kode_pemesanan,
                    hasil_jumlah);
            new DBUbah().StokJumlah(
                    $kode_barang, 
                    hasil_stok);
            setTabelDataPemesanan(); 
        }else{
            JOptionPane.showMessageDialog(null, "Tidak ada data yang anda pilih");
        }
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void cari_dataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_dataKeyReleased
        if ("Kode Pemesanan".equalsIgnoreCase(cari_kolom.getSelectedItem().toString())){
            PencarianData.setPencarianKolom("kode_pemesanan");
            PencarianData.setPencarianData(cari_data.getText().trim());
            PencarianData.setPencarianKondisi(true);
            setTabelDataPemesanan();
        }
        if ("Kode Barang".equalsIgnoreCase(cari_kolom.getSelectedItem().toString())){
            PencarianData.setPencarianKolom("kode_barang");
            PencarianData.setPencarianData(cari_data.getText().trim());
            PencarianData.setPencarianKondisi(true);
            setTabelDataPemesanan();
        }
        if ("Nama Barang".equalsIgnoreCase(cari_kolom.getSelectedItem().toString())){
            PencarianData.setPencarianKolom("nama_barang");
            PencarianData.setPencarianData(cari_data.getText().trim());
            PencarianData.setPencarianKondisi(true);
            setTabelDataPemesanan();
        }
    }//GEN-LAST:event_cari_dataKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private utilities.gradienbtn btn_tambah;
    private javax.swing.JLabel btn_x;
    private rojeru_san.RSMTextFull cari_data;
    private javax.swing.JComboBox cari_kolom;
    private utilities.gradienpanel gradienpanel1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_pemesanan;
    private javax.swing.JLabel txt_tgl;
    private javax.swing.JLabel txt_user;
    // End of variables declaration//GEN-END:variables
}
