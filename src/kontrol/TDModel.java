package kontrol;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import database.KoneksiDatabase;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TDModel {
    private Connection koneksi = (Connection) new KoneksiDatabase().KoneksiDatabase();
    private Statement db_state = null;
    private ResultSet db_query = null;
    private DefaultTableModel TabelModel;
    private String data_cari;
    
    public DefaultTableModel PembayaranDetail(Pencarian PencarianData){
        data_cari=" ";
        TabelModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int bari, int kolom){
                return false;
            }
        };
        TabelModel.addColumn("No");
        TabelModel.addColumn("No Transaksi");
        TabelModel.addColumn("Kode Barang");
        TabelModel.addColumn("Nama Barang");
        TabelModel.addColumn("Harga Barang");
        TabelModel.addColumn("Jumlah Beli");
        TabelModel.addColumn("Total");
        try{
            if (PencarianData.getPencarianKondisiPembayaran())
                data_cari = " where "+PencarianData.getPencarianKolomPembayaran()+" like '%"+PencarianData.getPencarianDataPembayaran()+"%' ";
                db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                db_query = db_state.executeQuery("select * from tabel_detailpembayaran"
                    +data_cari
                    + "order by no_transaksi asc");
            while(db_query.next()){
                TabelModel.addRow(
                new Object[]{
                    db_query.getInt("idpembayaran"),
                    db_query.getString("no_transaksi"),
                    db_query.getString("kode"),
                    db_query.getString("nama"),
                    db_query.getInt("harga"),
                    db_query.getInt("jumlah"),
                    db_query.getInt("total")
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data pembayaran gagal ditampilkannnnnnnn"+e);
        }
        return TabelModel;
        
    }
    
    public DefaultTableModel PemesananJumlah(Pencarian PencarianData){
        data_cari=" ";
        TabelModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int bari, int kolom){
                return false;
            }
        };
        TabelModel.addColumn("Kode Pemesanan");
        TabelModel.addColumn("Kode Barang");
        TabelModel.addColumn("Nama Barang");
        TabelModel.addColumn("Jumlah Beli");
        TabelModel.addColumn("Kategori Barang");
        TabelModel.addColumn("Tanggal Pemesanan");
        try{
            if (PencarianData.getPencarianKondisi())
                data_cari = " where "+PencarianData.getPencarianKolom()+" like '%"+PencarianData.getPencarianData()+"%' AND jumlah_beli>0 ";
                db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                db_query = db_state.executeQuery("select * from tabel_pemesanan"
                    +data_cari
                    + "order by kode_pemesanan asc");
            while(db_query.next()){
                TabelModel.addRow(
                new Object[]{
                    db_query.getString("kode_pemesanan"),
                    db_query.getString("kode_barang"),
                    db_query.getString("nama_barang"),
                    db_query.getString("jumlah_beli"),
                    db_query.getString("kategori"),
                    db_query.getString("tanggal")
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Pemesanan gagal di tampilkannnnnnnn");
        }
        return TabelModel;
        
    }
    
    public DefaultTableModel Pemesanan(Pencarian PencarianData){
        data_cari=" ";
        TabelModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int bari, int kolom){
                return false;
            }
        };
        TabelModel.addColumn("Kode Pemesanan");
        TabelModel.addColumn("Kode Barang");
        TabelModel.addColumn("Nama Barang");
        TabelModel.addColumn("Jumlah Beli");
        TabelModel.addColumn("Kategori Barang");
        TabelModel.addColumn("Tanggal Pemesanan");
        try{
            if (PencarianData.getPencarianKondisi())
                data_cari = " where "+PencarianData.getPencarianKolom()+" like '%"+PencarianData.getPencarianData()+"%' ";
                db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                db_query = db_state.executeQuery("select * from tabel_pemesanan"
                    +data_cari
                    + "order by kode_pemesanan asc");
            while(db_query.next()){
                TabelModel.addRow(
                new Object[]{
                    db_query.getString("kode_pemesanan"),
                    db_query.getString("kode_barang"),
                    db_query.getString("nama_barang"),
                    db_query.getString("jumlah_beli"),
                    db_query.getString("kategori"),
                    db_query.getString("tanggal")
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Pemesanan gagal di tampilkannnnnnnn");
        }
        return TabelModel;
    }
    public DefaultTableModel Stok(Pencarian PencarianData){
        data_cari = " ";
        TabelModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int baris, int kolom){
                return false;
            }
        };
        TabelModel.addColumn("Kode Barang");
        TabelModel.addColumn("Nama Barang");
        TabelModel.addColumn("Harga Barang");
        TabelModel.addColumn("Stok Barang");
        TabelModel.addColumn("Kategori Barang");
        TabelModel.addColumn("Tanggal Masuk");
        try{
            if (PencarianData.getPencarianKondisi())
                data_cari = " where "+PencarianData.getPencarianKolom()+" like '%"+PencarianData.getPencarianData()+"%' ";
            db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            db_query = db_state.executeQuery("select * from tabel_stok"
                    +data_cari
                    + "order by kode asc");
            while(db_query.next()){
                TabelModel.addRow(
                new Object[]{
                    db_query.getString("kode"),
                    db_query.getString("nama"),
                    db_query.getString("harga"),
                    db_query.getString("stok"),
                    db_query.getString("kategori"),
                    db_query.getString("tanggal")
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal ditampilkannnnnnnn"+e);
        }
        return TabelModel;
    }
    
    public DefaultTableModel Transaksi(Pencarian PencarianData){
        data_cari = " ";
        TabelModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int baris, int kolom){
                return true;
            }
        };
        TabelModel.addColumn("No. Transaksi");
        TabelModel.addColumn("Kode Barang");
        TabelModel.addColumn("Nama");
        TabelModel.addColumn("Harga");
        TabelModel.addColumn("Jumlah");
        TabelModel.addColumn("Total");
        try{
            if (PencarianData.getPencarianKondisi())
                data_cari = " where "+PencarianData.getPencarianKolom()+" like '%"+PencarianData.getPencarianData()+"%' ";
            db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            db_query = db_state.executeQuery("select * from tabel_detailpembayaran"
                    +data_cari
                    + "order by no_transaksi asc");
            while(db_query.next()){
                TabelModel.addRow(
                new Object[]{
                    db_query.getString("tabel_detailpembayaran.no_transaksi"),
                    db_query.getString("tabel_detailpembayaran.kode"),
                    db_query.getString("tabel_detailpembayaran.nama"),
                    db_query.getInt("tabel_detailpembayaran.harga"),
                    db_query.getInt("tabel_detailpembayaran.jumlah"),
                    db_query.getInt("tabel_detailpembayaran.total")   
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Transaksi gagal di tampilkanaaaaaaaan");
        }
        return TabelModel;
    }
}
