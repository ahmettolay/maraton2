package com.bilgeadam.soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Siparis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer siparisId;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Musteri musteri;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SiparisKalemi> siparisKalemleri;

    public Siparis(Integer siparisId) {
        this.siparisId = siparisId;
    }

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemleri) {
        this.musteri = musteri;
        this.siparisKalemleri = siparisKalemleri;
    }

    public Siparis(Integer siparisId, Musteri musteri, List<SiparisKalemi> siparisKalemleri) {
        this.siparisId = siparisId;
        this.musteri = musteri;
        this.siparisKalemleri = siparisKalemleri;
    }




}
