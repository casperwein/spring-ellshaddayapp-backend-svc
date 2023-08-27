package net.ellshadday.app.controller.bahanBakuController;

import net.ellshadday.app.payload.bahanBakuDto.SupplierDto;
import net.ellshadday.app.service.bahanbaku.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api-v1/supplier")
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto supplierDto){
        return new ResponseEntity<>(supplierService.createSupplier(supplierDto), HttpStatus.CREATED);
    }

    @GetMapping("/{supplierId}")
    public List<SupplierDto> getSupplierById(@PathVariable(value = "supplierId") long supplierId){
        return supplierService.getSupplierById(supplierId);
    }

    @PutMapping("/{supplierId}/update")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable(name = "supplierId") long supplierId,
                                                      @RequestBody SupplierDto supplierDto){
        return new ResponseEntity<>(supplierService.updateSupplier(supplierId, supplierDto), HttpStatus.OK);
    }

    @GetMapping
    public List<SupplierDto> getAllSupplier(){
        return  supplierService.getAllSupplier();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteSupplier(@PathVariable(name = "id") long id){
        supplierService.deleteSupplir(id);
        String msg = "Supplier with id " + id + " deleted succesfully!";
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
