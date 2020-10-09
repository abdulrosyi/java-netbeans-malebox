package kontrol;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import database.KoneksiDatabase;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class PencarianIntegrasi {
    private Connection koneksi = (Connection) new KoneksiDatabase().KoneksiDatabase();
    private Statement db_state = null;
    private ResultSet db_query = null;
    
    public String getTunggal(String tabel, String kolom, String data, String kolom_data){
        String hasil_cari = "";
        try{
            db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            db_query = db_state.executeQuery("select * from "+tabel+" where "+kolom+"='"+data+"' limit 1");
            if (db_query.next())
                hasil_cari = db_query.getString(kolom_data);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Mencari Data a"+e);
        }
        return hasil_cari;
    }
    
    public String getBanyak(String tabel, String kolom, String data, String kolom_data){
        String hasil_cari = "";
        try{
            db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            db_query = db_state.executeQuery("select * from "+tabel+" where "+kolom+"='"+data+"' ");
            if (db_query.next())
                hasil_cari = db_query.getString(kolom_data);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Mencari Data a"+e);
        }
        return hasil_cari;
    }
    
    public ArrayList<String> getTunggal(String tabel, String kondisi, String kolom_data){
        ArrayList<String> hasil_cari = new ArrayList<String>();
        try{
            db_state = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            db_query = db_state.executeQuery("select * from "+tabel+" where "+kondisi);
            while (db_query.next())
                hasil_cari.add(db_query.getString(kolom_data));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Mencari Data b"+e);
        }
        return hasil_cari;
    }
}
