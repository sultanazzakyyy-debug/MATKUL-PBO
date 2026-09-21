/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Pesawatfirstclass extends Pesawat {
 
    public Pesawatfirstclass(String kodePenerbangan, String maskapai,
                             String asal, String tujuan, double hargaDasar) {
        super(kodePenerbangan, maskapai, asal, tujuan, hargaDasar);
    }
 
    public double hitungHargaTiket() {
        return getHargaDasar() + (getHargaDasar() * 1.5);
    }
 
    public String getKelasLayanan() {
        return "First Class";
    }
 
    public String getFasilitas() {
        return "Lounge VIP";
    }
}