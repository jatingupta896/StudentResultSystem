/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class DB_connect {
    public static Connection con;
    public static Statement st;
    public static PreparedStatement getResult;
    public static PreparedStatement checkAdmin;
    public static PreparedStatement insertResult;
    public static PreparedStatement updateResult;
    public static PreparedStatement deleteResult;
    public static PreparedStatement getAllResult; 
    public static PreparedStatement changePass;
    public static PreparedStatement getResultByName;
    public static PreparedStatement getResultLike;
    static
    {
        try
        {
             Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","clg","system");
    st=con.createStatement();
    getResult=con.prepareStatement("select * from result where roll=?");
    getAllResult=con.prepareStatement("select * from result");
    insertResult=con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?)");
    updateResult=con.prepareStatement("update result set name=?,father_name=?,math=?,english=?,computer=?,science=?,sst=? where  roll=?");
    deleteResult=con.prepareStatement("delete from result where roll=?");
    checkAdmin=con.prepareStatement("select * from admin where eid=? and password=?");
    changePass=con.prepareStatement("update admin set password=? where eid=? and password=?");
    getResultByName=con.prepareStatement("select * from result where name=?");
    getResultLike=con.prepareStatement("select * from result where name like ?");
            }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,ex);
        }
        }
}