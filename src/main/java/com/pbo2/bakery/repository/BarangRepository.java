package com.pbo2.bakery.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pbo2.bakery.model.Barang;

@Repository
public class BarangRepository {

    private final List<Barang> daftarBarang = new ArrayList<>();

    public BarangRepository() {
        daftarBarang.add(new Barang("ELK001", "Mouse Wireless", "Aksesoris", 150000, 20));
        daftarBarang.add(new Barang("ELK002", "Keyboard Mechanical", "Aksesoris", 450000, 10));
    }

    public List<Barang> findAll() {
        return daftarBarang;
    }

    public Barang findByKode(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }

    public void save(Barang barang) {
        daftarBarang.add(barang);
    }

    public void update(Barang barangBaru) {
        Barang barangLama = findByKode(barangBaru.getKodeBarang());

        if (barangLama != null) {
            barangLama.setNamaBarang(barangBaru.getNamaBarang());
            barangLama.setKategori(barangBaru.getKategori());
            barangLama.setHarga(barangBaru.getHarga());
            barangLama.setStok(barangBaru.getStok());
        }
    }

    public void delete(String kodeBarang) {
        daftarBarang.removeIf(barang -> barang.getKodeBarang().equals(kodeBarang));
    }
}