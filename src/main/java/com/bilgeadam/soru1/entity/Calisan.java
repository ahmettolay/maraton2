package com.bilgeadam.soru1.entity;

import lombok.Data;

@Data
public class Calisan {
    private  Integer id;
    private  String isim;
    private int yas;
    private int maas;
    private  String departman;
    private Sirket sirket;

    public Calisan(String isim, int yas, int maas, String departman, Sirket sirket) {
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
        this.sirket = sirket;
    }

    public Calisan(Integer id, String isim, int yas, int maas, String departman, Sirket sirket) {
        this.id = id;
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
        this.sirket = sirket;
    }

}
