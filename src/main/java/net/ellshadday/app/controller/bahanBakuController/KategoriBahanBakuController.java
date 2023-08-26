package net.ellshadday.app.controller.bahanBakuController;

import net.ellshadday.app.payload.bahanBakuDto.KategoriBahanBakuDto;
import net.ellshadday.app.service.bahanbaku.KategoriBahanBakuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api-v1/kategori")
public class KategoriBahanBakuController {
    private KategoriBahanBakuService kategoriBahanBakuService;

    public KategoriBahanBakuController(KategoriBahanBakuService kategoriBahanBakuService) {
        this.kategoriBahanBakuService = kategoriBahanBakuService;
    }

    @PostMapping
    public ResponseEntity<KategoriBahanBakuDto> createKategori(
            @RequestBody KategoriBahanBakuDto kategoriBahanBakuDto){
        System.out.println("Controller /n" + kategoriBahanBakuDto);
        return new ResponseEntity<>(kategoriBahanBakuService.createKategori(kategoriBahanBakuDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<KategoriBahanBakuDto> getAllKategories(){
        return kategoriBahanBakuService.getAllKategori();
    }

    @GetMapping("/{kategoriId}")
    public List<KategoriBahanBakuDto> getKategoriById(@PathVariable(name = "kategoriId") long kategoriId){
        return kategoriBahanBakuService.getKategoriByIdKategori(kategoriId);
    }

    @PutMapping("/{kategoriId}")
    public ResponseEntity<KategoriBahanBakuDto> updateKategori(@PathVariable(value = "kategoriId") long kategoriId,
                                                               @RequestBody KategoriBahanBakuDto kategoriBahanBakuDto){
        KategoriBahanBakuDto updateKategori = kategoriBahanBakuService.updateKategoriBahanBaku(kategoriId, kategoriBahanBakuDto);
        return new ResponseEntity<>(updateKategori, HttpStatus.OK);
    }

    @DeleteMapping("/{kategoriId}/delete")
    public ResponseEntity<String> deleteKategoriBahanBaku(@PathVariable(value = "kategoriId") long kategoriId){
        kategoriBahanBakuService.deleteKategori(kategoriId);
        String msg = "Kategori with id " + kategoriId + " deleted succesfully!";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
