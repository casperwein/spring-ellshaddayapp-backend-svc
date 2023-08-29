package net.ellshadday.app.payload.bahanBakuDto;

import lombok.Data;

import java.util.Date;

@Data
public class PembelianDto {
    private long id;
    private long suplierId;
    private String warna;
    private String kodebahan;
    private String bahan_bahu_desc;
    private Date tanggal_terima;
    private String tempat_penyimpanan;
    private int roll_ball_quantity;
    private float kg_yard_meter_quantity;
    private String is_return;
    private int roll_ball_return;
    private float yard_kg_meter_return;
    private String penerima;
    private String kurir;
    private double harga_satuan;
    private double total_harga;
    private String gambar;
    private String faktur;
    private String list;
    private String list_return;
    private long kategoriId;
}
