import java.util.Date;

public class Penanganan {
    private String id;
    private SmartBin smartBin;
    private Petugas petugas;
    private Date tanggalPenanganan;
    private String status;

    public Penanganan(String id, SmartBin smartBin, Petugas petugas) {
        this.id = id;
        this.smartBin = smartBin;
        this.petugas = petugas;
        this.tanggalPenanganan = new Date();
        this.status = "DALAM PROSES";
    }

    // Method buatPenanganan() - sesuai analisis
    public void buatPenanganan(SmartBin smartBin, Petugas petugas) {
        this.smartBin = smartBin;
        this.petugas = petugas;
        this.tanggalPenanganan = new Date();
        this.status = "DALAM PROSES";
        System.out.println("Penanganan berhasil dibuat untuk SmartBin: " + smartBin.getId());
    }

    // Method lihatData() - sesuai analisis
    public void lihatData() {
        String tanggal = tanggalPenanganan.toString().substring(0, 10);
        System.out.printf("%-12s | %-8s | %-15s | %-15s\n",
            tanggal, smartBin.getId(), petugas.getNama(), status);
    }

    // Method updateStatus() - sesuai analisis
    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Status penanganan diupdate menjadi: " + status);
    }

    // Getter methods
    public String getId() { return id; }
    public SmartBin getSmartBin() { return smartBin; }
    public Petugas getPetugas() { return petugas; }
    public Date getTanggalPenanganan() { return tanggalPenanganan; }
    public String getStatus() { return status; }
}