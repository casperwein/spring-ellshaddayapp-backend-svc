package net.ellshadday.app.payload.bahanBakuDto;

import lombok.Data;

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


}

