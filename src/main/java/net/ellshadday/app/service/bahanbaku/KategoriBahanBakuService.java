package net.ellshadday.app.service.bahanbaku;

import net.ellshadday.app.payload.bahanBakuDto.KategoriBahanBakuDto;

import java.util.List;

public interface KategoriBahanBakuService {
    KategoriBahanBakuDto createKategori(KategoriBahanBakuDto kategoriBahanBakuDto);

    List<KategoriBahanBakuDto> getAllKategori();
    List<KategoriBahanBakuDto> getKategoriByIdKategori(long kategoriId);
    KategoriBahanBakuDto updateKategoriBahanBaku(long kategoriId, KategoriBahanBakuDto kategoriBahanBakuDto);
    void deleteKategori(long kategoriId);
}
