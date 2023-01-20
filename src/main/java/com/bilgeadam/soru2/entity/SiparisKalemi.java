package com.bilgeadam.soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sKId;
    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;

    private int alinanUrunAdet;

    public SiparisKalemi(Urun urun, int alinanUrunAdet) {
        this.urun = urun;
        this.alinanUrunAdet = alinanUrunAdet;
    }



}
