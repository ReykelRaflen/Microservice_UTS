package com.reykel.peminjamanservice.dto;

public class PeminjamanRequestDTO {

    private String kdTransaksi;
    private String nasabah;
    private double jumlahPinjaman;
    private int lamaPinjaman;

    private static final double SUKU_BUNGA = 0.10;

    public void setKdTransaksi(String kdTransaksi) {
        this.kdTransaksi = kdTransaksi;
    }

    public void setNasabah(String nasabah) {
        this.nasabah = nasabah;
    }

    public void setJumlahPinjaman(double jumlahPinjaman) {
        this.jumlahPinjaman = jumlahPinjaman;
    }

    public void setLamaPinjaman(int lamaPinjaman) {
        this.lamaPinjaman = lamaPinjaman;
    }
    
    public String getKdTransaksi() {
        return kdTransaksi;
    }

    public String getNasabah() {
        return nasabah;
    }

    public double getJumlahPinjaman() {
        return jumlahPinjaman;
    }

    public int getLamaPinjaman() {
        return lamaPinjaman;
    }


    public double getBunga() {
        return SUKU_BUNGA * 100;
    }

    public double getAngsuranPerBulan() {
        if (this.lamaPinjaman <= 0) {
            return 0; 
        }
        double bungaBulanan = this.jumlahPinjaman * SUKU_BUNGA;
        double angsuranPokok = this.jumlahPinjaman / this.lamaPinjaman;
        return bungaBulanan + angsuranPokok;
    }

    
    public double getTotalPinjaman() {
        return getAngsuranPerBulan() * this.lamaPinjaman;
    }

    
}