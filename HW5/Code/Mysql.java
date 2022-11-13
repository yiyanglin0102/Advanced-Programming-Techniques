import java.io.*;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class MySQL {

  public static void main(String[] args) throws Exception {
    createPHDTHESIS();
    createWWW();
    createInproceedings();

    query1_0(
      "SELECT * FROM inproceedings WHERE title LIKE \'%design%\' AND year > 2000;"
    );
    
    query1_1(
      "SELECT COUNT(*) as total FROM inproceedings WHERE title LIKE \'%design%\' AND year > 2000;"
    );

    query2(
      "SELECT * FROM Inproceedings WHERE title LIKE \'%of%\' AND mdate between \'2008-01-01\' and \'2010-01-31\';"
    );
  }

  public static void query1_0(String query) throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        String key = rs.getString("tagKey");
        String title = rs.getString("title");
        String year = rs.getString("year");
        String author = rs.getString("author");

        System.out.format("%s, %s, %s, %s\n", key, title, author, year);
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void query1_1(String query) throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        System.out.format("%d\n", rs.getInt("total"));
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void query2(String query) throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
        String key = rs.getString("tagKey");
        String title = rs.getString("title");
        String year = rs.getString("year");
        String author = rs.getString("author");
        String mdate = rs.getString("mdate");

        // print the results
        System.out.format("%s, %s, %s, %s\n", key, title, author, year, mdate);
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void createInproceedings() throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      File inputFile = new File(
        "/Users/yiyanglin/Desktop/CS622/HW5/Code/sample.xml"
      );
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      String sql1 = "DROP TABLE INPROCEEDINGS;";
      stmt.executeUpdate(sql1);

      String sql2 =
        "CREATE TABLE " +
        "INPROCEEDINGS" +
        " (tagkey VARCHAR(100), mdate DATE, author VARCHAR(50), title VARCHAR(200), pages VARCHAR(50), year YEAR(4), ee VARCHAR(300), url VARCHAR(300));";
      stmt.executeUpdate(sql2);

      NodeList nList = doc.getElementsByTagName("inproceedings");

      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          String sql3 =
            "insert into INPROCEEDINGS values(\"" +
            nNode.getAttributes().getNamedItem("key").getNodeValue() +
            "\",\"" +
            nNode.getAttributes().getNamedItem("mdate").getNodeValue() +
            "\",\"" +
            eElement.getElementsByTagName("author").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("title").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("pages").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("year").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("ee").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("url").item(0).getTextContent() +
            "\");";

          stmt.executeUpdate(sql3);
        }
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void createWWW() throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      String sql1 = "DROP TABLE WWW;";
      stmt.executeUpdate(sql1);

      File inputFile = new File(
        "/Users/yiyanglin/Desktop/CS622/HW5/Code/sample.xml"
      );

      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      String sql2 =
        "CREATE TABLE " +
        "WWW" +
        " (tagkey VARCHAR(20), mdate DATE, author VARCHAR(50), title VARCHAR(300));";
      stmt.executeUpdate(sql2);

      NodeList nList = doc.getElementsByTagName("www");

      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          String sql3 =
            "insert into WWW values(\"" +
            nNode.getAttributes().getNamedItem("key").getNodeValue() +
            "\",\"" +
            nNode.getAttributes().getNamedItem("mdate").getNodeValue() +
            "\",\"" +
            eElement.getElementsByTagName("author").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("title").item(0).getTextContent() +
            // "\",\"" +
            // eElement.getElementsByTagName("url").item(0).getTextContent() +
            // "\",\"" +
            // eElement.getElementsByTagName("year").item(0).getTextContent() +
            "\");";

          stmt.executeUpdate(sql3);
        }
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void createPHDTHESIS() throws Exception {
    try (
      Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/cs622",
        "root",
        ""
      );
      Statement stmt = conn.createStatement();
    ) {
      // String sql1 = "DROP TABLE phdthesis;";
      // stmt.executeUpdate(sql1);

      File inputFile = new File(
        "/Users/yiyanglin/Desktop/CS622/HW5/Code/sample.xml"
      );
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      String sql2 =
        "CREATE TABLE " +
        "PHDTHESIS" +
        " (tagkey VARCHAR(20), mdate DATE, author VARCHAR(50), title VARCHAR(300), year YEAR(4), school VARCHAR(50));";
      stmt.executeUpdate(sql2);

      NodeList nList = doc.getElementsByTagName("phdthesis");

      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          String sql3 =
            "insert into PHDTHESIS values(\"" +
            nNode.getAttributes().getNamedItem("key").getNodeValue() +
            "\",\"" +
            nNode.getAttributes().getNamedItem("mdate").getNodeValue() +
            "\",\"" +
            eElement.getElementsByTagName("author").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("title").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("year").item(0).getTextContent() +
            "\",\"" +
            eElement.getElementsByTagName("school").item(0).getTextContent() +
            "\");";

          stmt.executeUpdate(sql3);
        }
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
