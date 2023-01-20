package com.bilgeadam.soru2.repository;

import com.bilgeadam.soru2.entity.Musteri;
import com.bilgeadam.soru2.entity.Siparis;
import com.bilgeadam.soru2.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class MusteriDao {
    public  void  musteriSiparisAdedi(int musteriId){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();{
            String sql = "SELECT m.musteriId, sk.alinanUrunAdet FROM siparis AS s\n" +
                    "INNER JOIN musteri AS m ON m.musteriId=s.musteri_musteriId\n" +
                    "INNER JOIN siparis_sipariskalemi AS ssk ON ssk.Siparis_siparisId=s.siparisId\n" +
                    "INNER JOIN sipariskalemi AS sk ON sk.sKId=ssk.siparisKalemleri_sKId\n" +
                    "INNER JOIN urun AS u ON u.urunId=sk.urun_urunId where m.musteriId =? GROUP BY sk.alinanUrunAdet , m.musteriId ";
            try {
                Query query = entityManager.createNativeQuery(sql);
                query.setParameter(1, musteriId);
                List<Object[]> array = query.getResultList();
                for(Object[] item : array){
                    System.out.println("Müsşteri Id: " + item[0] + "  "
                            + " Sipariş Sayısı: " + item[1] + "  "

                    );
                }
            }catch (Exception e){
                e.getMessage();
                e.printStackTrace();
            }
        }
    }
    public void musteriAdSoyadSiparis(){
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();{
            String sql = "SELECT m.ad,m.soyad ,s.siparisId  FROM siparis AS s\n" +
                    "INNER JOIN musteri AS m ON m.musteriId=s.musteri_musteriId\n" +
                    "INNER JOIN siparis_sipariskalemi AS ssk ON ssk.Siparis_siparisId=s.siparisId\n" +
                    "INNER JOIN sipariskalemi AS sk ON sk.sKId=ssk.siparisKalemleri_sKId\n" +
                    "INNER JOIN urun AS u ON u.urunId=sk.urun_urunId ";
            try {
                Query query = entityManager.createNativeQuery(sql);

                List<Object[]> array = query.getResultList();
                for(Object[] item : array){
                    System.out.println("Müşteri Ad : " + item[0] + "  "
                            + " Müşteri Soyad : " + item[1] + "  "
                            + " Sipariş ID : " + item[2] + "  "

                    );
                }
            }catch (Exception e){
                e.getMessage();
                e.printStackTrace();
            }
        }

    }


        public List<Musteri> getAll() {
            Transaction transaction = null;
            List<Musteri> list = null;

            try(Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                list = session.createQuery("select musteri from Musteri musteri").list();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
            }
            return list;
        }
    }

