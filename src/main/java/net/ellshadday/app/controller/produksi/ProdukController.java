package net.ellshadday.app.controller.produksi;

import net.ellshadday.app.payload.produksi.ProdukDto;
import net.ellshadday.app.service.produksi.ProdukService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api-v1/produk")
public class ProdukController {
    private ProdukService produkService;

    public ProdukController(ProdukService produkService) {
        this.produkService = produkService;
    }

    @PostMapping
    public ResponseEntity<ProdukDto> addNewProduk(@RequestBody ProdukDto produkDto){
        return new ResponseEntity<>(produkService.createProduk(produkDto), HttpStatus.OK);
    }

    @GetMapping
    public List<ProdukDto> getAllProduk(){
        return produkService.getAllProduk();
    }

    @GetMapping("/{po}")
    public List<ProdukDto> getProdukByPO(@PathVariable(value = "po") long po){
        return produkService.getProdukByPo(po);
    }
}
