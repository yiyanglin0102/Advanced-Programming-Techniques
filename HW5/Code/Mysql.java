import java.io.*;
import java.sql.*;

public class Mysql {

  public static void main(String[] args) throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      String sql1 = "DROP TABLE Pet;";
      String sql2 =
        "CREATE TABLE PHDTHESIS " +
        "(key VARCHAR(30), " +
        "author VARCHAR(30), " +
        "title VARCHAR(30), " +
        "year YEAR(4), " +
        "school ;" +
        "pages "
        ;


      String sql3 =
        "insert into Pet values(\"puffball\",\"nobody\",\"hamster\",\"M\");";

      stmt.executeUpdate(sql1);
      stmt.executeUpdate(sql2);
      stmt.executeUpdate(sql3);

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
