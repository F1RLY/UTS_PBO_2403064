import java.util.Scanner;

public class Admin {
    private String id;
    private String username;
    private String password;
    private String nama;

    public Admin(String id, String username, String password, String nama) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nama = nama;
    }

    // Method login() - sesuai analisis
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Method tambahData() - sesuai analisis
    public void tambahData(Scanner scanner) {
        System.out.println("-- Tambah Data Admin --");
        System.out.print("ID Admin: ");
        this.id = scanner.nextLine();
        System.out.print("Username: ");
        this.username = scanner.nextLine();
        System.out.print("Password: ");
        this.password = scanner.nextLine();
        System.out.print("Nama: ");
        this.nama = scanner.nextLine();
        System.out.println("Admin berhasil ditambahkan!");
    }

    // Method lihatData() - sesuai analisis
    public void lihatData() {
        System.out.println("=== DATA ADMIN ===");
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Username: " + username);
    }

    // Getter methods
    public String getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getNama() { return nama; }
}