package net.ellshadday.app.payload.userDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDto {
    private long id;
    private String line;
    private String rt_rw;
    private String kelurahan;
    private String kecamatan;
    private String provinsi;
    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getRt_rw() {
        return rt_rw;
    }

    public void setRt_rw(String rt_rw) {
        this.rt_rw = rt_rw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
