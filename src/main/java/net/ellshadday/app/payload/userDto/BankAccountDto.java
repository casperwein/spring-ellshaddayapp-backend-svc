package net.ellshadday.app.payload.userDto;

import lombok.Data;

@Data
public class BankAccountDto {
    private long id;
    private String namaBank;
    private String kodeBank;
    private long nomor;
    private String nama;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getKodeBank() {
        return kodeBank;
    }

    public void setKodeBank(String kodeBank) {
        this.kodeBank = kodeBank;
    }

    public long getNomor() {
        return nomor;
    }

    public void setNomor(long nomor) {
        this.nomor = nomor;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
