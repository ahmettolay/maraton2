package com.bilgeadam.soru2.repository;

import com.bilgeadam.soru2.entity.Siparis;
import com.bilgeadam.soru2.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SiparisDao {

    public void save(Siparis siparis){
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println("Sipariş eklendi");
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(Siparis siparis){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.update(siparis);
            session.getTransaction().commit();
            System.out.println("Sipariş güncellendi");
            session.close();
        }catch (Exception e){
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void delete(Siparis siparis){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            session.delete(siparis);
            session.getTransaction().commit();
            System.out.println("Sipariş silindi");
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            e.getCause();
        }
    }
    public List<Siparis> getAll() {
        Transaction transaction = null;
        List<Siparis> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("select siparis from Siparis siparis").list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }

  /*  public void soru2A(){
        List<Siparis> siparisList= new ArrayList<>();
        try {
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String sql = "SELECT s.siparisId,m.ad,m.soyad,m.musteriId,u.urunAdi,u.fiyat,sk.alinanUrunAdet FROM siparis AS s\n" +
                    "INNER JOIN musteri AS m ON m.musteriId=s.musteri_musteriId\n" +
                    "INNER JOIN siparis_sipariskalemi AS ssk ON ssk.Siparis_siparisId=s.siparisId\n" +
                    "INNER JOIN sipariskalemi AS sk ON sk.sKId=ssk.siparisKalemleri_sKId\n" +
                    "INNER JOIN urun AS u ON u.urunId=sk.urun_urunId ";


            siparisList = entityManager.createNativeQuery(sql).getResultList();

            System.out.println(siparisList);
            }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        }*/


    }

