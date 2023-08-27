package net.ellshadday.app.repository.bahanbaku;

import net.ellshadday.app.entity.bahanbaku.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findSupplierById(long supplierId);
}


