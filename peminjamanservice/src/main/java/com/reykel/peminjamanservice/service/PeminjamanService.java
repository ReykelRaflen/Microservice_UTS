package com.reykel.peminjamanservice.service;

import com.reykel.peminjamanservice.model.Peminjaman;
import com.reykel.peminjamanservice.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeminjamanService {
@Autowired
private PeminjamanRepository peminjamanRepository;


public Peminjaman createPeminjaman(Peminjaman peminjaman) {
    return peminjamanRepository.save(peminjaman);
}


public List<Peminjaman> getAllPeminjaman() {
    return peminjamanRepository.findAll();
}


public Optional<Peminjaman> getPeminjamanById(Long id) {
    return peminjamanRepository.findById(id);
}


public Peminjaman updatePeminjaman(Long id, Peminjaman peminjamanDetails) {
    return peminjamanRepository.save(peminjamanDetails);
}


public void deletePeminjaman(Long id) {
    if (!peminjamanRepository.existsById(id)) {
        throw new RuntimeException("Peminjaman tidak ditemukan dengan id: " + id);
    }
    peminjamanRepository.deleteById(id);
}
}