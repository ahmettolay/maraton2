package com.bilgeadam.soru1.entity;

import lombok.Data;

@Data
public class Sirket {
    private Integer id;
    private  String sirketIsmi;
    private  String sirketSahibi;
    private  String unvani;
    private  String faaliyetAlani;
    private int kurlusYili;

    public Sirket(Integer id) {
        this.id = id;
    }

    public Sirket(Integer id, String sirketIsmi, String sirketSahibi, String unvani, String faaliyetAlani, int kurlusYili) {
        this.id = id;
        this.sirketIsmi = sirketIsmi;
        this.sirketSahibi = sirketSahibi;
        this.unvani = unvani;
        this.faaliyetAlani = faaliyetAlani;
        this.kurlusYili = kurlusYili;
    }
}
