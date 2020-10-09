package tampilan;

import database.KoneksiDatabase;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import kontrol.LoginSession;
import kontrol.Pencarian;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormHome extends javax.swing.JFrame {
    private Pencarian PencarianData = new Pencarian();
    private HashMap HM;
    private com.mysql.jdbc.Connection koneksi = (com.mysql.jdbc.Connection) new KoneksiDatabase().KoneksiDatabase();
    String nama=LoginSession.getUsername();
    public FormHome() {
        initComponents();
        initUI();
        tanggal();
        txt_user.setText(nama);
    }
    
    private void initUI(){ 
        getContentPane().setBackground(new Color(245, 245, 245));
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
    public void tanggal(){
        Date tggl=new Date();
        SimpleDateFormat simpel=new SimpleDateFormat("dd-MM-yyyy");
        txt_tgl.setText(simpel.format(tggl));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_laporan = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        btn_cetak = new rojeru_san.RSButton();
        combo_cetak = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btn_keluar = new rojeru_san.RSButton();
        gradienpanel1 = new utilities.gradienpanel();
        txt_tgl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_x = new javax.swing.JLabel();
        txt_user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panel_stok = new javax.swing.JPanel();
        btn_stok = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panel_penjualan = new javax.swing.JPanel();
        btn_laporan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel_laporan = new javax.swing.JPanel();
        btn_penjualan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel_barangmasuk = new javax.swing.JPanel();
        btn_stok1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panel_penerimaan = new javax.swing.JPanel();
        btn_penjualan1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        form_laporan.setBackground(new java.awt.Color(255, 255, 255));
        form_laporan.setMinimumSize(new java.awt.Dimension(435, 470));
        form_laporan.setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(680, 561));
        jPanel2.setPreferredSize(new java.awt.Dimension(680, 561));

        btn_cetak.setBorder(null);
        btn_cetak.setText("CETAK");
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });

        combo_cetak.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Kasir", "Pemesanan Barang", "Stok Barang", "Penjualan" }));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CETAK LAPORAN");

        btn_keluar.setBorder(null);
        btn_keluar.setText("KELUAR");
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_cetak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(combo_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout form_laporanLayout = new javax.swing.GroupLayout(form_laporan.getContentPane());
        form_laporan.getContentPane().setLayout(form_laporanLayout);
        form_laporanLayout.setHorizontalGroup(
            form_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_laporanLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        form_laporanLayout.setVerticalGroup(
            form_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 770));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradienpanel1.setkEndColor(new java.awt.Color(108, 92, 231));
        gradienpanel1.setkStartColor(new java.awt.Color(232, 67, 147));
        gradienpanel1.setPreferredSize(new java.awt.Dimension(1360, 280));

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
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, gradienpanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(gradienpanel1Layout.createSequentialGroup()
                        .addComponent(btn_x, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(gradienpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        getContentPane().add(gradienpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 290));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panel_stok.setBackground(new java.awt.Color(255, 255, 255));
        panel_stok.setForeground(new java.awt.Color(51, 51, 51));
        panel_stok.setToolTipText("");
        panel_stok.setPreferredSize(new java.awt.Dimension(205, 205));
        panel_stok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_stokMouseClicked(evt);
            }
        });

        btn_stok.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_stok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_stok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/databarang.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DATA BARANG");

        javax.swing.GroupLayout panel_stokLayout = new javax.swing.GroupLayout(panel_stok);
        panel_stok.setLayout(panel_stokLayout);
        panel_stokLayout.setHorizontalGroup(
            panel_stokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stokLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel_stokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_stok, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panel_stokLayout.setVerticalGroup(
            panel_stokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stokLayout.createSequentialGroup()
                .addComponent(btn_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_penjualan.setBackground(new java.awt.Color(255, 255, 255));
        panel_penjualan.setPreferredSize(new java.awt.Dimension(205, 205));
        panel_penjualan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_penjualanMouseClicked(evt);
            }
        });

        btn_laporan.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_laporan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/transaksi.png"))); // NOI18N
        btn_laporan.setPreferredSize(new java.awt.Dimension(75, 75));

        jLabel3.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TRANSAKSI");

        javax.swing.GroupLayout panel_penjualanLayout = new javax.swing.GroupLayout(panel_penjualan);
        panel_penjualan.setLayout(panel_penjualanLayout);
        panel_penjualanLayout.setHorizontalGroup(
            panel_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_penjualanLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panel_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        panel_penjualanLayout.setVerticalGroup(
            panel_penjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_penjualanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        panel_laporan.setBackground(new java.awt.Color(255, 255, 255));
        panel_laporan.setPreferredSize(new java.awt.Dimension(205, 205));
        panel_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_laporanMouseClicked(evt);
            }
        });

        btn_penjualan.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_penjualan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_penjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/laporan.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LAPORAN");

        javax.swing.GroupLayout panel_laporanLayout = new javax.swing.GroupLayout(panel_laporan);
        panel_laporan.setLayout(panel_laporanLayout);
        panel_laporanLayout.setHorizontalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_laporanLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(btn_penjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        panel_laporanLayout.setVerticalGroup(
            panel_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_laporanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );

        panel_barangmasuk.setBackground(new java.awt.Color(255, 255, 255));
        panel_barangmasuk.setForeground(new java.awt.Color(51, 51, 51));
        panel_barangmasuk.setToolTipText("");
        panel_barangmasuk.setPreferredSize(new java.awt.Dimension(205, 205));
        panel_barangmasuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_barangmasukMouseClicked(evt);
            }
        });

        btn_stok1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_stok1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_stok1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pemesanan.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PEMESANAN");

        javax.swing.GroupLayout panel_barangmasukLayout = new javax.swing.GroupLayout(panel_barangmasuk);
        panel_barangmasuk.setLayout(panel_barangmasukLayout);
        panel_barangmasukLayout.setHorizontalGroup(
            panel_barangmasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barangmasukLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panel_barangmasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(btn_stok1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panel_barangmasukLayout.setVerticalGroup(
            panel_barangmasukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_barangmasukLayout.createSequentialGroup()
                .addComponent(btn_stok1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        panel_penerimaan.setBackground(new java.awt.Color(255, 255, 255));
        panel_penerimaan.setPreferredSize(new java.awt.Dimension(205, 205));
        panel_penerimaan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel_penerimaanMouseClicked(evt);
            }
        });

        btn_penjualan1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btn_penjualan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_penjualan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/penerimaan.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("PENERIMAAN");

        javax.swing.GroupLayout panel_penerimaanLayout = new javax.swing.GroupLayout(panel_penerimaan);
        panel_penerimaan.setLayout(panel_penerimaanLayout);
        panel_penerimaanLayout.setHorizontalGroup(
            panel_penerimaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_penerimaanLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(panel_penerimaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(btn_penjualan1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        panel_penerimaanLayout.setVerticalGroup(
            panel_penerimaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_penerimaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_penjualan1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(panel_barangmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(panel_stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(panel_penerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189)
                        .addComponent(panel_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_barangmasuk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_penerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_laporan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_penjualan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 286, 1360, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panel_stokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_stokMouseClicked
        FormBarang Stock = new FormBarang();
        Stock.setLocationRelativeTo(null);
        Stock.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panel_stokMouseClicked

    private void btn_xMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMousePressed
        int ok = JOptionPane.showConfirmDialog(null,
            "Apakah anda yakin ingin keluar?",
            "WARNING!!!",
            JOptionPane.YES_NO_OPTION);
        if(ok==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_xMousePressed

    private void panel_penjualanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_penjualanMouseClicked
        FormTransaksi Transaksi = new FormTransaksi();
        Transaksi.setLocationRelativeTo(null);
        Transaksi.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panel_penjualanMouseClicked

    private void panel_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_laporanMouseClicked
        form_laporan.setLocationRelativeTo(null);
        form_laporan.setVisible(true);
    }//GEN-LAST:event_panel_laporanMouseClicked

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
       form_laporan.setVisible(false);
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        String id_laporan = combo_cetak.getSelectedItem().toString();
        switch (id_laporan) {
            case "Pilih":
                JOptionPane.showMessageDialog(null, "Harap Pilih Laporan Yang Ingin Dicetak");
                break;
            case "Kasir":
                try{
                HM=new HashMap();
                HM.put("namakasir", nama);    
                String FL=("./src/laporan/LaporanKasir.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(FL);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, koneksi);
                JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e) {
                    JOptionPane.showMessageDialog(null, "Error " + e);
                    }
                break;
            case "Pemesanan Barang":
                try{
                    HM=new HashMap();
                    HM.put("namakasir", nama); 
                    String FL=("./src/laporan/LaporanPemesanan.jrxml");
                    JasperDesign jasperDesign = JRXmlLoader.load(FL);
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, koneksi);
                    JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e){
                    JOptionPane.showMessageDialog(null, "Error " + e);
                }
            case "Stok Barang":
                try{
                HM=new HashMap();
                HM.put("namakasir",nama);
                String FL=("./src/laporan/LaporanStokBarang.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(FL);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, koneksi);
                JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    }
                    break;
            case "Penjualan":
                try{
                HM=new HashMap();
                HM.put("namakasir", nama);
                String FL=("./src/laporan/LaporanPenjualan.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(FL);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, koneksi);
                JasperViewer.viewReport(jasperPrint, false);
                }catch (JRException e){
                    JOptionPane.showMessageDialog(null,"Error "+e);
                }
        }
        
    }//GEN-LAST:event_btn_cetakActionPerformed

    private void panel_barangmasukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_barangmasukMouseClicked
        FormPemesananBarang barangMasuk=new FormPemesananBarang();
        barangMasuk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panel_barangmasukMouseClicked

    private void panel_penerimaanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_penerimaanMouseClicked
        FormPenerimaanBarang terimaBarang=new FormPenerimaanBarang();
        terimaBarang.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_panel_penerimaanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btn_cetak;
    private rojeru_san.RSButton btn_keluar;
    private javax.swing.JLabel btn_laporan;
    private javax.swing.JLabel btn_penjualan;
    private javax.swing.JLabel btn_penjualan1;
    private javax.swing.JLabel btn_stok;
    private javax.swing.JLabel btn_stok1;
    private javax.swing.JLabel btn_x;
    private javax.swing.JComboBox<String> combo_cetak;
    private javax.swing.JDialog form_laporan;
    private utilities.gradienpanel gradienpanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panel_barangmasuk;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_penerimaan;
    private javax.swing.JPanel panel_penjualan;
    private javax.swing.JPanel panel_stok;
    private javax.swing.JLabel txt_tgl;
    private javax.swing.JLabel txt_user;
    // End of variables declaration//GEN-END:variables
}
