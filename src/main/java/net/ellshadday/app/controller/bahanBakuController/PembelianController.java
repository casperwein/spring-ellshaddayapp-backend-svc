package net.ellshadday.app.controller.bahanBakuController;

import net.ellshadday.app.payload.bahanBakuDto.PembelianDto;
import net.ellshadday.app.service.bahanbaku.PembelianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api-v1/pembelian")
public class PembelianController {
    private PembelianService pembelianService;

    public PembelianController(PembelianService pembelianService) {
        this.pembelianService = pembelianService;
    }

    @PostMapping
    public ResponseEntity<PembelianDto> createNewPembelian(@RequestBody PembelianDto pembelianDto){
        return new ResponseEntity<>(pembelianService.createNewPembelian(pembelianDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PembelianDto> getAllPembelian(){
        return pembelianService.getAllPembelian();
    }

    @GetMapping("/{id}")
    public List<PembelianDto> getPembelianById(@PathVariable(name = "id") long id){
        return pembelianService.findById(id);
    }

    @GetMapping("kodebahan/{kodebahan}")
    public List<PembelianDto> getPembelianByKodebahan(@PathVariable(name = "kodebahan") String kodebahan){
        return pembelianService.getPembelianByKodebahan(kodebahan);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<PembelianDto> updatePembelian(@PathVariable(value = "id") long id,
                                                        @RequestBody PembelianDto pembelianDto){
        return new ResponseEntity<>(pembelianService.updatePembelian(id, pembelianDto), HttpStatus.OK);
    }
}
