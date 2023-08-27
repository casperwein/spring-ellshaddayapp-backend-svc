package net.ellshadday.app.payload.bahanBakuDto;

import lombok.Data;
import net.ellshadday.app.entity.bahanbaku.KategoriBahanBaku;

@Data
public class BahanBakuDto {
    private String kodebahan;
    private String nama;
    private String warna;
    private String gambar;
    private long roll_ball_quantity;
    private float total_yard_kg;
    private float yard_kg_clean;
    private float yard_kg_sisa;
    private String satuan;
    private String ukuran;
    private int safety_stock;

    private long kategori;

    public long getKategori() {
        return kategori;
    }

    public void setKategori(long kategori) {
        this.kategori = kategori;
    }

    public String getKodebahan() {
        return kodebahan;
    }

    public void setKodebahan(String kodebahan) {
        this.kodebahan = kodebahan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public long getRoll_ball_quantity() {
        return roll_ball_quantity;
    }

    public void setRoll_ball_quantity(long roll_ball_quantity) {
        this.roll_ball_quantity = roll_ball_quantity;
    }

    public float getTotal_yard_kg() {
        return total_yard_kg;
    }

    public void setTotal_yard_kg(float total_yard_kg) {
        this.total_yard_kg = total_yard_kg;
    }

    public float getYard_kg_clean() {
        return yard_kg_clean;
    }

    public void setYard_kg_clean(float yard_kg_clean) {
        this.yard_kg_clean = yard_kg_clean;
    }

    public float getYard_kg_sisa() {
        return yard_kg_sisa;
    }

    public void setYard_kg_sisa(float yard_kg_sisa) {
        this.yard_kg_sisa = yard_kg_sisa;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getSafety_stock() {
        return safety_stock;
    }

    public void setSafety_stock(int safety_stock) {
        this.safety_stock = safety_stock;
    }
}

