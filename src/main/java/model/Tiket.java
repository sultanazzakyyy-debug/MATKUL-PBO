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
    private Pesawat pesawat;
 
    public Tiket(Penumpang penumpang, Pesawat pesawat) {
        counter++;
        this.kodeTiket = "TKT-" + counter;
        this.penumpang = penumpang;
        this.pesawat = pesawat;
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
 
    public void cetakTiket() {
        System.out.println("==================================");
        System.out.println("           E-TIKET PESAWAT");
        System.out.println("==================================");
        System.out.println("Kode Tiket: " + kodeTiket);
        System.out.println("Penumpang : " + penumpang.getNama());
        System.out.println("No. HP    : " + penumpang.getNoHp());
        System.out.println("----------------------------------");
        pesawat.tampilkanInfo();
        System.out.println("==================================");
    }
}
 