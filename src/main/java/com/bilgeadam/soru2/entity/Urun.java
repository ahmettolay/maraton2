package com.bilgeadam.soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer urunId;
    private String urunAdi;
    private int fiyat;

    public Urun(String urunAdi, int fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    public Urun(Integer urunId, String urunAdi, int fiyat) {
        this.urunId = urunId;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

}
