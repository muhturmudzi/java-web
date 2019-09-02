
package net.tutorialpedia.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserModel {
   String id,nama,alamat;
   Koneksi db = null;
       
    public UserModel() {
        db = new Koneksi();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void simpan(){
        String sql="INSERT INTO tb_user values(null,'"+nama+"','"+alamat+"')";
        db.simpanData(sql);
    }
    public void update(){
        String sql="UPDATE tb_user SET nama='"+nama+"',alamat='"+alamat+"' WHERE id='"+id+"'";
        db.simpanData(sql);
        System.out.println(sql);
    }
    public void hapus(){
        String sql="DELETE FROM tb_user WHERE ID='"+id+"'";
        db.simpanData(sql);
        System.out.println("");
    }
    public List tampil() {
        List<UserModel> data = new ArrayList<UserModel>();
        ResultSet rs = null;

        try {
            String sql = "select * from tb_user order by nama asc";
            rs = db.ambilData(sql);
            while (rs.next()) {
                UserModel um = new UserModel();
                um.setId(rs.getString("id"));
                um.setNama(rs.getString("nama"));
                um.setAlamat(rs.getString("alamat"));
                data.add(um);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalahan Saat menampilkan data User" + ex);
        }
        return data;
    }
        public List cariID() {
        List<UserModel> data = new ArrayList<UserModel>();
        ResultSet rs = null;
 
        try {
            String sql = "SELECT * FROM tb_user WHERE ID='"+id+"'";
            rs = db.ambilData(sql);
            while (rs.next()) {
                UserModel m = new UserModel();
                m.setId(rs.getString("id"));
                m.setNama(rs.getString("nama"));
                m.setAlamat(rs.getString("alamat"));
                data.add(m);

            }
            db.diskonek(rs);
        } catch (Exception ex) {
            System.out.println("Terjadi Kesalah Saat menampilkan Cari ID" + ex);
        }
        return data;

    }
}

