/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author Adbang 18
 */
public class Sistempemesanan {

    private ArrayList<Pesawat> daftarPenerbangan;
    private ArrayList<Tiket> daftarTiket;

    public Sistempemesanan() {
        daftarPenerbangan = new ArrayList<>();
        daftarTiket = new ArrayList<>();
    }

    public void tambahPenerbangan(Pesawat pesawat) {
        daftarPenerbangan.add(pesawat);
    }

    public ArrayList<Pesawat> getDaftarPenerbangan() {
        return daftarPenerbangan;
    }

    public ArrayList<Tiket> getDaftarTiket() {
        return daftarTiket;
    }

    public void tampilkanDaftarPenerbangan() {

        System.out.println("\n==================== DAFTAR PENERBANGAN ====================");

        System.out.println("No | Kode | Maskapai | Asal | Tujuan | Berangkat | Kelas | Harga");

        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < daftarPenerbangan.size(); i++) {

            Pesawat p = daftarPenerbangan.get(i);

            System.out.println(
                    (i + 1) + " | "
                    + p.getKodePenerbangan() + " | "
                    + p.getMaskapai() + " | "
                    + p.getAsal() + " | "
                    + p.getTujuan() + " | "
                    + p.getWaktuBerangkat() + " | "
                    + p.getKelasLayanan() + " | Rp"
                    + p.hitungHargaTiket()
            );
        }

        System.out.println("==============================================================");
    }

    public Pesawat getPenerbanganByIndex(int index) {

        if (index < 0 || index >= daftarPenerbangan.size()) {
            return null;
        }

        return daftarPenerbangan.get(index);
    }

    public Tiket pesanTiket(Penumpang penumpang, Pesawat pesawat) {

        Tiket tiket = new Tiket(penumpang, pesawat);

        daftarTiket.add(tiket);

        return tiket;
    }

    public void tampilkanSemuaTiket() {

        if (daftarTiket.isEmpty()) {
            System.out.println("\nBelum ada tiket yang dipesan.");
            return;
        }

        System.out.println("\n==================== DAFTAR SELURUH TIKET ====================");

        for (int i = 0; i < daftarTiket.size(); i++) {

            Tiket t = daftarTiket.get(i);

            System.out.println(
                    (i + 1) + ". "
                    + t.getKodeTiket() + " | "
                    + t.getPenumpang().getNama() + " | "
                    + t.getPesawat().getKodePenerbangan() + " | "
                    + t.getPesawat().getKelasLayanan() + " | "
                    + t.getStatus()
            );
        }

        System.out.println("==============================================================");
    }

    public Tiket cariTiket(String kodeTiket) {

        for (int i = 0; i < daftarTiket.size(); i++) {

            Tiket t = daftarTiket.get(i);

            if (t.getKodeTiket().equals(kodeTiket)) {
                return t;
            }
        }

        return null;
    }

    public boolean batalkanTiket(String kodeTiket) {

        Tiket t = cariTiket(kodeTiket);

        if (t == null) {
            return false;
        }

        t.batalkan();

        return true;
    }
}