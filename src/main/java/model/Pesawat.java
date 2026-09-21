/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Pesawat {
 
    private String kodePenerbangan;
    private String maskapai;
    private String asal;
    private String tujuan;
    private double hargaDasar;
 
    public Pesawat(String kodePenerbangan, String maskapai,
                   String asal, String tujuan, double hargaDasar) {
        this.kodePenerbangan = kodePenerbangan;
        this.maskapai = maskapai;
        this.asal = asal;
        this.tujuan = tujuan;
        this.hargaDasar = hargaDasar;
    }
 
    public String getKodePenerbangan() {
        return kodePenerbangan;
    }
 
    public String getMaskapai() {
        return maskapai;
    }
 
    public String getAsal() {
        return asal;
    }
 
    public String getTujuan() {
        return tujuan;
    }
 
    public double getHargaDasar() {
        return hargaDasar;
    }
 
    public double hitungHargaTiket() {
        return hargaDasar;
    }
 
    public String getKelasLayanan() {
        return "Umum";
    }
 
    public String getFasilitas() {
        return "-";
    }
 
    public void tampilkanInfo() {
        System.out.println("Kode      : " + kodePenerbangan);
        System.out.println("Maskapai  : " + maskapai);
        System.out.println("Rute      : " + asal + " -> " + tujuan);
        System.out.println("Kelas     : " + getKelasLayanan());
        System.out.println("Fasilitas : " + getFasilitas());
        System.out.printf("Harga     : Rp%,.0f%n", hitungHargaTiket());
    }
}