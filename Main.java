import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mahasiswa[] mahasiswas = {
                new Mahasiswa("Dodi", 10000, "Pembayaran UKT"),
                new Mahasiswa("Indah", 22220, "Pembayaran Lomba"),
                new Mahasiswa("Jodi", 20000, "Pembayaran UKT")
        };
        ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<Mahasiswa>(Arrays.asList(mahasiswas));

        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selamat Datang di Admin Menu Tagihan Mahasiswa");
            System.out.println("1. Login");
            System.out.println("0. Keluar");
            System.out.print("Pilih Nomor : ");
            int menuPilihan = inputScanner.nextInt();
            if (menuPilihan == 1) {
                Scanner input = new Scanner(System.in);

                System.out.println("Silahkan Login Masukan Username dan Password");

                System.out.print("Username : ");
                String username = input.nextLine();
                System.out.print("Password : ");
                String password = input.nextLine();

                // login
                Auth auth = new Auth();
                String hasilAuth = auth.login(username, password);
                System.out.println(hasilAuth);
                if (hasilAuth == "Login Berhasil") {

                    while (true) {
                        System.out.println("Selamat Datang Silahkan Pilih Menu Dengan Memilih Nomor");
                        System.out.println("1. Lihat data semua mahasiswa dan tagihan");
                        System.out.println("2. Buat tagihan mahasiswa");
                        System.out.println("3. Bayar tagihan mahasiswa");
                        System.out.println("0. Keluar dari Menu");
                        System.out.print("Pilih Nomor  : ");
                        int nomorMenu = input.nextInt();
                        switch (nomorMenu) {
                            case 0:
                                System.out.println("Keluar dari Menu Tagihan");

                                break;
                            case 1:
                                System.out.println("Data Mahasiswa ");
                                for (Mahasiswa mahasiswa : dataMahasiswa) {
                                    System.out.println("Mahasiswa : " + mahasiswa.nama + ", Nama tagihan : "
                                            + mahasiswa.namaTagihan + ", Jumlah Tagihan : Rp. " + mahasiswa.tagihan);
                                }
                                System.out.println("=========================");

                                break;
                            case 2:
                                System.out.println("Pilih Menu");
                                System.out.println("1. Tambah Daftar Tagihan Mahasiswa Baru");
                                System.out.println("2. Tambah tagihan mahasiswa lama");
                                System.out.println("0. Keluar dari Menu");
                                System.out.print("Pilih Nomor  : ");
                                int menuTagihan = input.nextInt();
                                Scanner menuTambahTagihan = new Scanner(System.in);
                                if (menuTagihan == 1) {
                                    System.out.print("Masukan nama Mahasiswa : ");
                                    String namaMahasiswa = menuTambahTagihan.nextLine();
                                    System.out.print("Nama Tagihan : ");
                                    String namaTagihan = menuTambahTagihan.nextLine();
                                    System.out.print("Jumlah Tagihan : Rp. ");
                                    int tagihan = menuTambahTagihan.nextInt();
                                    dataMahasiswa.add(new Mahasiswa(namaMahasiswa, tagihan, namaTagihan));
                                    System.out.printf(
                                            "Tagihan atas nama : %s nama tagihan : %s  Jumlah Tagihan : Rp. %d Berhasil Ditambahkan ",
                                            namaMahasiswa, namaTagihan, tagihan);
                                    System.out.println();

                                    break;
                                } else if (menuTagihan == 2) {
                                    System.out.print("Masukan nama Mahasiswa : ");
                                    String namaMahasiswa = menuTambahTagihan.nextLine();
                                    found: {
                                        for (Mahasiswa mahasiswa : dataMahasiswa) {
                                            if (mahasiswa.nama.equalsIgnoreCase(namaMahasiswa)) {
                                                mahasiswa.cekTagihan();
                                                System.out.println();
                                                System.out.println("=========================");
                                                System.out.print(
                                                        " Tambah Jumlah " + mahasiswa.namaTagihan
                                                                + " Tagihan : Rp. ");
                                                int tagihan = menuTambahTagihan.nextInt();
                                                mahasiswa.tambahTagihan(tagihan);
                                                System.out.println();
                                                break found;

                                            }
                                        }
                                        System.out.println(
                                                "Nama mahasiswa yang anda masukan tidak ada di daftar mohon lakukan pendaftaran baru");
                                        System.out.println();
                                    }

                                } else if (menuPilihan == 0) {
                                    break;
                                } else {
                                    System.out.println("Nomor Menu pilihan tidak valid  Keluar dari menu");
                                    break;
                                }
                            case 3:
                                Scanner menuBayarTagihan = new Scanner(System.in);
                                System.out.print("Masukan nama Mahasiswa : ");
                                String namaMahasiswa = menuBayarTagihan.nextLine();
                                found: {
                                    for (Mahasiswa mahasiswa : dataMahasiswa) {
                                        if (mahasiswa.nama.equalsIgnoreCase(namaMahasiswa)) {
                                            mahasiswa.cekTagihan();
                                            System.out.println();
                                            System.out.println("=========================");
                                            System.out.print(
                                                    " Tambah Jumlah " + mahasiswa.namaTagihan
                                                            + " Tagihan : Rp. ");
                                            int tagihan = menuBayarTagihan.nextInt();
                                            mahasiswa.bayarTagihan(tagihan);
                                            System.out.println();
                                            break found;

                                        }
                                    }
                                    System.out.println(
                                            "Nama mahasiswa yang anda masukan tidak ada di daftar Tagihan Pembayaran mohon lakukan pendaftaran baru");
                                    System.out.println();
                                }
                            default:
                                break;
                        }
                        if (nomorMenu == 0) {
                            break;
                        }
                    }

                } else {
                    System.out.println("Username Atau Password anda Salah");
                    System.out.println("Silahkan Masukan Kembali");
                }

            } else if (menuPilihan == 0) {

                inputScanner.close();
                break;

            } else {
                System.out.println("Nomor Menu Yang anda Masukan tidak Valid");
                System.out.println();
                continue;
            }
        }

    }

}
