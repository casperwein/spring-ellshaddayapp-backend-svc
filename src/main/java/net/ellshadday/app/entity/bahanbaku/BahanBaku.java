package net.ellshadday.app.entity.bahanbaku;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor

@Data
@Getter
@Setter
@Entity
@Table(name = "bahanbaku")
public class BahanBaku {
    @Id
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
    private Date createdAt;
    @LastModifiedDate
    private Date updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kategori_id", nullable = false)
    private KategoriBahanBaku kategori;
}
