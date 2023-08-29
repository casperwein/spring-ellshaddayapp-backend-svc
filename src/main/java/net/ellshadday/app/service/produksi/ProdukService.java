package net.ellshadday.app.service.produksi;

import net.ellshadday.app.payload.produksi.ProdukDto;

import java.util.List;

public interface ProdukService {
    ProdukDto createProduk(ProdukDto produkDto);
    List<ProdukDto> getAllProduk();
    List<ProdukDto> getProdukByPo(long po);
}
