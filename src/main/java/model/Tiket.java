/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Tiket {
    private static int counter = 1000;
 
    private String kodeTiket;
    private Penumpang penumpang;
    private Pesawat pesawat; // tipe superclass -> polymorphism saat runtime
    private String status;
 
    public Tiket(Penumpang penumpang, Pesawat pesawat) {
        counter++;
        this.kodeTiket = "TKT-" + counter;
        this.penumpang = penumpang;
        this.pesawat = pesawat;
        this.status = "AKTIF";
    }
 
    public String getKodeTiket() {
        return kodeTiket;
    }
 
    public Penumpang getPenumpang() {
        return penumpang;
    }
 
    public Pesawat getPesawat() {
        return pesawat;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void batalkan() {
        this.status = "DIBATALKAN";
    }
 
    public void cetakTiket() {
        System.out.println("======================================================");
        System.out.println("                  E-TIKET PESAWAT");
        System.out.println("======================================================");
        System.out.println("Kode Tiket   : " + kodeTiket);
        System.out.println("Status       : " + status);
        System.out.println("Penumpang    : " + penumpang);
        // Method di bawah ini adalah method milik Pesawat (superclass),
        // tapi hasilnya berbeda-beda tergantung objek aslinya (polymorphism)
        pesawat.tampilkanInfoPenerbangan();
        System.out.println("======================================================\n");
    }
}
 