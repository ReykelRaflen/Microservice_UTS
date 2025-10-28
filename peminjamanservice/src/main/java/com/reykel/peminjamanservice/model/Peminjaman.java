package com.reykel.peminjamanservice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "peminjamans")
public class Peminjaman {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kdTransaksi;
    private String nasabah;
    private double jumlahPinjaman;
    private int lamaPinjaman; 

    private double bunga;
    private double angsuranPerBulan;
    private double totalPinjaman;


}
