package net.ellshadday.app.service.bahanbaku;

import net.ellshadday.app.payload.bahanBakuDto.SupplierDto;

import java.util.List;

public interface SupplierService {
        SupplierDto createSupplier(SupplierDto supplierDto);
        SupplierDto updateSupplier(long supplierId, SupplierDto supplierDto);
        List<SupplierDto> getSupplierById(long supplierId);

        List<SupplierDto> getAllSupplier();

        void deleteSupplir(long id);
}
