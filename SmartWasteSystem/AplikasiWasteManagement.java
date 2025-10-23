import java.util.*;

public class AplikasiWasteManagement {
    private ArrayList<Admin> daftarAdmin;
    private ArrayList<SmartBin> daftarSmartBin;
    private ArrayList<Petugas> daftarPetugas;
    private ArrayList<Penanganan> daftarPenanganan;
    private ArrayList<Notifikasi> daftarNotifikasi;
    private Admin adminAktif;

    public AplikasiWasteManagement() {
        this.daftarAdmin = new ArrayList<>();
        this.daftarSmartBin = new ArrayList<>();
        this.daftarPetugas = new ArrayList<>();
        this.daftarPenanganan = new ArrayList<>();
        this.daftarNotifikasi = new ArrayList<>();
        inisialisasiData();
    }

    // Method inisialisasiData() - sesuai analisis
    public void inisialisasiData() {
        // Data admin default
        daftarAdmin.add(new Admin("ADM001", "admin", "admin123", "Administrator Utama"));
        
        // Data smartbin sample
        daftarSmartBin.add(new SmartBin("BIN001", "Gedung A Lantai 1", 100, "Plastik"));
        daftarSmartBin.add(new SmartBin("BIN002", "Gedung B Lantai 2", 80, "Organik"));
        daftarSmartBin.add(new SmartBin("BIN003", "Parkiran Utama", 120, "Logam"));
        
        // Data petugas sample
        daftarPetugas.add(new Petugas("P001", "Budi Santoso", "Gedung A", "08123456789"));
        daftarPetugas.add(new Petugas("P002", "Sari Indah", "Gedung B", "08129876543"));
        
        // Set volume sample untuk testing
        daftarSmartBin.get(0).updateVolume(85); // PENUH!
        daftarSmartBin.get(1).updateVolume(45); // NORMAL
        daftarSmartBin.get(2).updateVolume(110); // BAHAYA!
    }

    // Method loginAdmin() - sesuai analisis
    public boolean loginAdmin(String username, String password) {
        for (Admin admin : daftarAdmin) {
            if (admin.login(username, password)) {
                adminAktif = admin;
                return true;
            }
        }
        return false;
    }

