package net.ellshadday.app.repository.bahanbaku;

import net.ellshadday.app.entity.bahanbaku.BahanBaku;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BahanBakuRepository extends JpaRepository<BahanBaku, String> {
    List<BahanBaku> getBahanBakuByKodebahan(String kodebahan);
    BahanBaku getBykodebahan(String kodebahan);
}
