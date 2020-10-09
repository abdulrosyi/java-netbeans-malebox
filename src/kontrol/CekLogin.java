
package kontrol;

import database.KoneksiDatabase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CekLogin {
    private Connection koneksi = new KoneksiDatabase().KoneksiDatabase();
    private Statement state_db = null;
    private ResultSet aksi_db = null;
    private boolean tersedia;
    
     public boolean CekLogin (String u, String p){
        try{
            state_db = (Statement) koneksi.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            aksi_db = state_db.executeQuery("select * from admin where user='"+u+"' and password='"+p+"' limit 1");
            tersedia = aksi_db.last();
            LoginSession.setUsername(u);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Login !");
        }
        return tersedia;
    }
    
}
