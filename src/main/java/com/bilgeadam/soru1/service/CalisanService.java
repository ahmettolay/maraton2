package com.bilgeadam.soru1.service;

import com.bilgeadam.soru1.entity.Calisan;
import com.bilgeadam.soru1.entity.Sirket;
import com.bilgeadam.soru1.util.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalisanService {
    public static void main(String[] args) {
        calisan=new Calisan(4,"k",100,100,"aa",new Sirket(1));
               // update(calisan);
        delete(4);
    }
   static DB db = new DB();
    static Calisan calisan=null;

    static List<Object> ls = new ArrayList<>();
    public static void save(Calisan calisan) {
        try {
String sql="INSERT INTO maraton2jdbc.calisan(isim,yas,maas,departman,sirket_id) values(?,?,?,?,?)";
            PreparedStatement insertStatement = db.connection.prepareStatement(sql);

            insertStatement.setString(1, calisan.getIsim());
            insertStatement.setInt(2, calisan.getYas());
            insertStatement.setInt(2, calisan.getMaas());
            insertStatement.setString(2, calisan.getDepartman());
            insertStatement.setInt(2, calisan.getSirket().getId());

            insertStatement.executeUpdate();
            System.out.println("Product is added");
            getAll();

            insertStatement.close();
            db.connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void getAll() {
String sql="Select c.id,c.isim,c.yas,c.maas,c.departman,c.sirket_id," +
        "s.sirketIsmi,s.sirketSahibi,s.unvani,s.faaliyetalani,s.kurulusYili " +
        "from maraton2jdbc.calisan as c\n" +
        "INNER JOIN maraton2jdbc.sirket as s ON s.id=c.sirket_id;";
        try {
            PreparedStatement stProduct = db.connection.prepareStatement(sql);
            ResultSet rs = stProduct.executeQuery();
            while (rs.next()) {
                Integer Id = rs.getInt("id");
                String isim = rs.getString("isim");
                int yas = rs.getInt("yas");
                int maas = rs.getInt("maas");
                String departman = rs.getString("departman");
                int sirketid = rs.getInt("sirket_id");
                String sirketIsmi = rs.getString("sirketIsmi");
                String sirketSahibi = rs.getString("sirketSahibi");
                String unvani = rs.getString("unvani");
                String faaliyetalani = rs.getString("faaliyetalani");
                int kurulusYili = rs.getInt("kurulusYili");

                calisan=new Calisan(Id,isim,yas,maas,departman,new Sirket(sirketid,sirketIsmi,sirketSahibi,unvani,faaliyetalani,kurulusYili));
                ls.add(calisan);
            }
            if (ls.isEmpty()) {
                System.out.println("Product is empty");
            } else {
                ls.forEach(item -> System.out.println(item));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void delete(int id) {

        try {
            String sql = "delete from maraton2jdbc.calisan where id=?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void  update(Calisan calisan) {
        String sql = "Update maraton2jdbc.calisan set isim=? ,yas=?,maas=?,departman=?, sirket_id=? where id=?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, calisan.getIsim());
            preparedStatement.setInt(2, calisan.getYas());
            preparedStatement.setInt(3, calisan.getMaas());
            preparedStatement.setString(4, calisan.getDepartman());
            preparedStatement.setInt(5, calisan.getSirket().getId());
            preparedStatement.setInt(6, calisan.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
            getAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
