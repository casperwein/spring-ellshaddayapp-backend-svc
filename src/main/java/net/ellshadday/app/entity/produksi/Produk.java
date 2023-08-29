package net.ellshadday.app.entity.produksi;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Produk {
    @Id
    private long po;
    private String nama_produk;
    private String kodebahan;
    private String attributes;
    private long cutter_id;
    private long cmt_id;
    private long quantity;
    private String proggress;
    private String gambar;
    private Date tanggal_produksi;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
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
