package kontrol;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.KoneksiDatabase;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBUbah {
    private Connection koneksi = (Connection) new KoneksiDatabase().KoneksiDatabase();
    private PreparedStatement db_query;
    public void PemesananJumlah(
            String kode_pemesanan,
            int jumlah_beli){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement(
                        "UPDATE tabel_pemesanan SET jumlah_beli=? WHERE kode_pemesanan=?");
            db_query.setInt(1,jumlah_beli);
            db_query.setString(2,kode_pemesanan);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil dikonfirmasi");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
    }
    public void Pemesanan(
            String kode_pemesanan,
            String kode_barang,
            String nama_barang,
            int jumlah_beli,
            String kategori,
            String tanggal){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement(
                    "UPDATE tabel_pemesanan SET kode_barang=?, nama_barang=?, jumlah_beli=?, kategori=?, tanggal=? where kode_pemesanan=?");
            db_query.setString(1, kode_barang);
            db_query.setString(2, nama_barang);
            db_query.setInt(3, jumlah_beli);
            db_query.setString(4, kategori);
            db_query.setString(5, tanggal);
            db_query.setString(6, kode_pemesanan);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
    }
    public void StokJumlah(
            String kode,
            int stok){
        try{
        db_query = (PreparedStatement) koneksi.prepareStatement(
                    "UPDATE tabel_stok SET stok=? WHERE kode=?");
        db_query.setInt(1,stok);
        db_query.setString(2,kode);
        db_query.addBatch();
        db_query.executeBatch();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data gagal diubah"+e);
        }
    }
    public void Stok(
            String kode,
            String nama,
            String harga,
            String stok,
            String kategori,
            String tanggal
    ){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement(
                    "UPDATE tabel_stok SET nama=?, harga=?, stok=?, kategori=?, tanggal=? where kode=?");
            db_query.setString(1, nama);
            db_query.setString(2, harga);
            db_query.setString(3, stok);
            db_query.setString(4, kategori);
            db_query.setString(5, tanggal);
            db_query.setString(6, kode);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
    }
    public void UpdateStok(
            String kode,
            String stok
            ){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("update tabel_stok set stok=? where kode=?");
            db_query.setString(1, stok);
            db_query.setString(2, kode);
            db_query.addBatch();
            db_query.executeBatch();
//            JOptionPane.showMessageDialog(null, "Data berhasil di ubah");
        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Data gagal di ubah"+e);
        }
    }
}
