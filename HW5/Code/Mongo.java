import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.sql.*;
import java.util.Iterator;
import javax.xml.parsers.*;
import org.bson.Document;
import org.w3c.dom.*;

public class Mongo {

  public static void main(String[] args) throws Exception {
    try (MongoClient mongoClient = new MongoClient()) {
      MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
      dbObj.createCollection("phdthesis");

      Document doc = new Document("key", "phd/Hoff2002")
        .append("mdate", "2017-01-06")
        .append("author", "Gerd Hoff")
        .append(
          "title",
          "Ein Verfahren zur thematisch spezialisierten Suche im Web und seine Realisierung im Prototypen HomePageSearch"
        )
        .append("year", "2002")
        .append("school", "University of Trier, Germany")
        .append("pages", "1-315")
        .append("isbn", "978-3-86596-263-8")
        .append("ee", "http://ubt.opus.hbz-nrw.de/volltexte/2004/146/");
        dbObj.getCollection("phdthesis").insertOne(doc);

      // dbObj.drop();
    }
    // dbObj.createCollection("newcolzero");

    // MongoCollection<Document> col = dbObj.getCollection("newcolzero");
    // Document mydoc = new Document();
    // mydoc.put("name", "johnzzzz");
    // mydoc.put("role", "studentzzz");
    // col.insertOne(mydoc);

    // createPHDTHESIS();
  }

  public static void createPHDTHESIS() throws Exception {
    File inputFile = new File(
      "/Users/yiyanglin/Desktop/CS622/HW5/Code/sample.xml"
    );
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = (Document) dBuilder.parse(inputFile);
    ((org.w3c.dom.Document) doc).getDocumentElement().normalize();

    NodeList nList =
      ((org.w3c.dom.Document) doc).getElementsByTagName("phdthesis");

    for (int i = 0; i < nList.getLength(); i++) {
      Node nNode = nList.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        String sql =
          nNode.getAttributes().getNamedItem("key").getNodeValue() +
          nNode.getAttributes().getNamedItem("mdate").getNodeValue() +
          eElement.getElementsByTagName("author").item(0).getTextContent() +
          eElement.getElementsByTagName("title").item(0).getTextContent() +
          eElement.getElementsByTagName("year").item(0).getTextContent() +
          eElement.getElementsByTagName("school").item(0).getTextContent();
      }

      System.out.println("\nCurrent Element :" + nNode.getNodeName());

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        System.out.println(
          "author : " +
          eElement.getElementsByTagName("author").item(0).getTextContent()
        );
        System.out.println(
          nNode.getAttributes().getNamedItem("mdate").getNodeValue()
        );

        System.out.println(
          "title : " +
          eElement.getElementsByTagName("title").item(0).getTextContent()
        );
        System.out.println(
          "year : " +
          eElement.getElementsByTagName("year").item(0).getTextContent()
        );
        System.out.println(
          "school : " +
          eElement.getElementsByTagName("school").item(0).getTextContent()
        );
      }
    }
  }
}
