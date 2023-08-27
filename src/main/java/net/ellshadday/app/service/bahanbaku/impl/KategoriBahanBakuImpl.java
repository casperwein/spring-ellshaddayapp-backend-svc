package net.ellshadday.app.service.bahanbaku.impl;

import net.ellshadday.app.entity.bahanbaku.KategoriBahanBaku;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.bahanBakuDto.KategoriBahanBakuDto;
import net.ellshadday.app.repository.bahanbaku.KategoriRepository;
import net.ellshadday.app.service.bahanbaku.KategoriBahanBakuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KategoriBahanBakuImpl implements KategoriBahanBakuService {

    private KategoriRepository kategoriRepository;

    public KategoriBahanBakuImpl(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    @Override
    public KategoriBahanBakuDto createKategori(KategoriBahanBakuDto kategoriBahanBakuDto) {

        KategoriBahanBaku kategoriBahanBaku = mapToEntity(kategoriBahanBakuDto);
        KategoriBahanBaku newKategori = kategoriRepository.save(kategoriBahanBaku);
        KategoriBahanBakuDto kategoriRes = mapToDTO(newKategori);

        return kategoriRes;
    }

    @Override
    public List<KategoriBahanBakuDto> getAllKategori() {
        List<KategoriBahanBaku> kategoriBahanBakus = kategoriRepository.findAll();

        return kategoriBahanBakus.stream().map(
                kategori -> mapToDTO(kategori)).collect(Collectors.toList());
    }

    @Override
    public List<KategoriBahanBakuDto> getKategoriByIdKategori(long kategoriId) {
        List<KategoriBahanBaku> kategoriBahanBaku = kategoriRepository.findKategoriById(kategoriId);

        return kategoriBahanBaku.stream().map(
                kategori -> mapToDTO(kategori)).collect(Collectors.toList());
    }

    @Override
    public KategoriBahanBakuDto updateKategoriBahanBaku(long kategoriId, KategoriBahanBakuDto kategoriBahanBakuDto) {
        KategoriBahanBaku kategoriBahanBaku = kategoriRepository.findById(kategoriId).orElseThrow(
                () -> new ResourceNotFoundException("Kategori", "id", kategoriId));
        kategoriBahanBaku.setNama(kategoriBahanBakuDto.getNama());
        kategoriBahanBaku.setKeterangan(kategoriBahanBakuDto.getKeterangan());

        KategoriBahanBaku kategoriBahanBakuUpdated = kategoriRepository.save(kategoriBahanBaku);

        return mapToDTO(kategoriBahanBakuUpdated);
    }

    @Override
    public void deleteKategori(long kategoriId) {
        KategoriBahanBaku kategoriBahanBaku = kategoriRepository.findById(kategoriId).orElseThrow(
                () -> new ResourceNotFoundException("Kategori", "id", kategoriId));
        kategoriRepository.delete(kategoriBahanBaku);
    }

    private KategoriBahanBakuDto mapToDTO(KategoriBahanBaku kategoriBahanBaku){
        KategoriBahanBakuDto kategoriBahanBakuDto = new KategoriBahanBakuDto();

        kategoriBahanBakuDto.setId(kategoriBahanBaku.getId());
        kategoriBahanBakuDto.setNama(kategoriBahanBaku.getNama());
        kategoriBahanBakuDto.setKeterangan(kategoriBahanBaku.getKeterangan());
        return kategoriBahanBakuDto;
    }

    private KategoriBahanBaku mapToEntity(KategoriBahanBakuDto kategoriBahanBakuDto){
        KategoriBahanBaku kategoriBahanBaku = new KategoriBahanBaku();

        kategoriBahanBaku.setId(kategoriBahanBakuDto.getId());
        kategoriBahanBaku.setNama(kategoriBahanBakuDto.getNama());
        kategoriBahanBaku.setKeterangan(kategoriBahanBakuDto.getKeterangan());

        return kategoriBahanBaku;
    }
}
