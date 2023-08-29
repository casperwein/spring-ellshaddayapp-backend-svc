package net.ellshadday.app.service.bahanbaku;

import net.ellshadday.app.payload.bahanBakuDto.PembelianDto;

import java.util.List;

public interface PembelianService {
    PembelianDto createNewPembelian(PembelianDto pembelianDto);
    List<PembelianDto> getAllPembelian();
    List<PembelianDto> findById(long id);
    List<PembelianDto> getPembelianByKodebahan(String kodebahan);
    PembelianDto updatePembelian(long id, PembelianDto pembelianDto);

}
