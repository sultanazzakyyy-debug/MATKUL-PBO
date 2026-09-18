/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Adbang 18
 */
public class Penumpang {
    private String nama;
    private String nik;
    private String noHp;
 
    public Penumpang(String nama, String nik, String noHp) {
        this.nama = nama;
        this.nik = nik;
        this.noHp = noHp;
    }
 
    public String getNama() {
        return nama;
    }
 
    public String getNik() {
        return nik;
    }
 
    public String getNoHp() {
        return noHp;
    }
 
}
 