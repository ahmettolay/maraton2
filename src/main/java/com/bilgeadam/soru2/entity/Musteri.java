package com.bilgeadam.soru2.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer musteriId;
   private  String ad;
   private  String soyad;
   @OneToMany(cascade = CascadeType.ALL,mappedBy = "musteri",fetch = FetchType.EAGER)
   private List<Siparis> siparisler;

   public Musteri(String ad, String soyad) {
      this.ad = ad;
      this.soyad = soyad;
   }



}
