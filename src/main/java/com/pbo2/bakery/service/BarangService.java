package com.pbo2.bakery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pbo2.bakery.model.Barang;
import com.pbo2.bakery.repository.BarangRepository;

@Service
public class BarangService {

    private final BarangRepository barangRepository;

    public BarangService(BarangRepository barangRepository) {
        this.barangRepository = barangRepository;
    }

    public List<Barang> getAllBarang() {
        return barangRepository.findAll();
    }

    public Barang getBarangByKode(String kodeBarang) {
        return barangRepository.findByKode(kodeBarang);
    }

    public void tambahBarang(Barang barang) {
        barangRepository.save(barang);
    }

    public void updateBarang(Barang barang) {
        barangRepository.update(barang);
    }

    public void hapusBarang(String kodeBarang) {
        barangRepository.delete(kodeBarang);
    }
}