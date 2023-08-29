package net.ellshadday.app.service.produksi.impl;

import net.ellshadday.app.entity.produksi.Produk;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.produksi.ProdukDto;
import net.ellshadday.app.repository.produksi.ProdukRepository;
import net.ellshadday.app.service.produksi.ProdukService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdukServiceImpl implements ProdukService {
    private ProdukRepository produkRepository;

    public ProdukServiceImpl(ProdukRepository produkRepository) {
        this.produkRepository = produkRepository;
    }

    @Override
    public ProdukDto createProduk(ProdukDto produkDto) {
        if(produkRepository.existsById(produkDto.getPo())){
            throw new DuplicateKeyException("PO Already Exist!");
        }

        Produk produk = mapToEntity(produkDto);
        Produk newProduk = produkRepository.save(produk);
        ProdukDto produkRes = mapToDto(newProduk);

        return produkRes;
    }

    @Override
    public List<ProdukDto> getAllProduk() {
        List<Produk> produks = produkRepository.findAll();
        return produks.stream().map(produk -> mapToDto(produk)).collect(Collectors.toList());
    }

    @Override
    public List<ProdukDto> getProdukByPo(long po) {
        List<Produk> produk = produkRepository.getProdukBypo(po);
        return produk.stream().map(prd -> mapToDto(prd)).collect(Collectors.toList());
    }

    public ProdukDto mapToDto(Produk produk){
        ProdukDto produkDto = new ProdukDto();

        produkDto.setPo(produk.getPo());
        produkDto.setAttributes(produk.getAttributes());
        produkDto.setNama_produk(produk.getNama_produk());
        produkDto.setCmt_id(produk.getCmt_id());
        produkDto.setCutter_id(produk.getCutter_id());
        produkDto.setKodebahan(produk.getKodebahan());
        produkDto.setTanggal_produksi(produk.getTanggal_produksi());
        produkDto.setGambar(produk.getGambar());
        produkDto.setQuantity(produk.getQuantity());
        produkDto.setProggress(produk.getProggress());

        return  produkDto;
    }

    public Produk mapToEntity(ProdukDto produkDto){
        Produk produk = new Produk();

        produk.setPo(produkDto.getPo());
        produk.setAttributes(produkDto.getAttributes());
        produk.setNama_produk(produkDto.getNama_produk());
        produk.setCmt_id(produkDto.getCmt_id());
        produk.setCutter_id(produkDto.getCutter_id());
        produk.setKodebahan(produkDto.getKodebahan());
        produk.setTanggal_produksi(produkDto.getTanggal_produksi());
        produk.setGambar(produkDto.getGambar());
        produk.setQuantity(produkDto.getQuantity());
        produk.setProggress(produkDto.getProggress());

        return produk;
    }
}
