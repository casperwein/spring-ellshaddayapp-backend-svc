package net.ellshadday.app.entity.bahanbaku;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Pembelian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long suplierId;
    private String warna;
    private String kodebahan;
    private String bahan_bahu_desc;
    private Date tanggal_terima;
    private String tempat_penyimpanan;
    private int roll_ball_quantity;
    private float kg_yard_meter_quantity;
    private String is_return;
    private int roll_ball_return;
    private float yard_kg_meter_return;
    private String penerima;
    private String kurir;
    private double harga_satuan;
    private double total_harga;
    private String gambar;
    private String faktur;
    private String list;
    private String list_return;
    private long kategoriId;

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
