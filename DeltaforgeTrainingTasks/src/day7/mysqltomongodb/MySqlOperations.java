package day7.mysqltomongodb;

import java.sql.*;

public class MySqlOperations {

    private static final String sqlUrl = "jdbc:mysql://localhost:3306/sample";
    private static final String sqlUser = "root";
    private static final String sqlPass = "1234";
    static Connection con;
    
    public  void mySqlReadAll() throws SQLException {
        con = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
        Statement st = con.createStatement();
        String query = "select * from students";
        ResultSet rs = st.executeQuery(query);

        while (rs.next()){
            System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3));
        }
        con.close();
        System.out.println();
    }

    public  void mySqlRead(int id) throws SQLException {
        con = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
        Statement st = con.createStatement();
        String query = "select sid, sname, sroll from students where sid = " + id;
        ResultSet rs = st.executeQuery(query);
        rs.next();
        System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3));
    }

    public  void mySqlCreate(int id, String name, int roll) throws SQLException {
        con = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
        Statement st = con.createStatement();

        String query = "insert into students values (" + id + ", " + "'"+ name +"'" + ", " + roll + ")" ;
        st.execute(query);
    }

    public  void mySqlUpdate(String name, int id) throws SQLException {
        con = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
        Statement st = con.createStatement();
        String query = "update students set sname = '"+ name + "' where sid =" + id;
        st.execute(query);
    }

    public  void mySqlDelete(int id) throws SQLException {
        con = DriverManager.getConnection(sqlUrl,sqlUser,sqlPass);
        Statement st = con.createStatement();
        String query = "delete from students where sid =" + id;
        st.execute(query);
    }

}
