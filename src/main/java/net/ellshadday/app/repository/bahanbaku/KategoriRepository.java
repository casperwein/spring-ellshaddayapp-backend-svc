package net.ellshadday.app.repository.bahanbaku;

import net.ellshadday.app.entity.bahanbaku.KategoriBahanBaku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KategoriRepository extends JpaRepository<KategoriBahanBaku, Long> {
    List<KategoriBahanBaku> findKategoriById(long kategoriId);
}
