
package kontrol;

public class Pencarian {
    private String tabel_pembayaran=null, kolompembayaran=null, datapembayaran=null;
    private String tabel=null, kolom=null, data=null;
    private boolean kondisi_cari=false,kondisi_caripembayaran=false;
    public void setPencarianKondisiPembayaran(boolean x){
        this.kondisi_caripembayaran = x;
    }
    public boolean getPencarianKondisiPembayaran(){
        return kondisi_caripembayaran;
    }
    public void setPencarianTabelPembayaran(String x){
        this.tabel_pembayaran = x;
    }
    public void setPencarianKolomPembayaran(String x){
        this.kolompembayaran = x;
    }
    public void setPencarianDataPembayaran(String x){
        this.datapembayaran = x;
    }
    public String getPencarianTabelPembayaran(){
        return tabel_pembayaran;
    }
    public String getPencarianKolomPembayaran(){
        return kolompembayaran;
    }
    public String getPencarianDataPembayaran(){
        return datapembayaran;
    }
    public void setPencarianTabel(String x){
        this.tabel = x;
    }
    public void setPencarianKolom(String x){
        this.kolom = x;
    }
    public void setPencarianData(String x){
        this.data = x;
    }
    public void setPencarianKondisi(boolean x){
        this.kondisi_cari = x;
    }
    public String getPencarianTabel(){
        return tabel;
    }
    public String getPencarianKolom(){
        return kolom;
    }
    public String getPencarianData(){
        return data;
    }
    public boolean getPencarianKondisi(){
        return kondisi_cari;
    }
}
