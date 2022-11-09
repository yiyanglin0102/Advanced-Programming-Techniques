import java.io.*;
import java.sql.*;

public class Test {

  public static void main(String[] args) throws Exception {
    try {
        // Connection mysqlConnect = new Connection();

      Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/met622",
        "root",
        ""
      );
      System.out.println("--->" + con.toString());
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from pet");
      while (rs.next()) {
        System.out.println(
          "row:" +
          rs.getString(1) +
          "," +
          rs.getString(2) +
          "," +
          rs.getString(3)
        );
      }
      con.close();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
