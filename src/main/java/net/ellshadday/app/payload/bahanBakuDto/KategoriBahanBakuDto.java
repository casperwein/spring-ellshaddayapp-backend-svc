package net.ellshadday.app.payload.bahanBakuDto;

import lombok.Data;

@Data
public class KategoriBahanBakuDto {
    private long id;
    private String nama;
    private String keterangan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
