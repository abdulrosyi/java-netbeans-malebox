package database;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    private Connection koneksi;
    private boolean sedia_db;
    
    public Connection KoneksiDatabase(){
        if (koneksi==null){
            MysqlDataSource buat_koneksi = new MysqlDataSource(); 
            buat_koneksi.setURL("jdbc:mysql://localhost/malebox");
            buat_koneksi.setUser("root"); buat_koneksi.setPassword("");
            try{
                koneksi = (Connection) buat_koneksi.getConnection();
                sedia_db = false;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Gagal mengkoneksikan database !");
                sedia_db = true;
            }
        }   
        return koneksi;
    }
    
    public boolean getLog(){
        return sedia_db;
    }
    
}
