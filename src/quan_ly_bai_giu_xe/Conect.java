/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_ly_bai_giu_xe;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
/**
 *
 * @author Admin
 */
public class Conect {
    private  Connection con;
    public Conect ()throws ClassNotFoundException ,SQLException{
        //Nap trinh dieu khien
        Class.forName("com.mysql.cj.jdbc.Driver");
        //thưc hien ket noi 
        this.con= DriverManager.getConnection("jdbc:mysql://localhost:3306/giuxe_db","root","");
        
    }
     public ResultSet getdata(String tbname)throws  SQLException{
        ResultSet kq = null;
        Statement statement = this.con.createStatement();//tao doi tuong truy van 
        String sql = "select * from  " + tbname;
        kq = statement.executeQuery(sql);//thuc thi truy van
        return kq;
    }
     public ResultSet GetXD(String tbname) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "SELECT * FROM "+tbname+" WHERE maloai ='XĐ' ";
        kq = statement.executeQuery(sql);
        return kq;
    }
     public ResultSet find(String tbname, String s1)throws  SQLException{
        ResultSet kq = null;
        Statement statement = this.con.createStatement();//tao doi tuong truy van 
        String sql = "select * from "+tbname+" where bienso like '"+s1+"%'";
        kq = statement.executeQuery(sql);//thuc thi truy van
        return kq;
    }
      public void Insert(String id, String username, String pass) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql1 = "Insert user values('" + id + "','" + username + "'," + pass + ")";
        sta.executeUpdate(sql1);
    }
      public void InsertPT(String tenchuxe, String bienso, String SDT,String loaixe, String ngayvao,String Maloai) throws SQLException {
        Statement sta = this.con.createStatement();
//        String sql = "Insert into phuongtien values('" + tenchuxe + "'," + SDT + ",'" + bienso + "','" + loaixe + "','" + ngayvao + "','"+Maloai+"')";
         String sql ="INSERT INTO phuongtien VALUES(null,'" + tenchuxe + "', '" + SDT + "','" + bienso + "', '" + loaixe + "','" + ngayvao + "','" + Maloai + "' )";           
        sta.executeUpdate(sql);
    }
       public void InsertHD(String mathe,String tenchuxe, String bienso, String SDT,String loaixe, String songay_gui,String total) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "Insert into thanhtoan values('"+mathe+"','" + tenchuxe + "','" + bienso + "'," + SDT + ",'" + songay_gui + "','" + loaixe + "','"+total+"')";
                    
        sta.executeUpdate(sql);
    }
       public void Update(String tenchuxe,String bienso, String SDT,String loaixe, String ngayvao,String Maloai,String mathe) throws
            SQLException {
        Statement sta = this.con.createStatement();
        
        String sql2 = "Update phuongtien set tenchuxe='" +tenchuxe + "',bienso='"+bienso+"',sdt="+SDT+",loaixe='"+loaixe+"',ngayvao='" + ngayvao + "',maloai='"+Maloai+"' where mathe= " + mathe + " ";
        
        sta.executeUpdate(sql2);
    }
       public ResultSet GetData_TK(String Loai) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "SELECT * FROM `phuongtien` WHERE `maloai`='" + Loai + "'";
        kq = statement.executeQuery(sql);
        return kq;
    }
       public ResultSet GetHD(String bienso) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "SELECT * FROM `thanhtoan` WHERE `bienso` like '" + bienso + "%'";
        kq = statement.executeQuery(sql);
        return kq;
    }
       public ResultSet Check(String bienso) throws SQLException {
        ResultSet kq = null;
        Statement statement = this.con.createStatement();
        String sql = "SELECT * FROM `phuongtien` WHERE `bienso` like '" + bienso + "'";
        kq = statement.executeQuery(sql);
        return kq;
    }
      
       public void Delete(String mathe) throws SQLException {
        Statement sta = this.con.createStatement();
        String sql = "DELETE FROM phuongtien where mathe =" + mathe + "";
        sta.executeUpdate(sql);
    }
       
     public void Close() throws SQLException {
        if (this.con != null) {
            this.con.close();
        }
    }
}
