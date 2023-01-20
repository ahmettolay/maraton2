package com.bilgeadam.soru2.service;

import com.bilgeadam.soru2.entity.Musteri;
import com.bilgeadam.soru2.entity.Siparis;
import com.bilgeadam.soru2.entity.SiparisKalemi;
import com.bilgeadam.soru2.repository.MusteriDao;
import com.bilgeadam.soru2.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusteriService {
    MusteriDao musteriDao= new MusteriDao();

    public  void  musteriSiparisAdedi(int musteriId){
        musteriDao.musteriSiparisAdedi(musteriId);
    }
    public void musteriAdSoyadSiparis(){
        musteriDao.musteriAdSoyadSiparis();
    }

    public void Soru2B(){
        List<Musteri> musteriList= musteriDao.getAll();
        int toplam = 0;
        for(Musteri item:musteriList){
            System.out.println("Musteri ID : " + item.getMusteriId()+" Musteri Ad : "+item.getAd()+" Musteri Soyad : "+
                    item.getSoyad());
            for(Siparis item2:item.getSiparisler()){
                System.out.println(" Sipariş id: "+item2.getSiparisId());
                for(SiparisKalemi item3:item2.getSiparisKalemleri()){
                    System.out.println("    Urun : "+item3.getUrun().getUrunAdi() +" Fiyat : "+item3.getUrun().getFiyat());
                    toplam=toplam+item3.getUrun().getFiyat();
                }
            }
            System.out.println("Toplam Harcama : "+toplam);
        }
    }
}
