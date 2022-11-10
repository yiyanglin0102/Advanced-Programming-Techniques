import java.io.*;
import java.sql.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Mysql {

  public static void main(String[] args) throws Exception {
    // createPHDTHESIS();
    // createWWW();
    // createInproceedings();
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
        " (tagkey VARCHAR(100), mdate VARCHAR(50), author VARCHAR(50), title VARCHAR(200), pages VARCHAR(50), year YEAR(4), ee VARCHAR(300), url VARCHAR(300));";
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
          // String sql3 =
          //   "insert into PHDTHESIS values(\"persons/Ley93\",\"2005-10-06\",\"Michael Ley\",\"DBLP.uni-trier.de: Computer Science Bibliography\");";
          // System.out.println(
          //   "author : " +
          //   eElement.getElementsByTagName("author").item(0).getTextContent()
          // );
          // System.out.println(
          //   "title : " +
          //   eElement.getElementsByTagName("title").item(0).getTextContent()
          // );
          // System.out.println(
          //   "year : " +
          //   eElement.getElementsByTagName("year").item(0).getTextContent()
          // );
          // System.out.println(
          //   "school : " +
          //   eElement.getElementsByTagName("school").item(0).getTextContent()
          // );
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
        " (tagkey VARCHAR(20), mdate VARCHAR(50), author VARCHAR(50), title VARCHAR(300));";
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
          // String sql3 =
          //   "insert into PHDTHESIS values(\"persons/Ley93\",\"2005-10-06\",\"Michael Ley\",\"DBLP.uni-trier.de: Computer Science Bibliography\");";
          // System.out.println(
          //   "author : " +
          //   eElement.getElementsByTagName("author").item(0).getTextContent()
          // );
          // System.out.println(
          //   "title : " +
          //   eElement.getElementsByTagName("title").item(0).getTextContent()
          // );
          // System.out.println(
          //   "year : " +
          //   eElement.getElementsByTagName("year").item(0).getTextContent()
          // );
          // System.out.println(
          //   "school : " +
          //   eElement.getElementsByTagName("school").item(0).getTextContent()
          // );
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
      String sql1 = "DROP TABLE phdthesis;";
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
        "PHDTHESIS" +
        " (tagkey VARCHAR(20), mdate VARCHAR(50), author VARCHAR(50), title VARCHAR(300), year YEAR(4), school VARCHAR(50));";
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
          // String sql3 =
          //   "insert into PHDTHESIS values(\"persons/Ley93\",\"2005-10-06\",\"Michael Ley\",\"DBLP.uni-trier.de: Computer Science Bibliography\");";
          // System.out.println(
          //   "author : " +
          //   eElement.getElementsByTagName("author").item(0).getTextContent()
          // );
          // System.out.println(
          //   "title : " +
          //   eElement.getElementsByTagName("title").item(0).getTextContent()
          // );
          // System.out.println(
          //   "year : " +
          //   eElement.getElementsByTagName("year").item(0).getTextContent()
          // );
          // System.out.println(
          //   "school : " +
          //   eElement.getElementsByTagName("school").item(0).getTextContent()
          // );
        }
      }

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
