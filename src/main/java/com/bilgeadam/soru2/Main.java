package com.bilgeadam.soru2;

import com.bilgeadam.soru2.entity.Musteri;
import com.bilgeadam.soru2.repository.MusteriDao;
import com.bilgeadam.soru2.service.MusteriService;
import com.bilgeadam.soru2.service.SiparisService;
import com.bilgeadam.soru2.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        //HibernateUtil.getSessionFactory();
        SiparisService siparisService= new SiparisService();
        //siparisService.save();
        //siparisService.update();
        //siparisService.delete();
        //siparisService.soru2A();

        MusteriService musteriService=new MusteriService();
        //musteriService.Soru2B();
        //musteriService.musteriSiparisAdedi(2);
        //musteriService.musteriAdSoyadSiparis();

    }
}
