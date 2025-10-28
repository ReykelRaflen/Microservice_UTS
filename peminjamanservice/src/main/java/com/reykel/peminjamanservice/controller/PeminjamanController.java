package com.reykel.peminjamanservice.controller;

import com.reykel.peminjamanservice.dto.PeminjamanRequestDTO;
import com.reykel.peminjamanservice.model.Peminjaman;
import com.reykel.peminjamanservice.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peminjaman")
public class PeminjamanController {

    @Autowired
    private PeminjamanService peminjamanService;


    private Peminjaman convertToEntity(PeminjamanRequestDTO dto) {
        Peminjaman peminjaman = new Peminjaman();
        peminjaman.setKdTransaksi(dto.getKdTransaksi());
        peminjaman.setNasabah(dto.getNasabah());
        peminjaman.setJumlahPinjaman(dto.getJumlahPinjaman());
        peminjaman.setLamaPinjaman(dto.getLamaPinjaman());

       
        peminjaman.setBunga(dto.getBunga()); 
        peminjaman.setAngsuranPerBulan(dto.getAngsuranPerBulan());
        peminjaman.setTotalPinjaman(dto.getTotalPinjaman());

        return peminjaman;
    }

    @PostMapping
    public ResponseEntity<Peminjaman> createPeminjaman(@RequestBody PeminjamanRequestDTO dto) {
        if (dto.getLamaPinjaman() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Peminjaman peminjaman = convertToEntity(dto);
        Peminjaman saved = peminjamanService.createPeminjaman(peminjaman);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Peminjaman> getAllPeminjaman() {
        return peminjamanService.getAllPeminjaman();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peminjaman> getPeminjamanById(@PathVariable Long id) {
        return peminjamanService.getPeminjamanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Peminjaman> updatePeminjaman(
            @PathVariable Long id,
            @RequestBody PeminjamanRequestDTO dto) {
        if (dto.getLamaPinjaman() <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Peminjaman peminjaman = convertToEntity(dto);
        peminjaman.setId(id); 
        try {
            Peminjaman updated = peminjamanService.updatePeminjaman(id, peminjaman);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePeminjaman(@PathVariable Long id) {
        peminjamanService.deletePeminjaman(id);
        return ResponseEntity.noContent().build();
    }
}