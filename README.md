# ✈️ Sistem Pemesanan Tiket Pesawat
### — Pemrograman Berorientasi Objek

---

## 1. 👤 Identitas Mahasiswa

| | |
|---|---|
| **Nama** | Muhammad Nadhir Sultan Azzaky |
| **NIM** | 2509116080 |
| **Kelas** | Sistem Informasi 25'B |

---

## 2. 📝 Penjelasan Studi Kasus

Studi kasus yang dipilih adalah **Sistem Pemesanan Tiket Pesawat** berbasis command line.

Alasan milih tema ini: di dalam dunia nyata, satu penerbangan bisa punya beberapa kelas layanan (Ekonomi, Bisnis, First Class) yang datanya sebenarnya mirip sama-sama punya kode penerbangan, maskapai, asal, dan tujuan tapi **cara ngitung harga sama fasilitasnya beda-beda**. Kasus seperti ini pas banget untuk nerapin inheritance, karena data yang samanya bisa ditaruh di satu class induk, dan yang bedanya dipisah ke class anak masing-masing.

---

## 3. 🧩 Diagram Kelas & Hierarki Class

### Diagram Pewarisan

```
                       Pesawat  (superclass)
                          ▲
                          │  extends
        ┌─────────────────┼─────────────────┐
        │                 │                 │
 Pesawatekonomi    Pesawatbisnis    Pesawatfirstclass
    (× 1.0)           (× 1.6)            (× 2.5)
```

### Relasi Antar Objek

```
Main
 ├── ArrayList<Pesawat>  daftarPenerbangan
 └── ArrayList<Tiket>    daftarTiket
                            │
                          Tiket
                            ├── Penumpang  penumpang
                            └── Pesawat    pesawat   ← bisa diisi subclass mana saja
```

### Struktur File

```
src/main/java/
├── com/mycompany/main/
│   └── Main.java                ← entry point (menu + penyimpanan data)
└── model/
    ├── Penumpang.java
    ├── Pesawat.java             ← superclass
    ├── Pesawatekonomi.java      ← subclass
    ├── Pesawatbisnis.java       ← subclass
    ├── Pesawatfirstclass.java   ← subclass
    └── Tiket.java
```

### Penjelasan Tiap Class

| Class | Peran | Atribut |
|---|---|---|
| `Penumpang` | Data diri penumpang | `nama`, `noHp` |
| `Pesawat` | **Superclass**, data umum penerbangan | `kodePenerbangan`, `maskapai`, `asal`, `tujuan`, `hargaDasar` |
| `Pesawatekonomi` | **Subclass** kelas Ekonomi | — (warisan dari `Pesawat`) |
| `Pesawatbisnis` | **Subclass** kelas Bisnis | — (warisan dari `Pesawat`) |
| `Pesawatfirstclass` | **Subclass** kelas First Class | — (warisan dari `Pesawat`) |
| `Tiket` | Gabungan `Penumpang` + `Pesawat` | `kodeTiket`, `penumpang`, `pesawat`, `counter` (static) |
| `Main` | Menu, input user, dan penyimpanan data | `daftarPenerbangan`, `daftarTiket` |

---

## 4. 🧬 Bagian Kode yang Menerapkan Inheritance

### a. Superclass `Pesawat`

Class ini nampung semua atribut dan method yang **dipakai bareng-bareng** sama ketiga kelas layanan.

```java
public class Pesawat {

    private String kodePenerbangan;
    private String maskapai;
    private String asal;
    private String tujuan;
    private double hargaDasar;

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
        System.out.println("Kelas     : " + getKelasLayanan());  
        System.out.println("Fasilitas : " + getFasilitas());     
        System.out.printf("Harga     : Rp%,.0f%n", hitungHargaTiket());
    }
}
```

### b. Subclass pakai `extends` dan `super()`

Ketiga subclass polanya sama: pakai kata kunci **`extends`** buat mewarisi `Pesawat`, dan constructor-nya cuma nerusin parameter ke induknya pakai **`super(...)`** — atributnya nggak perlu ditulis ulang.

```java
public class Pesawatbisnis extends Pesawat {        

    public Pesawatbisnis(String kodePenerbangan, String maskapai,
                         String asal, String tujuan, double hargaDasar) {

        super(kodePenerbangan, maskapai,             
              asal, tujuan, hargaDasar);
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
```

**Perbandingan hasil override ketiga subclass:**

| Subclass | `hitungHargaTiket()` | `getKelasLayanan()` | `getFasilitas()` |
|---|---|---|---|
| `Pesawatekonomi` | `hargaDasar` | `"Ekonomi"` | `"Snack"` |
| `Pesawatbisnis` | `hargaDasar + (hargaDasar × 0.6)` | `"Bisnis"` | `"Bagasi dan Lounge"` |
| `Pesawatfirstclass` | `hargaDasar + (hargaDasar × 1.5)` | `"First Class"` | `"Lounge VIP"` |

