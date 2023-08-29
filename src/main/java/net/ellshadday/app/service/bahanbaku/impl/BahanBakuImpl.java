package net.ellshadday.app.service.bahanbaku.impl;

import net.ellshadday.app.entity.bahanbaku.BahanBaku;
import net.ellshadday.app.entity.bahanbaku.KategoriBahanBaku;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.bahanBakuDto.BahanBakuDto;
import net.ellshadday.app.repository.bahanbaku.BahanBakuRepository;
import net.ellshadday.app.repository.bahanbaku.KategoriRepository;
import net.ellshadday.app.service.bahanbaku.BahanBakuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BahanBakuImpl implements BahanBakuService {
    private BahanBakuRepository bahanBakuRepository;
    private KategoriRepository kategoriRepository;

    public BahanBakuImpl(BahanBakuRepository bahanBakuRepository, KategoriRepository kategoriRepository) {
        this.bahanBakuRepository = bahanBakuRepository;
        this.kategoriRepository = kategoriRepository;
    }

    @Override
    public BahanBakuDto createBahanBaku(long kategoriId, BahanBakuDto bahanBakuDto) {

        KategoriBahanBaku baku_kategori = kategoriRepository.findById(kategoriId).orElseThrow(
                ()-> new ResourceNotFoundException("Bahan Baku", "kodebahan", kategoriId));

        BahanBaku bahanBaku = mapToEntity(bahanBakuDto);
        bahanBaku.setKategori(baku_kategori);
        BahanBaku newBahanBaku = bahanBakuRepository.save(bahanBaku);
        BahanBakuDto bahanBakuRes = mapToDTO(newBahanBaku);

        return bahanBakuRes;
    }

    @Override
    public List<BahanBakuDto> getBahanBakuByKodebahan(String kodebahan) {
        List<BahanBaku> bahanBaku = bahanBakuRepository.getBahanBakuByKodebahan(kodebahan);
        return bahanBaku.stream().map(
                bb -> mapToDTO(bb)).collect(Collectors.toList());
    }

    @Override
    public List<BahanBakuDto> getAllBahanBaku() {
        List<BahanBaku> bahanBaku = bahanBakuRepository.findAll();
        return bahanBaku.stream().map(baku -> mapToDTO(baku)).collect(Collectors.toList());
    }

    @Override
    public void deleteBahanBaku(String kodebahan) {
        List<BahanBaku> bahanBaku = bahanBakuRepository.getBahanBakuByKodebahan(kodebahan);

        bahanBakuRepository.deleteById(kodebahan);
    }

    public BahanBakuDto mapToDTO(BahanBaku bahanBaku){

        BahanBakuDto bahanBakuDto = new BahanBakuDto();
        KategoriBahanBaku kategoriBahanBaku = new KategoriBahanBaku();
        kategoriBahanBaku.setId(bahanBaku.getKategori().getId());
        System.out.println();
        bahanBakuDto.setKodebahan(bahanBaku.getKodebahan());
        bahanBakuDto.setNama(bahanBaku.getNama());
        bahanBakuDto.setWarna(bahanBaku.getWarna());
        bahanBakuDto.setRoll_ball_quantity(bahanBaku.getRoll_ball_quantity());
        bahanBakuDto.setGambar(bahanBaku.getGambar());
        bahanBakuDto.setTotal_yard_kg(bahanBaku.getTotal_yard_kg());
        bahanBakuDto.setYard_kg_clean(bahanBaku.getYard_kg_clean());
        bahanBakuDto.setYard_kg_sisa(bahanBaku.getYard_kg_sisa());
        bahanBakuDto.setSatuan(bahanBaku.getSatuan());
        bahanBakuDto.setUkuran(bahanBaku.getUkuran());
        bahanBakuDto.setSafety_stock(bahanBaku.getSafety_stock());
        bahanBakuDto.setKategori(kategoriBahanBaku.getId());

        return bahanBakuDto;
    }

    public BahanBaku mapToEntity(BahanBakuDto bahanBakuDto){
        BahanBaku bahanBaku = new BahanBaku();

        bahanBaku.setKodebahan(bahanBakuDto.getKodebahan());
        bahanBaku.setNama(bahanBakuDto.getNama());
        bahanBaku.setWarna(bahanBakuDto.getWarna());
        bahanBaku.setRoll_ball_quantity(bahanBakuDto.getRoll_ball_quantity());
        bahanBaku.setGambar(bahanBakuDto.getGambar());
        bahanBaku.setTotal_yard_kg(bahanBakuDto.getTotal_yard_kg());
        bahanBaku.setYard_kg_clean(bahanBakuDto.getYard_kg_clean());
        bahanBaku.setYard_kg_sisa(bahanBakuDto.getYard_kg_sisa());
        bahanBaku.setSatuan(bahanBakuDto.getSatuan());
        bahanBaku.setUkuran(bahanBakuDto.getUkuran());
        bahanBaku.setSafety_stock(bahanBakuDto.getSafety_stock());

        return bahanBaku;
    }
}
