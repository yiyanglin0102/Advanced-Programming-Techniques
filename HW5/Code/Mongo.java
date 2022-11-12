import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.bson.*;
import org.bson.Document;
import org.w3c.dom.*;

public class Mongo {

  public static void main(String[] args) throws Exception {
    MongoClient mongoClient = new MongoClient();

    // createWWW(mongoClient);
    // createPHDTHESIS(mongoClient);
    // createInproceedings(mongoClient);

    query1("SELECT * FROM inproceedings WHERE title LIKE '%{$computer}%'");
    query2("SELECT * FROM inproceedings");

    mongoClient.close();
  }

  public static void query1(String string) {
    // initialize the client object
    MongoClient mongoClient = new MongoClient();
    // get the 'test' dataset
    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");

    // list its collections

    for (String name : dbObj.listCollectionNames()) {
      System.out.println();
      System.out.println();
      System.out.println("Collections inside this db:" + name);

      MongoCollection<Document> col = dbObj.getCollection(name);
      Iterator it = col.find().iterator();
      while (it.hasNext()) {
        System.out.println(name + " docs inside the Collection ----> " + it.next());
      }
    }
  }

  public static void query2(String string) {}

  public static void createWWW(MongoClient mongoClient) throws Exception {
    File inputFile = new File("sample.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("www");
    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
    // dbObj.drop();
    for (int i = 0; i < nList.getLength(); i++) {
      Node nNode = nList.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        Document obj = new Document(
          "key",
          nNode.getAttributes().getNamedItem("key").getNodeValue()
        )
          .append(
            "mdate",
            nNode.getAttributes().getNamedItem("mdate").getNodeValue()
          )
          .append(
            "author",
            eElement.getElementsByTagName("author").item(0).getTextContent()
          )
          .append(
            "title",
            eElement.getElementsByTagName("title").item(0).getTextContent()
          );
        // .append(
        //   "year",
        //   eElement.getElementsByTagName("year").item(0).getTextContent()
        // )
        // .append(
        //   "school",
        //   eElement.getElementsByTagName("school").item(0).getTextContent()
        // )
        // .append(
        //   "pages",
        //   eElement.getElementsByTagName("pages").item(0).getTextContent()
        // )
        // .append(
        //   "isbn",
        //   eElement.getElementsByTagName("isbn").item(0).getTextContent()
        // )
        // .append(
        //   "ee",
        //   eElement.getElementsByTagName("ee").item(0).getTextContent()
        // );
        dbObj.getCollection(nNode.getNodeName()).insertOne(obj);
      }
    }
  }

  public static void createPHDTHESIS(MongoClient mongoClient) throws Exception {
    File inputFile = new File("sample.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("phdthesis");
    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
    // dbObj.drop();
    for (int i = 0; i < nList.getLength(); i++) {
      Node nNode = nList.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        // dbObj.createCollection("phdthesis");

        Document obj = new Document(
          "key",
          nNode.getAttributes().getNamedItem("key").getNodeValue()
        )
          .append(
            "mdate",
            nNode.getAttributes().getNamedItem("mdate").getNodeValue()
          )
          .append(
            "author",
            eElement.getElementsByTagName("author").item(0).getTextContent()
          )
          .append(
            "title",
            eElement.getElementsByTagName("title").item(0).getTextContent()
          )
          .append(
            "year",
            eElement.getElementsByTagName("year").item(0).getTextContent()
          )
          .append(
            "school",
            eElement.getElementsByTagName("school").item(0).getTextContent()
          );
        // .append(
        //   "pages",
        //   eElement.getElementsByTagName("pages").item(0).getTextContent()
        // )
        // .append(
        //   "isbn",
        //   eElement.getElementsByTagName("isbn").item(0).getTextContent()
        // )
        // .append(
        //   "ee",
        //   eElement.getElementsByTagName("ee").item(0).getTextContent()
        // );
        dbObj.getCollection(nNode.getNodeName()).insertOne(obj);
      }
    }
  }

  public static void createInproceedings(MongoClient mongoClient)
    throws Exception {
    File inputFile = new File("sample.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("inproceedings");

    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
    // dbObj.drop();
    for (int i = 0; i < nList.getLength(); i++) {
      Node nNode = nList.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        Document obj = new Document(
          "key",
          nNode.getAttributes().getNamedItem("key").getNodeValue()
        )
          .append(
            "mdate",
            nNode.getAttributes().getNamedItem("mdate").getNodeValue()
          )
          .append(
            "author",
            eElement.getElementsByTagName("author").item(0).getTextContent()
          )
          .append(
            "title",
            eElement.getElementsByTagName("title").item(0).getTextContent()
          )
          .append(
            "year",
            eElement.getElementsByTagName("year").item(0).getTextContent()
          )
          .append(
            "pages",
            eElement.getElementsByTagName("pages").item(0).getTextContent()
          )
          .append(
            "ee",
            eElement.getElementsByTagName("ee").item(0).getTextContent()
          )
          .append(
            "crossref",
            eElement.getElementsByTagName("crossref").item(0).getTextContent()
          )
          .append(
            "booktitle",
            eElement.getElementsByTagName("booktitle").item(0).getTextContent()
          )
          .append(
            "url",
            eElement.getElementsByTagName("url").item(0).getTextContent()
          );
        dbObj.getCollection(nNode.getNodeName()).insertOne(obj);
      }
    }
  }
}
