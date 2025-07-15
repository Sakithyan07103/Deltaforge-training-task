package day7.mysqltomongodb;

import java.sql.*;
import java.util.Scanner;

public class MySQLToMongoMigrator {
    static Scanner sc = new Scanner(System.in);
    static String url = "jdbc:mysql://localhost:3306/sample";
    static String user = "root";
    static String pass = "1234";
    static Connection con;

    public static void main(String[] args) throws Exception{
       // create(6,"nivedhidha" , 113);
//       readAll();
//       read(1);
       // update("sanjay sundaram",4);
        delete(6);

    }

    public static void readAll() throws SQLException {
        con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        String query = "select * from students";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()){
            System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3));
        }
        con.close();
        System.out.println();
    }

    public static void read(int id) throws SQLException {
        con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        String query = "select sid, sname, sroll from students where sid = " + id;
        ResultSet rs = st.executeQuery(query);
        rs.next();
        System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3));
    }

    public static void create(int id, String name, int roll) throws SQLException {
        con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();

        String query = "insert into students values (" + id + ", " + "'"+ name +"'" + ", " + roll + ")" ;
        st.execute(query);
    }

    public static void update(String name, int id) throws SQLException {
        con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        String query = "update students set sname = '"+ name + "' where sid =" + id;
        st.execute(query);
    }

    public static void delete(int id) throws SQLException {
        con = DriverManager.getConnection(url,user,pass);
        Statement st = con.createStatement();
        String query = "delete from students where sid =" + id;
        st.execute(query);
    }

}
