package net.ellshadday.app.payload.produksi;

import lombok.Data;

import java.util.Date;

@Data
public class ProdukDto {
    private long po;
    private String nama_produk;
    private String kodebahan;
    private String attributes;
    private long cutter_id;
    private long cmt_id;
    private long quantity;
    private String proggress;
    private String gambar;
    private Date tanggal_produksi;
}
