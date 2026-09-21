/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Pesawatbisnis extends Pesawat {
 
    public Pesawatbisnis(String kodePenerbangan, String maskapai,
                         String asal, String tujuan, double hargaDasar) {
        super(kodePenerbangan, maskapai, asal, tujuan, hargaDasar);
    }
 
    public double hitungHargaTiket() {
        return getHargaDasar() + (getHargaDasar() * 0.6);
    }
 
    public String getKelasLayanan() {
        return "Bisnis";
    }
 
    public String getFasilitas() {
        return "Bagasi dan Lounge";
    }
}