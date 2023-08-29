package net.ellshadday.app.service.bahanbaku;

import net.ellshadday.app.payload.bahanBakuDto.BahanBakuDto;

import java.util.List;

public interface BahanBakuService {
    BahanBakuDto createBahanBaku(long kategoriId, BahanBakuDto bahanBakuDto);
    List<BahanBakuDto> getBahanBakuByKodebahan(String kodebahan);
    List<BahanBakuDto> getAllBahanBaku();
    void deleteBahanBaku(String kodebahan);
}
