package net.ellshadday.app.repository.produksi;

import net.ellshadday.app.entity.produksi.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdukRepository extends JpaRepository<Produk, Long> {
    List<Produk> getProdukBypo(long po);
}
