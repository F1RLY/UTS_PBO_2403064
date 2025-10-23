import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AplikasiWasteManagement app = new AplikasiWasteManagement();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("================================");
        System.out.println("SMART WASTE MANAGEMENT SYSTEM");
        System.out.println("================================");
        
        // Login
        boolean loginBerhasil = false;
        while (!loginBerhasil) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            
            loginBerhasil = app.loginAdmin(username, password);
            if (!loginBerhasil) {
                System.out.println("Login gagal! Coba lagi.\n");
            }
        }
        
        System.out.println("Login berhasil! Selamat datang, " + 
                          app.getAdminAktif().getNama() + "!");
        
        // Menu utama
        while (true) {
            System.out.println("\n================================");
            System.out.println("MENU UTAMA");
            System.out.println("================================");
            System.out.println("1. Kelola SmartBin");
            System.out.println("2. Pantau Status SmartBin");
            System.out.println("3. Kelola Petugas");
            System.out.println("4. Laporan Aktivitas");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    app.kelolaSmartBin(scanner);
                    break;
                case 2:
                    app.pantauStatus();
                    break;
                case 3:
                    app.kelolaPetugas(scanner);
                    break;
                case 4:
                    app.lihatLaporan();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem!");
                    System.out.println("Sampai jumpa!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}