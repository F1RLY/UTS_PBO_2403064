import java.util.Scanner;

public class SmartBin {
    private String id;
    private String lokasi;
    private int kapasitas;
    private int volumeTerisi;
    private String jenis;
    private String status;

    public SmartBin(String id, String lokasi, int kapasitas, String jenis) {
        this.id = id;
        this.lokasi = lokasi;
        this.kapasitas = kapasitas;
        this.jenis = jenis;
        this.volumeTerisi = 0;
        this.status = "NORMAL";
    }

    // Method tambahData() - sesuai analisis
    public void tambahData(Scanner scanner) {
        System.out.println("-- Tambah SmartBin --");
        System.out.print("ID: ");
        this.id = scanner.nextLine();
        System.out.print("Lokasi: ");
        this.lokasi = scanner.nextLine();
        System.out.print("Kapasitas (L): ");
        this.kapasitas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Jenis (Organik/Plastik/Logam): ");
        this.jenis = scanner.nextLine();
        this.volumeTerisi = 0;
        this.status = "NORMAL";
        System.out.println("SmartBin berhasil ditambahkan!");
    }

    // Method lihatData() - sesuai analisis
    public void lihatData() {
        System.out.printf("%-8s %-20s %-8dL %-8dL %-10s %-10s\n", 
            id, lokasi, kapasitas, volumeTerisi, jenis, status);
    }

    // Method updateVolume() - sesuai analisis
    public void updateVolume(int volumeBaru) {
        this.volumeTerisi = volumeBaru;
        this.status = cekStatus();
        if (status.equals("PENUH!") || status.equals("BAHAYA!")) {
            kirimNotifikasi();
        }
    }

    // Method cekStatus() - sesuai analisis
    public String cekStatus() {
        double persentase = (double) volumeTerisi / kapasitas * 100;
        if (persentase >= 90) return "BAHAYA!";
        else if (persentase >= 80) return "PENUH!";
        else return "NORMAL";
    }

    // Method kirimNotifikasi() - sesuai analisis
    public void kirimNotifikasi() {
        double persentase = (double) volumeTerisi / kapasitas * 100;
        System.out.println("\n=== NOTIFIKASI ===");
        System.out.println("SmartBin " + id + " di " + lokasi + " sudah " + 
                         (int)persentase + "% penuh!");
        System.out.println("Status: " + status);
        System.out.println("Tindakan: Segera tugaskan petugas!");
    }

    // Getter methods
    public String getId() { return id; }
    public String getLokasi() { return lokasi; }
    public int getKapasitas() { return kapasitas; }
    public int getVolumeTerisi() { return volumeTerisi; }
    public String getJenis() { return jenis; }
    public String getStatus() { return status; }
}