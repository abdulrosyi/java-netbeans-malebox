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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import kontrol.DBHapus;
import kontrol.DBSimpan;
import kontrol.LoginSession;
import kontrol.Pencarian;
import kontrol.TDModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class FormTransaksi extends javax.swing.JFrame {
    private Pencarian PencarianData = new Pencarian();
    private Connection koneksi = new KoneksiDatabase().KoneksiDatabase();
    private PreparedStatement db_query;
    private Statement state_db = null;
    private ResultSet aksi_db = null;
    private String kode_transaksidetail="";
    private String nama=LoginSession.getUsername();
    private String _kode="";
    private int totalharga_text=0;
    private int jumlahbeli=0;
    private int cekstok=0;
    private int kembali=0;
    private HashMap HM;
    
    public FormTransaksi() {
        initComponents();
        tanggal();
        txt_user.setText(nama);
        setTabelDataStok();
        kodeAturTransaksi();
        setTabelDataPembayaran();
        hitungTotal();
    }
    
    public void tanggal(){
        Date tggl=new Date();
        SimpleDateFormat simpel=new SimpleDateFormat("yyyy-MM-dd");
        txt_tgl.setText(simpel.format(tggl));
    }
 
    private void setTabelDataPembayaran(){
        PencarianData.setPencarianKolomPembayaran("no_transaksi");
        PencarianData.setPencarianDataPembayaran(kode_transaksidetail);
        PencarianData.setPencarianKondisiPembayaran(true);
        tabel_pembayaran.setModel(new TDModel().PembayaranDetail(PencarianData));
        tabel_pembayaran.setSelectionMode(0);
        for (int i=0; i<tabel_pembayaran.getColumnCount(); i++){
        tabel_pembayaran.getColumnModel().getColumn(i).setResizable(false);
        }
        tabel_pembayaran.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabel_pembayaran.getTableHeader().setOpaque(false);
        tabel_pembayaran.getTableHeader().setBackground(new Color(232, 67, 147));
        tabel_pembayaran.getTableHeader().setForeground(new Color(255,255,255));
        tabel_pembayaran.setRowHeight(25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int a=0; a<tabel_pembayaran.getColumnCount(); a++)
        {
            tabel_pembayaran.getColumnModel().getColumn(a).setCellRenderer(centerRenderer);
        }
    }
    private void hitungTotal(){
        for(int baris=0; baris<tabel_pembayaran.getRowCount(); baris++){
            totalharga_text=totalharga_text+Integer.parseInt(tabel_pembayaran.getValueAt(baris,6).toString());
        }
        txt_totalbayar.setText(String.valueOf("Rp. "+totalharga_text));
    }
    private void setTabelDataStok(){
        tabel_stok.setModel(new TDModel().Stok(PencarianData));
        tabel_stok.setSelectionMode(0);
        for (int i=0; i<tabel_stok.getColumnCount(); i++){
            tabel_stok.getColumnModel().getColumn(i).setResizable(false);
        }
        tabel_stok.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabel_stok.getTableHeader().setOpaque(false);
        tabel_stok.getTableHeader().setBackground(new Color(232, 67, 147));
        tabel_stok.getTableHeader().setForeground(new Color(255,255,255));
        tabel_stok.setRowHeight(25);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int a=0; a<tabel_stok.getColumnCount(); a++)
        {
            tabel_stok.getColumnModel().getColumn(a).setCellRenderer(centerRenderer);
        }
    }
    
    private void HitungUangKembali(){
        int total = Integer.parseInt(txt_totalbayar.getText().substring(4));
        int uangBayar = Integer.parseInt(txt_bayar.getText());
        kembali = uangBayar - total;
        txt_kembalian.setText(String.valueOf("Rp."+kembali));
    }
  
    private void kodeAturTransaksi(){
        try{
            state_db = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            aksi_db = state_db.executeQuery("select right (no_transaksi,2) as no_terakhir from tabel_pembayaran order by no_terakhir asc ");
            if(aksi_db.first()==false){
                kode_transaksidetail="TR-001";
            }else
            {
                aksi_db.last();
                int no=aksi_db.getInt(1)+1;
                String cno=String.valueOf(no);
                int pnjg_cno=cno.length();
                for (int i=0;i<3-pnjg_cno;i++)
                {
                    cno="0"+cno;
                }
                kode_transaksidetail="TR-"+cno;
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
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
        txt_caridata = new rojeru_san.RSMTextFull();
        cari_kolom = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_stok = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_pembayaran = new javax.swing.JTable();
        btn_nambah = new utilities.gradienbtn();
        txt_totalbayar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_bayar = new rojeru_san.RSMTextFull();
        jLabel6 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JLabel();
        txt_jumlah = new rojeru_san.RSMTextFull();
        btn_kurang = new utilities.gradienbtn();
        btn_konfirmasi = new utilities.gradienbtn();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 770));
        setUndecorated(true);
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
                    .addGroup(gradienpanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        txt_caridata.setBackground(new java.awt.Color(255, 255, 255));
        txt_caridata.setPlaceholder("Cari Data");
        txt_caridata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_caridataKeyReleased(evt);
            }
        });

        cari_kolom.setBackground(new java.awt.Color(255, 255, 255));
        cari_kolom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kode Barang", "Nama Barang" }));
        cari_kolom.setFocusable(false);
        cari_kolom.setPreferredSize(new java.awt.Dimension(78, 25));

        tabel_stok.setBackground(new java.awt.Color(255, 255, 255));
        tabel_stok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Barang", "Nama Barang", "Harga", "Stok Barang", "Kategori", "Tanggal"
            }
        ));
        tabel_stok.setGridColor(new java.awt.Color(255, 255, 255));
        tabel_stok.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_stok.setName(""); // NOI18N
        tabel_stok.setSelectionBackground(new java.awt.Color(232, 67, 147));
        tabel_stok.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabel_stok.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tabel_stok);

        tabel_pembayaran.setBackground(new java.awt.Color(255, 255, 255));
        tabel_pembayaran.setGridColor(new java.awt.Color(255, 255, 255));
        tabel_pembayaran.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tabel_pembayaran.setName(""); // NOI18N
        tabel_pembayaran.setSelectionBackground(new java.awt.Color(232, 67, 147));
        tabel_pembayaran.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabel_pembayaran.setShowVerticalLines(false);
        jScrollPane3.setViewportView(tabel_pembayaran);

        btn_nambah.setBorder(null);
        btn_nambah.setText("Tambah");
        btn_nambah.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_nambah.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_nambah.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_nambah.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_nambah.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_nambah.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_nambah.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_nambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nambahActionPerformed(evt);
            }
        });

        txt_totalbayar.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_totalbayar.setText("00000");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("Bayar");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Kembalian");

        txt_bayar.setBackground(new java.awt.Color(255, 255, 255));
        txt_bayar.setBorder(null);
        txt_bayar.setPlaceholder("Masukkan Pembayaran");
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_bayarKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("Total");

        txt_kembalian.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txt_kembalian.setText("00000");

        txt_jumlah.setBackground(new java.awt.Color(255, 255, 255));
        txt_jumlah.setPlaceholder("Masukkan Jumlah Pembelian");
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyTyped(evt);
            }
        });

        btn_kurang.setBorder(null);
        btn_kurang.setText("Kurang");
        btn_kurang.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_kurang.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_kurang.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_kurang.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_kurang.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_kurang.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_kurang.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kurangActionPerformed(evt);
            }
        });

        btn_konfirmasi.setBorder(null);
        btn_konfirmasi.setText("Konfirmasi");
        btn_konfirmasi.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn_konfirmasi.setkEndColor(new java.awt.Color(232, 67, 147));
        btn_konfirmasi.setkHoverEndColor(new java.awt.Color(108, 92, 231));
        btn_konfirmasi.setkHoverForeGround(new java.awt.Color(223, 230, 233));
        btn_konfirmasi.setkHoverStartColor(new java.awt.Color(232, 67, 147));
        btn_konfirmasi.setkSelectedColor(new java.awt.Color(108, 92, 231));
        btn_konfirmasi.setkStartColor(new java.awt.Color(108, 92, 231));
        btn_konfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_konfirmasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                        .addGap(210, 210, 210)
                        .addComponent(btn_nambah, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(cari_kolom, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_caridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_kurang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_totalbayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_konfirmasi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_kurang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_konfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_caridata, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari_kolom, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_totalbayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_nambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 290, 1370, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_xMousePressed
        int ok = JOptionPane.showConfirmDialog(null,
            "Apakah anda yakin ingin keluar?",
            "WARNING!!!",
            JOptionPane.YES_NO_OPTION);
        if(ok==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_xMousePressed

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        FormHome Home = new FormHome();
        Home.setLocationRelativeTo(null);
        Home.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_nambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nambahActionPerformed
         try{
            cekstok=Integer.parseInt(String.valueOf(tabel_stok.getValueAt(tabel_stok.getSelectedRow(),3)));
            if(cekstok!=0){
             String kodebarang=String.valueOf(tabel_stok.getValueAt(tabel_stok.getSelectedRow(),0));
             String namabarang=String.valueOf(tabel_stok.getValueAt(tabel_stok.getSelectedRow(),1));
             int hargabarang=Integer.parseInt(String.valueOf(tabel_stok.getValueAt(tabel_stok.getSelectedRow(),2)));
             int jumlah=Integer.parseInt(txt_jumlah.getText().toString());
             int total=hargabarang*jumlah;
             ArrayList<String> kesalahan = new ArrayList<String>();
             kesalahan.add("KESALAHAN !");
             if(tabel_stok.getSelectedRowCount()==0)
                kesalahan.add("Pilih Barang terlebih dahulu");
             if(txt_jumlah.getText().isEmpty())
                kesalahan.add("Masukkan jumlah beli terlebih dahulu");
             if(kesalahan.size()<=1){
                    new DBSimpan().DetailPembayaran(
                        kode_transaksidetail,
                        kodebarang,
                        namabarang,
                        hargabarang,
                        jumlah,
                        total);
                    setTabelDataPembayaran();
                    txt_jumlah.setText("");
                    hitungTotal();
            }else{
                JOptionPane.showMessageDialog(null, kesalahan.toArray());
            }
            }else{
                 JOptionPane.showMessageDialog(null,"Stok Kosong");
             }
        }catch(Exception e){}
    }//GEN-LAST:event_btn_nambahActionPerformed

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        HitungUangKembali();
    }//GEN-LAST:event_txt_bayarKeyReleased

    private void btn_kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kurangActionPerformed
        try{
            if(tabel_pembayaran.getSelectedRowCount()>0){
            if(JOptionPane.showConfirmDialog(null, "Anda akan menghapus No Pembayaran : "+tabel_pembayaran.getValueAt(tabel_pembayaran.getSelectedRow(), 0)+" ?")==0){
                new DBHapus().DetailPembayaran(String.valueOf(tabel_pembayaran.getValueAt(tabel_pembayaran.getSelectedRow(), 0)));
                setTabelDataPembayaran();
                hitungTotal();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Tidak ada data yang anda pilih");
        }
        }catch (Exception e){}
    }//GEN-LAST:event_btn_kurangActionPerformed

    private void btn_konfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_konfirmasiActionPerformed
        try{
            ArrayList<String> kesalahan = new ArrayList<String>();
            kesalahan.add("KESALAHAN !");
            if(txt_bayar.getText().isEmpty())
                kesalahan.add("Masukkan Jumlah pembayaran");
            if(kesalahan.size()<=1){
                String tanggal=txt_tgl.getText().toString();
                for(int baris=0; baris<tabel_pembayaran.getRowCount(); baris++){
                    jumlahbeli=jumlahbeli+Integer.parseInt(tabel_pembayaran.getValueAt(baris,5).toString());
                }
                int bayar=Integer.parseInt(txt_bayar.getText().toString());
                new DBSimpan().Pembayaran(
                    kode_transaksidetail,
                    tanggal,
                    jumlahbeli,
                    totalharga_text,
                    bayar,
                    kembali,
                    nama);
                HM=new HashMap();
                HM.put("total",totalharga_text);
                HM.put("namakasir",nama);
                HM.put("kode_transaksi",kode_transaksidetail);
                String FL=("./src/nota/Nota_Transaksi.jrxml");
                JasperDesign jasperDesign = JRXmlLoader.load(FL);
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, HM, koneksi);
                JasperViewer.viewReport(jasperPrint, false);
                PencarianData.setPencarianKondisi(false);
                setTabelDataStok();
                kodeAturTransaksi();
                setTabelDataPembayaran();
                txt_totalbayar.setText("0000");
                txt_bayar.setText("0");
                txt_jumlah.setText("0");
                txt_kembalian.setText("0");
            }
        }catch(JRException e){
            JOptionPane.showMessageDialog(null, "Error " + e);
        }   
    }//GEN-LAST:event_btn_konfirmasiActionPerformed

    private void txt_jumlahKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_txt_jumlahKeyTyped

    private void txt_bayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| c==java.awt.event.KeyEvent.VK_BACK_SPACE)|| c==java.awt.event.KeyEvent.VK_DELETE){
            evt.consume();
        }
    }//GEN-LAST:event_txt_bayarKeyTyped

    private void txt_caridataKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_caridataKeyReleased
        if ("Kode Barang".equalsIgnoreCase(cari_kolom.getSelectedItem().toString())){
            PencarianData.setPencarianKolom("kode");
            PencarianData.setPencarianData(txt_caridata.getText().trim());
            PencarianData.setPencarianKondisi(true);
            setTabelDataStok();
        }
        if ("Nama Barang".equalsIgnoreCase(cari_kolom.getSelectedItem().toString())){
            PencarianData.setPencarianKolom("nama");
            PencarianData.setPencarianData(txt_caridata.getText().trim());
            PencarianData.setPencarianKondisi(true);
            setTabelDataStok();
        }
    }//GEN-LAST:event_txt_caridataKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private utilities.gradienbtn btn_konfirmasi;
    private utilities.gradienbtn btn_kurang;
    private utilities.gradienbtn btn_nambah;
    private javax.swing.JLabel btn_x;
    private javax.swing.JComboBox cari_kolom;
    private utilities.gradienpanel gradienpanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabel_pembayaran;
    private javax.swing.JTable tabel_stok;
    private rojeru_san.RSMTextFull txt_bayar;
    private rojeru_san.RSMTextFull txt_caridata;
    private rojeru_san.RSMTextFull txt_jumlah;
    private javax.swing.JLabel txt_kembalian;
    private javax.swing.JLabel txt_tgl;
    private javax.swing.JLabel txt_totalbayar;
    private javax.swing.JLabel txt_user;
    // End of variables declaration//GEN-END:variables
}
