package kontrol;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import database.KoneksiDatabase;
import javax.swing.JOptionPane;


public class DBSimpan {
    private Connection koneksi = (Connection) new KoneksiDatabase().KoneksiDatabase();
    private PreparedStatement db_query,db_query1;
    
    public void Login(
            String nama,
            String password){
         try{
            db_query = (PreparedStatement) koneksi.prepareStatement("insert into admin (user,password) values (?,?)");
            db_query.setString(1, nama);
            db_query.setString(2, password);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di simpan"+e);
        }
    }
    
    public void Pemesanan(String idpemesanan,
            String kodebarang,
            String namabarang,
            int jumlahbeli,
            String kategori,
            String tanggal){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("insert into tabel_pemesanan values(?, ?, ?, ?, ?,?)");
            db_query.setString(1, idpemesanan);
            db_query.setString(2, kodebarang);
            db_query.setString(3, namabarang);
            db_query.setInt(4, jumlahbeli);
            db_query.setString(5, kategori);
            db_query.setString(6, tanggal);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di simpan."+e);
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
            db_query = (PreparedStatement) koneksi.prepareStatement("insert into tabel_stok values(?, ?, ?, ?, ?, ?)");
            db_query.setString(1, kode);
            db_query.setString(2, nama);
            db_query.setString(3, harga);
            db_query.setString(4, stok);
            db_query.setString(5, kategori);
            db_query.setString(6, tanggal);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil di simpan.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal di simpan.");
        }
    }
         
        public void DetailPembayaran(
            String no_transaksi,
            String kode,
            String nama,
            int harga,
            int jumlah,
            int total
            ){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("insert into tabel_detailpembayaran (no_transaksi,kode,nama,harga,jumlah,total) values(?, ?, ?, ?, ?, ?)");
            db_query.setString(1, no_transaksi);
            db_query.setString(2, kode);
            db_query.setString(3, nama);
            db_query.setInt(4, harga);
            db_query.setInt(5, jumlah);
            db_query.setInt(6, total);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan di keranjang.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal disimpan di keranjang."+e);
        }
    }
          
        public void Pembayaran(
            String no_transaksi,
            String tanggal,
            int jumlah,
            int total_belanja,
            int bayar,
            int kembali,
            String nama_user
            ){
        try{
            db_query = (PreparedStatement) koneksi.prepareStatement("insert into tabel_pembayaran values(?, ?, ?, ?, ?, ?, ?)");
            db_query.setString(1, no_transaksi);
            db_query.setString(2, tanggal);
            db_query.setInt(3, jumlah);
            db_query.setInt(4, total_belanja);
            db_query.setInt(5, bayar);
            db_query.setInt(6, kembali);
            db_query.setString(7,nama_user);
            db_query.addBatch();
            db_query.executeBatch();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data gagal disimpan "+e);
        }
    }
}
