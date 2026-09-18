/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import java.util.Scanner;
import model.Penumpang;
import model.Pesawat;
import model.Pesawatbisnis;
import model.Pesawatekonomi;
import model.Pesawatfirstclass;
import model.Sistempemesanan;
import model.Tiket;

/**
 *
 * @author Adbang 18
 */
public class Main {
 
    private static final Scanner scanner = new Scanner(System.in);
    private static final Sistempemesanan sistem = new Sistempemesanan();
 
    public static void main(String[] args) {
        inisialisasiDataPenerbangan();
 
        boolean berjalan = true;
        while (berjalan) {
            tampilkanMenu();
            int pilihan = bacaPilihanMenu();
 
            switch (pilihan) {
                case 1 -> sistem.tampilkanDaftarPenerbangan();
                case 2 -> prosesPemesananTiket();
                case 3 -> sistem.tampilkanSemuaTiket();
                case 4 -> prosesLihatDetailTiket();
                case 5 -> prosesBatalkanTiket();
                case 0 -> {
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Pemesanan Tiket Pesawat!");
                }
                default -> System.out.println("\nPilihan tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
 
    // Data awal contoh: 3 penerbangan dengan 3 kelas layanan berbeda (subclass berbeda)
    private static void inisialisasiDataPenerbangan() {
        sistem.tambahPenerbangan(new Pesawatekonomi("GA-201", "Garuda Indonesia",
                "Jakarta", "Samarinda", "07:00", 1200000));
        sistem.tambahPenerbangan(new Pesawatbisnis("QG-450", "Citilink",
                "Surabaya", "Balikpapan", "09:30", 1500000));
        sistem.tambahPenerbangan(new Pesawatfirstclass("SJ-777", "Sriwijaya Air",
                "Jakarta", "Denpasar", "13:15", 2000000));
        sistem.tambahPenerbangan(new Pesawatekonomi("JT-118", "Lion Air",
                "Medan", "Jakarta", "16:45", 950000));
    }
 
    private static void tampilkanMenu() {
        System.out.println("\n============ SISTEM PEMESANAN TIKET PESAWAT ============");
        System.out.println("1. Lihat Daftar Penerbangan");
        System.out.println("2. Pesan Tiket");
        System.out.println("3. Lihat Semua Tiket");
        System.out.println("4. Lihat Detail / Cetak Tiket");
        System.out.println("5. Batalkan Tiket");
        System.out.println("0. Keluar");
        System.out.println("==========================================================");
        System.out.print("Pilih menu: ");
    }
 
    private static int bacaPilihanMenu() {
    int pilihan = scanner.nextInt();
    scanner.nextLine();
    return pilihan;
    }
 
    private static void prosesPemesananTiket() {
        sistem.tampilkanDaftarPenerbangan();
        System.out.print("\nPilih nomor penerbangan yang ingin dipesan: ");
        int nomor;
        nomor = scanner.nextInt();
        scanner.nextLine();
 
        Pesawat pesawatDipilih = sistem.getPenerbanganByIndex(nomor - 1);
        if (pesawatDipilih == null) {
            System.out.println("Nomor penerbangan tidak ditemukan.");
            return;
        }
 
        System.out.print("Masukkan nama penumpang : ");
        String nama = scanner.nextLine().trim();
        System.out.print("Masukkan NIK            : ");
        String nik = scanner.nextLine().trim();
        System.out.print("Masukkan No. HP         : ");
        String noHp = scanner.nextLine().trim();
 
        Penumpang penumpang = new Penumpang(nama, nik, noHp);
        Tiket tiket = sistem.pesanTiket(penumpang, pesawatDipilih);
 
        System.out.println("\nPemesanan berhasil! Berikut e-tiket Anda:");
        tiket.cetakTiket();
    }
 
    private static void prosesLihatDetailTiket() {
        System.out.print("\nMasukkan kode tiket (contoh: TKT-1001): ");
        String kode = scanner.nextLine().trim();
        Tiket tiket = sistem.cariTiket(kode);
        if (tiket == null) {
            System.out.println("Tiket dengan kode " + kode + " tidak ditemukan.");
            return;
        }
        tiket.cetakTiket();
    }
 
    private static void prosesBatalkanTiket() {
        System.out.print("\nMasukkan kode tiket yang ingin dibatalkan: ");
        String kode = scanner.nextLine().trim();
        boolean berhasil = sistem.batalkanTiket(kode);
        if (berhasil) {
            System.out.println("Tiket " + kode + " berhasil dibatalkan.");
        } else {
            System.out.println("Tiket dengan kode " + kode + " tidak ditemukan.");
        }
    }
}
 