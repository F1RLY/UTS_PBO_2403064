import java.util.Scanner;

public class Petugas {
    private String id;
    private String nama;
    private String areaTugas;
    private String noTelepon;

    public Petugas(String id, String nama, String areaTugas, String noTelepon) {
        this.id = id;
        this.nama = nama;
        this.areaTugas = areaTugas;
        this.noTelepon = noTelepon;
    }

    // Method tambahData() - sesuai analisis
    public void tambahData(Scanner scanner) {
        System.out.println("-- Tambah Petugas --");
        System.out.print("ID: ");
        this.id = scanner.nextLine();
        System.out.print("Nama: ");
        this.nama = scanner.nextLine();
        System.out.print("Area Tugas: ");
        this.areaTugas = scanner.nextLine();
        System.out.print("No Telepon: ");
        this.noTelepon = scanner.nextLine();
        System.out.println("Petugas berhasil ditambahkan!");
    }

    // Method lihatData() - sesuai analisis
    public void lihatData() {
        System.out.printf("%-8s %-15s %-15s %-15s\n", 
            id, nama, areaTugas, noTelepon);
    }

    // Method tanganiSmartBin() - sesuai analisis
    public void tanganiSmartBin(SmartBin smartBin) {
        System.out.println("Petugas '" + nama + "' menangani SmartBin: " + 
                         smartBin.getId() + " - " + smartBin.getLokasi());
        // Reset volume setelah ditangani
        smartBin.updateVolume(0);
        System.out.println("SmartBin telah dikosongkan!");
    }

    // Getter methods
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getAreaTugas() { return areaTugas; }
    public String getNoTelepon() { return noTelepon; }
}