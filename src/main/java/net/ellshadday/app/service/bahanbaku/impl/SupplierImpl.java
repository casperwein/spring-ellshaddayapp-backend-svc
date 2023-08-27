package net.ellshadday.app.service.bahanbaku.impl;

import net.ellshadday.app.entity.bahanbaku.Supplier;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.bahanBakuDto.SupplierDto;
import net.ellshadday.app.repository.bahanbaku.SupplierRepository;
import net.ellshadday.app.service.bahanbaku.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierImpl implements SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = mapToEntity(supplierDto);
        Supplier newSupplier = supplierRepository.save(supplier);
        SupplierDto supplierRes = mapToDTO(newSupplier);

        return supplierRes;
    }

    @Override
    public List<SupplierDto> getSupplierById(long supplierId) {
        List<Supplier> supplier = supplierRepository.findSupplierById(supplierId);

        return supplier.stream().map(
                (sp) -> mapToDTO(sp)).collect(Collectors.toList());
    }

    @Override
    public List<SupplierDto> getAllSupplier() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return suppliers.stream().map(supplier -> mapToDTO(supplier)).collect(Collectors.toList());
    }

    @Override
    public void deleteSupplir(long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Kategori", "id", id));

        supplierRepository.delete(supplier);
    }

    @Override
    public SupplierDto updateSupplier(long supplierId, SupplierDto supplierDto) {
        Supplier supplier = supplierRepository.findById(supplierId).orElseThrow(
                () -> new ResourceNotFoundException("Kategori", "id", supplierId));

        supplier.setNama(supplierDto.getNama());
        supplier.setTelepon(supplierDto.getTelepon());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setAlamat(supplierDto.getAlamat());

        Supplier supplierUpd = supplierRepository.save(supplier);
        SupplierDto supplierRes = mapToDTO(supplierUpd);

        return supplierRes;
    }

    public SupplierDto mapToDTO(Supplier supplier){
        SupplierDto supplierDto = new SupplierDto();

        supplierDto.setId(supplier.getId());
        supplierDto.setNama(supplier.getNama());
        supplierDto.setTelepon(supplier.getTelepon());
        supplierDto.setEmail(supplier.getEmail());
        supplierDto.setAlamat(supplier.getAlamat());

        return supplierDto;
    }

    public Supplier mapToEntity(SupplierDto supplierDto){
        Supplier supplier = new Supplier();

        supplier.setId(supplierDto.getId());
        supplier.setNama(supplierDto.getNama());
        supplier.setTelepon(supplierDto.getTelepon());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setAlamat(supplierDto.getAlamat());

        return  supplier;
    }
}
