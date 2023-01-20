package com.bilgeadam.soru2.utils;






import com.bilgeadam.soru2.entity.Musteri;
import com.bilgeadam.soru2.entity.Siparis;
import com.bilgeadam.soru2.entity.SiparisKalemi;
import com.bilgeadam.soru2.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;


    public static SessionFactory getSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Musteri.class);
            configuration.addAnnotatedClass(SiparisKalemi.class);
            configuration.addAnnotatedClass(Siparis.class);
            configuration.addAnnotatedClass(Urun.class);
            sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }

        return sessionFactory;
    }


}
