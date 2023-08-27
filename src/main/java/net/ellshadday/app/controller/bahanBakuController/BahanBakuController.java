package net.ellshadday.app.controller.bahanBakuController;

import net.ellshadday.app.payload.bahanBakuDto.BahanBakuDto;
import net.ellshadday.app.service.bahanbaku.BahanBakuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api-v1/bahanbaku")
public class BahanBakuController {
    private BahanBakuService bahanBakuService;

    public BahanBakuController(BahanBakuService bahanBakuService) {
        this.bahanBakuService = bahanBakuService;
    }

    @PostMapping("/kategori/{kategoriId}")
    public ResponseEntity<BahanBakuDto> createBahanBaku(
            @PathVariable(value = "kategoriId") long kategoriId,
            @RequestBody BahanBakuDto bahanBakuDto){
        return new ResponseEntity<>(bahanBakuService.createBahanBaku(kategoriId, bahanBakuDto), HttpStatus.OK);
    }

    @GetMapping("/{kodebahan}")
    public List<BahanBakuDto> getBahanByKodeBahan(@PathVariable(name = "kodebahan") String kodebahan){
        return bahanBakuService.getBahanBakuByKodebahan(kodebahan);
    }

    @GetMapping()
    public List<BahanBakuDto> getAllBahanBaku(){
        return bahanBakuService.getAllBahanBaku();
    }

    @DeleteMapping("/{kodebahan}/delete")
    public ResponseEntity<String> deleteBahanBaku(@PathVariable(name = "kodebahan") String kodebahan){
        bahanBakuService.deleteBahanBaku(kodebahan);
        String msg = "Bahan Baku dengan kodebahan " + kodebahan + " berhasil dihapus!";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
