package net.ellshadday.app.service.bahanbaku.impl;

import net.ellshadday.app.entity.bahanbaku.BahanBaku;
import net.ellshadday.app.entity.bahanbaku.Pembelian;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.bahanBakuDto.BahanBakuDto;
import net.ellshadday.app.payload.bahanBakuDto.PembelianDto;
import net.ellshadday.app.repository.bahanbaku.BahanBakuRepository;
import net.ellshadday.app.repository.bahanbaku.PembelianRepository;
import net.ellshadday.app.service.bahanbaku.BahanBakuService;
import net.ellshadday.app.service.bahanbaku.PembelianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PembelianServiceImpl implements PembelianService {
    private PembelianRepository pembelianRepository;
    private BahanBakuRepository bahanBakuRepository;
    private BahanBakuService bahanBakuService;

    public PembelianServiceImpl(PembelianRepository pembelianRepository, BahanBakuRepository bahanBakuRepository, BahanBakuService bahanBakuService) {
        this.pembelianRepository = pembelianRepository;
        this.bahanBakuRepository = bahanBakuRepository;
        this.bahanBakuService = bahanBakuService;
    }

    @Override
    public PembelianDto createNewPembelian(PembelianDto pembelianDto) {
        String kodebahan = pembelianDto.getKodebahan();
        BahanBakuDto bahanBakuDto = new BahanBakuDto();

        if(bahanBakuRepository.existsById(kodebahan)){
            BahanBaku bahan = bahanBakuRepository.getBykodebahan(kodebahan);
            long currentRoll = bahan.getRoll_ball_quantity();
            float currentYardKgClean = bahan.getYard_kg_clean();
            long addNewRoll = pembelianDto.getRoll_ball_quantity();
            float addNewYardKgClean = pembelianDto.getKg_yard_meter_quantity();
            float curYardKg = bahan.getTotal_yard_kg();

            bahan.setTotal_yard_kg(curYardKg + pembelianDto.getKg_yard_meter_quantity());
            bahan.setRoll_ball_quantity(currentRoll + addNewRoll);
            bahan.setYard_kg_clean(currentYardKgClean + addNewYardKgClean);

            bahanBakuRepository.save(bahan);
        } else {
            long kategoriId = pembelianDto.getKategoriId();

            bahanBakuDto.setKodebahan(pembelianDto.getKodebahan());
            bahanBakuDto.setNama("");
            bahanBakuDto.setRoll_ball_quantity(pembelianDto.getRoll_ball_quantity());
            bahanBakuDto.setGambar(pembelianDto.getGambar());
            bahanBakuDto.setTotal_yard_kg(pembelianDto.getKg_yard_meter_quantity());
            bahanBakuDto.setYard_kg_clean(pembelianDto.getKg_yard_meter_quantity());
            bahanBakuDto.setYard_kg_sisa(0);
            bahanBakuDto.setSatuan("");
            bahanBakuDto.setUkuran("");
            bahanBakuDto.setSafety_stock(0);

            bahanBakuService.createBahanBaku(kategoriId, bahanBakuDto);
        }

        Pembelian newPembelian = mapToEntity(pembelianDto);
        Pembelian pembelian = pembelianRepository.save(newPembelian);
        PembelianDto pembelianRes = mapToDTO(pembelian);

        return pembelianRes;
    }

    @Override
    public List<PembelianDto> getAllPembelian() {
        List<Pembelian> pembelian = pembelianRepository.findAll();
        return pembelian.stream().map(p -> mapToDTO(p)).collect(Collectors.toList());
    }

    @Override
    public List<PembelianDto> findById(long id) {
        List<Pembelian> pembelian = pembelianRepository.findPembelianById(id);
        return pembelian.stream().map(dd -> mapToDTO(dd)).collect(Collectors.toList());
    }

    @Override
    public List<PembelianDto> getPembelianByKodebahan(String kodebahan) {
        List<Pembelian> pembelian = pembelianRepository.findBykodebahan(kodebahan);
        return pembelian.stream().map(dd -> mapToDTO(dd)).collect(Collectors.toList());
    }

    @Override
    public PembelianDto updatePembelian(long id, PembelianDto pembelianDto) {
        Pembelian pembelian = pembelianRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("BankAccount", "id", id));

        pembelian.setSuplierId(pembelianDto.getSuplierId());
        pembelian.setWarna(pembelianDto.getWarna());
        pembelian.setKodebahan(pembelianDto.getKodebahan());
        pembelian.setBahan_bahu_desc(pembelianDto.getBahan_bahu_desc());
        pembelian.setTanggal_terima(pembelianDto.getTanggal_terima());
        pembelian.setTempat_penyimpanan(pembelianDto.getTempat_penyimpanan());
        pembelian.setRoll_ball_quantity(pembelianDto.getRoll_ball_quantity());
        pembelian.setKg_yard_meter_quantity(pembelianDto.getKg_yard_meter_quantity());
        pembelian.setIs_return(pembelianDto.getIs_return());
        pembelian.setRoll_ball_return(pembelianDto.getRoll_ball_return());
        pembelian.setYard_kg_meter_return(pembelianDto.getYard_kg_meter_return());
        pembelian.setPenerima(pembelianDto.getPenerima());
        pembelian.setKurir(pembelianDto.getKurir());
        pembelian.setHarga_satuan(pembelianDto.getHarga_satuan());
        pembelian.setTotal_harga(pembelianDto.getTotal_harga());
        pembelian.setGambar(pembelianDto.getGambar());
        pembelian.setFaktur(pembelianDto.getFaktur());
        pembelian.setList(pembelianDto.getList());
        pembelian.setList_return(pembelianDto.getList_return());
        pembelian.setKategoriId(pembelianDto.getKategoriId());

        Pembelian pembelianUpdate = pembelianRepository.save(pembelian);

        return mapToDTO(pembelianUpdate);
    }

    public PembelianDto mapToDTO(Pembelian pembelian){
        PembelianDto pembelianDto = new PembelianDto();

        pembelianDto.setId(pembelian.getId());
        pembelianDto.setSuplierId(pembelian.getSuplierId());
        pembelianDto.setWarna(pembelian.getWarna());
        pembelianDto.setKodebahan(pembelian.getKodebahan());
        pembelianDto.setBahan_bahu_desc(pembelian.getBahan_bahu_desc());
        pembelianDto.setTanggal_terima(pembelian.getTanggal_terima());
        pembelianDto.setTempat_penyimpanan(pembelian.getTempat_penyimpanan());
        pembelianDto.setRoll_ball_quantity(pembelian.getRoll_ball_quantity());
        pembelianDto.setKg_yard_meter_quantity(pembelian.getKg_yard_meter_quantity());
        pembelianDto.setIs_return(pembelian.getIs_return());
        pembelianDto.setRoll_ball_return(pembelian.getRoll_ball_return());
        pembelianDto.setYard_kg_meter_return(pembelian.getYard_kg_meter_return());
        pembelianDto.setPenerima(pembelian.getPenerima());
        pembelianDto.setKurir(pembelian.getKurir());
        pembelianDto.setHarga_satuan(pembelian.getHarga_satuan());
        pembelianDto.setTotal_harga(pembelian.getTotal_harga());
        pembelianDto.setGambar(pembelian.getGambar());
        pembelianDto.setFaktur(pembelian.getFaktur());
        pembelianDto.setList(pembelian.getList());
        pembelianDto.setList_return(pembelian.getList_return());
        pembelianDto.setKategoriId(pembelian.getKategoriId());

        return pembelianDto;
    }

    public Pembelian mapToEntity(PembelianDto pembelianDto){
        Pembelian pembelian = new Pembelian();

        pembelian.setId(pembelianDto.getId());
        pembelian.setSuplierId(pembelianDto.getSuplierId());
        pembelian.setWarna(pembelianDto.getWarna());
        pembelian.setKodebahan(pembelianDto.getKodebahan());
        pembelian.setBahan_bahu_desc(pembelianDto.getBahan_bahu_desc());
        pembelian.setTanggal_terima(pembelianDto.getTanggal_terima());
        pembelian.setTempat_penyimpanan(pembelianDto.getTempat_penyimpanan());
        pembelian.setRoll_ball_quantity(pembelianDto.getRoll_ball_quantity());
        pembelian.setKg_yard_meter_quantity(pembelianDto.getKg_yard_meter_quantity());
        pembelian.setIs_return(pembelianDto.getIs_return());
        pembelian.setRoll_ball_return(pembelianDto.getRoll_ball_return());
        pembelian.setYard_kg_meter_return(pembelianDto.getYard_kg_meter_return());
        pembelian.setPenerima(pembelianDto.getPenerima());
        pembelian.setKurir(pembelianDto.getKurir());
        pembelian.setHarga_satuan(pembelianDto.getHarga_satuan());
        pembelian.setTotal_harga(pembelianDto.getTotal_harga());
        pembelian.setGambar(pembelianDto.getGambar());
        pembelian.setFaktur(pembelianDto.getFaktur());
        pembelian.setList(pembelianDto.getList());
        pembelian.setList_return(pembelianDto.getList_return());
        pembelian.setKategoriId(pembelianDto.getKategoriId());

        return pembelian;
    }
}
