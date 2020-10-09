package kontrol;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.KoneksiDatabase;
import javax.swing.JOptionPane;


public class DBHapus {
    private Connection koneksi = (Connection) new KoneksiDatabase().KoneksiDatabase();
    private PreparedStatement db_query;
    
    public void DetailPembayaran(String kode){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("delete from tabel_detailpembayaran where idpembayaran=?");
            db_query.setString(1, kode);
            db_query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus dari keranjang");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal dihapus "+e);
        }
    }
    public void Pemesanan(String kode){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("delete from tabel_pemesanan where kode_pemesanan=?");
            db_query.setString(1, kode);
            db_query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }
    public void Stok(String kode){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("delete from tabel_stok where kode=?");
            db_query.setString(1, kode);
            db_query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus");
        }
    }
    public void detailPembayaran(String kode){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("delete from tabel_detailpembayaran where kode=?");
            db_query.setString(1, kode);
            db_query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di hapus dari keranjang");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di hapus dari keranjang");
        }
    }
}