Contoh kalau harga dasarnya **Rp2.000.000**:
- Ekonomi → **Rp2.000.000**
- Bisnis → 2.000.000 + (2.000.000 × 0,6) = **Rp3.200.000**
- First Class → 2.000.000 + (2.000.000 × 1,5) = **Rp5.000.000**

### c. Polymorphism — hasil nyata dari inheritance

Karena ketiga subclass itu "adalah" `Pesawat`, semuanya bisa ditampung di **satu `ArrayList<Pesawat>` yang sama**:

```java
private static final ArrayList<Pesawat> daftarPenerbangan = new ArrayList<>();

daftarPenerbangan.add(new Pesawatekonomi("GA-201", "Garuda Indonesia",
        "Jakarta", "Samarinda", 1200000));
daftarPenerbangan.add(new Pesawatbisnis("QG-450", "Citilink",
        "Surabaya", "Balikpapan", 1500000));
daftarPenerbangan.add(new Pesawatfirstclass("SJ-777", "Sriwijaya Air",
        "Jakarta", "Denpasar", 2000000));
```

Pas ditampilin, cukup **satu baris kode yang sama** buat semua objek — tapi hasilnya beda sesuai objek aslinya:

```java
for (int i = 0; i < daftarPenerbangan.size(); i++) {
    Pesawat p = daftarPenerbangan.get(i);
    System.out.printf("%s | Rp%,.0f%n", p.getKelasLayanan(), p.hitungHargaTiket());
    // GA-201 → "Ekonomi | Rp1.200.000"
    // QG-450 → "Bisnis | Rp2.400.000"
    // SJ-777 → "First Class | Rp5.000.000"
}
```

Hal yang sama juga kepakai di class `Tiket`, yang nyimpen atribut bertipe superclass:

```java
public class Tiket {
    private Pesawat pesawat;   // 

    public void cetakTiket() {
        pesawat.tampilkanInfo();  //
    }
}
```

**Kesimpulannya:** atribut dan method yang sama cukup ditulis **sekali** di `Pesawat`, sementara yang beda dipisah ke subclass masing-masing. Kalau nanti mau nambah kelas baru (misalnya *Premium Economy*), tinggal bikin satu file subclass baru tanpa ngubah kode yang sudah ada.

---

## 5. 📸 Screenshot Program Berjalan

### a. Tampilan Menu Awal

<img width="246" height="82" alt="Opsi 0new" src="https://github.com/user-attachments/assets/f08f8bda-3200-40ce-be35-9a6728c2ae70" />

Tampilan pertama begitu program di-*run*. Ada 4 pilihan menu, dan program nunggu user ngetik angka di baris `Pilih menu:`.

### b. Menu 1 — Lihat Daftar Penerbangan (Read)

<img width="432" height="88" alt="Opsi 1" src="https://github.com/user-attachments/assets/e65e6951-d06d-4f6b-9909-9157affe6d4d" />

Muncul 3 penerbangan yang di-*load* di awal. Perhatiin kolom **Kelas** dan **Harga**: GA-201 (Ekonomi) harganya sama persis dengan harga dasar Rp1.200.000, sementara SJ-777 (First Class) harganya naik jadi Rp5.000.000 - padahal baris kode yang nyetak keduanya sama. Ini bukti polymorphism-nya jalan.

### c. Menu 2 — Pesan Tiket (Create)

<img width="427" height="347" alt="Opsi 2" src="https://github.com/user-attachments/assets/6937414b-492c-4130-891c-cfe8d046686c" />

User milih nomor penerbangan, lalu ngisi nama dan No. HP. Objek `Penumpang` dan `Tiket` kebentuk, dimasukin ke `ArrayList`, dan e-tiketnya langsung dicetak lengkap dengan kode tiket `TKT-1001`.

### d. Menu 3 — Lihat Semua Tiket (Read)

<img width="300" height="64" alt="Opsi 3" src="https://github.com/user-attachments/assets/cf260c17-5a10-406c-b94e-233ace3a4057" />

Tiket yang barusan dibuat muncul dalam bentuk ringkasan satu baris: kode tiket, nama penumpang, kode penerbangan, kelas layanan, dan harga.

### e. Menu 0 — Keluar

<img width="370" height="118" alt="opsi0" src="https://github.com/user-attachments/assets/c2dd0e98-9ade-4cfa-9c47-903e61d15d60" />

Program nyetak pesan penutup, loop `while` berhenti, dan `scanner` ditutup. Program selesai (`BUILD SUCCESS`).
