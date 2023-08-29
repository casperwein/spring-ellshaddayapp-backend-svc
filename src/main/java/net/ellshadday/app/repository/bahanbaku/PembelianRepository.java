package net.ellshadday.app.repository.bahanbaku;

import net.ellshadday.app.entity.bahanbaku.Pembelian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PembelianRepository extends JpaRepository<Pembelian, Long> {
    List<Pembelian> findPembelianById(long id);
    List<Pembelian> findBykodebahan(String kodebahan);
}
