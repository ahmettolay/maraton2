package com.bilgeadam.soru2.service;

import com.bilgeadam.soru2.entity.Musteri;
import com.bilgeadam.soru2.entity.Siparis;
import com.bilgeadam.soru2.entity.SiparisKalemi;
import com.bilgeadam.soru2.entity.Urun;
import com.bilgeadam.soru2.repository.SiparisDao;

import java.util.Arrays;
import java.util.List;

public class SiparisService {
    SiparisDao siparisDao = new SiparisDao();

    public void save() {
        Musteri musteri1 = new Musteri("Ali", "Kaya");
        Musteri musteri2 = new Musteri("Veli", "Özkan");

        Urun urun1 = new Urun("Ipohone 11", 17000);
        Urun urun2 = new Urun("Samsung S21", 18000);
        Urun urun3 = new Urun("LG LED TV", 8500);
        Urun urun4 = new Urun("Arçelik Süpürge", 2500);

        SiparisKalemi siparisKalemi1 = new SiparisKalemi(urun1, 1);
        SiparisKalemi siparisKalemi2 = new SiparisKalemi(urun2, 1);
        Siparis siparis1 = new Siparis(musteri1, Arrays.asList(siparisKalemi1, siparisKalemi2));

        SiparisKalemi siparisKalemi3 = new SiparisKalemi(urun2, 2);
        SiparisKalemi siparisKalemi4 = new SiparisKalemi(urun3, 1);
        Siparis siparis2 = new Siparis(musteri2, Arrays.asList(siparisKalemi3, siparisKalemi4));

        SiparisKalemi siparisKalemi5 = new SiparisKalemi(urun4, 2);
        Siparis siparis3 = new Siparis(musteri2, Arrays.asList(siparisKalemi5));

        Siparis siparis4 = new Siparis(musteri2, Arrays.asList(new SiparisKalemi(urun1, 1)));
        Siparis siparis5 = new Siparis(musteri2, Arrays.asList(new SiparisKalemi(urun2, 1)));
        siparisDao.save(siparis1);
        siparisDao.save(siparis2);
        siparisDao.save(siparis3);
        siparisDao.save(siparis4);
        siparisDao.save(siparis5);
    }

    public void update() {
        Musteri musteri2 = new Musteri("Veliiii", "Özkannn");
        Urun urun2 = new Urun("Samsung S211111", 180000);
        Siparis siparis5 = new Siparis(5, musteri2, Arrays.asList(new SiparisKalemi(urun2, 99)));
        siparisDao.update(siparis5);
    }

    public  void  delete(){
        Siparis siparis =new Siparis(1);
        siparisDao.delete(siparis);
    }

    public void getAll() {
        siparisDao.getAll().stream().forEach(System.out::println);
    }

    public void soru2A() {
        List<Siparis> siparisList = siparisDao.getAll();
        int toplam = 0;
        for (Siparis item : siparisList) {
            System.out.println("Sipariş ID : " + item.getSiparisId()
                    + " Müsteri : " + item.getMusteri().getAd() + " " + item.getMusteri().getSoyad()
                    + " Müsteri ID :" + item.getMusteri().getMusteriId());
          for (SiparisKalemi item2 : item.getSiparisKalemleri()) {

                toplam = toplam + item2.getUrun().getFiyat();
                System.out.println("Ürün : " + item2.getUrun().getUrunAdi() + " Fiyat : " + item2.getUrun().getFiyat() + " Adet Sayısı : " +
                        item2.getAlinanUrunAdet()  );
            }
            System.out.println("Sipariş Toplam : " + toplam + "TL.");
        }
    }
}