    // Method kelolaSmartBin() - sesuai analisis
    public void kelolaSmartBin(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA SMARTBIN ===");
            System.out.println("1. Tambah SmartBin");
            System.out.println("2. Lihat Daftar SmartBin");
            System.out.println("3. Update Volume SmartBin");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahSmartBin(scanner);
                    break;
                case 2:
                    lihatDaftarSmartBin();
                    break;
                case 3:
                    updateVolumeSmartBin(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tambahSmartBin(Scanner scanner) {
        SmartBin bin = new SmartBin("", "", 0, "");
        bin.tambahData(scanner);
        daftarSmartBin.add(bin);
    }

    private void lihatDaftarSmartBin() {
        System.out.println("\n=== DAFTAR SMARTBIN ===");
        System.out.printf("%-8s %-20s %-8s %-8s %-10s %-10s\n", 
            "ID", "Lokasi", "Kapasitas", "Terisi", "Jenis", "Status");
        for (SmartBin bin : daftarSmartBin) {
            bin.lihatData();
        }
    }

    private void updateVolumeSmartBin(Scanner scanner) {
        lihatDaftarSmartBin();
        System.out.print("\nMasukkan ID SmartBin: ");
        String id = scanner.nextLine();
        
        for (SmartBin bin : daftarSmartBin) {
            if (bin.getId().equals(id)) {
                System.out.print("Masukkan volume terisi (L): ");
                int volume = scanner.nextInt();
                scanner.nextLine();
                bin.updateVolume(volume);
                
                // Buat notifikasi otomatis jika status berbahaya/penuh
                if (bin.getStatus().equals("PENUH!") || bin.getStatus().equals("BAHAYA!")) {
                    Notifikasi notif = new Notifikasi(bin);
                    daftarNotifikasi.add(notif);
                    notif.kirimNotifikasi(bin);
                }
                return;
            }
        }
        System.out.println("SmartBin tidak ditemukan!");
    }

    // Method kelolaPetugas() - sesuai analisis
    public void kelolaPetugas(Scanner scanner) {
        while (true) {
            System.out.println("\n=== KELOLA PETUGAS ===");
            System.out.println("1. Tambah Petugas");
            System.out.println("2. Lihat Petugas");
            System.out.println("3. Tugaskan Penanganan");
            System.out.println("4. Kembali");
            System.out.print("Pilih opsi: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahPetugas(scanner);
                    break;
                case 2:
                    lihatDaftarPetugas();
                    break;
                case 3:
                    tugaskanPenanganan(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void tambahPetugas(Scanner scanner) {
        Petugas petugas = new Petugas("", "", "", "");
        petugas.tambahData(scanner);
        daftarPetugas.add(petugas);
    }

    private void lihatDaftarPetugas() {
        System.out.println("\n=== DAFTAR PETUGAS ===");
        System.out.printf("%-8s %-15s %-15s %-15s\n", 
            "ID", "Nama", "Area Tugas", "No Telepon");
        for (Petugas petugas : daftarPetugas) {
            petugas.lihatData();
        }
    }

    private void tugaskanPenanganan(Scanner scanner) {
        System.out.println("\n=== TUGASKAN PENANGANAN ===");
        
        // Tampilkan smartbin yang perlu penanganan
        System.out.println("SmartBin yang perlu penanganan:");
        boolean adaYangPerluPenanganan = false;
        for (SmartBin bin : daftarSmartBin) {
            if (bin.getStatus().equals("PENUH!") || bin.getStatus().equals("BAHAYA!")) {
                System.out.println("- " + bin.getId() + " - " + bin.getLokasi() + 
                    " (" + bin.getVolumeTerisi() + "/" + bin.getKapasitas() + "L) - STATUS: " + bin.getStatus());
                adaYangPerluPenanganan = true;
            }
        }
        
        if (!adaYangPerluPenanganan) {
            System.out.println("Tidak ada SmartBin yang perlu penanganan.");
            return;
        }
        
        System.out.print("Pilih ID SmartBin: ");
        String binId = scanner.nextLine();
        System.out.print("Pilih ID Petugas: ");
        String petugasId = scanner.nextLine();
        
        SmartBin selectedBin = null;
        Petugas selectedPetugas = null;
        
        // Cari smartbin
        for (SmartBin bin : daftarSmartBin) {
            if (bin.getId().equals(binId)) {
                selectedBin = bin;
                break;
            }
        }
        
        // Cari petugas
        for (Petugas petugas : daftarPetugas) {
            if (petugas.getId().equals(petugasId)) {
                selectedPetugas = petugas;
                break;
            }
        }
        
        if (selectedBin != null && selectedPetugas != null) {
            String penangananId = "PEN" + (daftarPenanganan.size() + 1);
            Penanganan penanganan = new Penanganan(penangananId, selectedBin, selectedPetugas);
            daftarPenanganan.add(penanganan);
            
            // Petugas menangani smartbin
            selectedPetugas.tanganiSmartBin(selectedBin);
            penanganan.updateStatus("SELESAI");
            
            System.out.println("Penanganan berhasil ditugaskan!");
        } else {
            System.out.println("SmartBin atau Petugas tidak ditemukan!");
        }
    }

    // Method pantauStatus() - sesuai analisis
    public void pantauStatus() {
        lihatDaftarSmartBin();
    }

    // Method lihatLaporan() - sesuai analisis
    public void lihatLaporan() {
        System.out.println("\n=== LAPORAN AKTIVITAS ===");
        if (daftarPenanganan.isEmpty()) {
            System.out.println("Belum ada aktivitas penanganan.");
            return;
        }
        
        System.out.println("Tanggal     | SmartBin | Petugas       | Status");
        for (Penanganan penanganan : daftarPenanganan) {
            penanganan.lihatData();
        }
        
        // Tampilkan notifikasi
        if (!daftarNotifikasi.isEmpty()) {
            System.out.println("\n=== NOTIFIKASI TERAKHIR ===");
            for (Notifikasi notif : daftarNotifikasi) {
                notif.lihatNotifikasi();
            }
        }
    }

    public Admin getAdminAktif() {
        return adminAktif;
    }
}