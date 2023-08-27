package net.ellshadday.app.entity.bahanbaku;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "bahanbaku")
public class BahanBaku {
    @Id
    @Column(name = "kodebahan", updatable = false)
    private String kodebahan;
    private String nama;
    private String warna;
    private String gambar;
    private long roll_ball_quantity;
    private float total_yard_kg;
    private float yard_kg_clean;
    private float yard_kg_sisa;
    private String satuan;
    private String ukuran;
    private int safety_stock;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id", nullable = false)
    private KategoriBahanBaku kategori;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
