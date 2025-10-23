import java.util.Date;

public class Notifikasi {
    private String id;
    private SmartBin smartBin;
    private String pesan;
    private Date tanggal;
    private String status;

    public Notifikasi(SmartBin smartBin) {
        this.id = "NOTIF_" + System.currentTimeMillis();
        this.smartBin = smartBin;
        this.tanggal = new Date();
        this.status = "AKTIF";
        
        double persentase = (double) smartBin.getVolumeTerisi() / smartBin.getKapasitas() * 100;
        this.pesan = "SmartBin " + smartBin.getId() + " di " + smartBin.getLokasi() + 
                    " sudah " + (int)persentase + "% penuh! Status: " + smartBin.getStatus();
    }

    // Method kirimNotifikasi() - sesuai analisis
    public void kirimNotifikasi(SmartBin smartBin) {
        System.out.println("\n=== NOTIFIKASI SYSTEM ===");
        System.out.println("Pesan: " + pesan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Status: " + status);
        System.out.println("Tindakan: Segera tugaskan petugas!");
    }

    // Method lihatNotifikasi() - sesuai analisis
    public void lihatNotifikasi() {
        System.out.printf("[%s] %s\n", 
            tanggal.toString().substring(0, 16), pesan);
    }

    // Getter methods
    public String getId() { return id; }
    public SmartBin getSmartBin() { return smartBin; }
    public String getPesan() { return pesan; }
    public Date getTanggal() { return tanggal; }
    public String getStatus() { return status; }
}