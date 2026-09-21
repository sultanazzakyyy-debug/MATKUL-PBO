/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Pesawatekonomi extends Pesawat {
 
    public Pesawatekonomi(String kodePenerbangan, String maskapai,
                          String asal, String tujuan, double hargaDasar) {
        super(kodePenerbangan, maskapai, asal, tujuan, hargaDasar);
    }
 
    public double hitungHargaTiket() {
        return getHargaDasar();
    }
 
    public String getKelasLayanan() {
        return "Ekonomi";
    }
 
    public String getFasilitas() {
        return "Snack";
    }
}