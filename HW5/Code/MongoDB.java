import static com.mongodb.client.model.Filters.*;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.w3c.dom.*;

public class MongoDB {

  public static void main(String[] args) throws Exception {
    // MongoClient mongoClient = new MongoClient();
    // MongoDatabase dbObj = mongoClient.getDatabase("DBLP");

    // createWWW(mongoClient);
    // createPHDTHESIS(mongoClient);
    // createInproceedings(mongoClient);

    // query1(dbObj);
    // query2(dbObj);

    // mongoClient.close();
  }

  public static void query1(MongoDatabase dbObj) {
    
    int count = 0;
    for (String name : dbObj.listCollectionNames()) {
      if (name.equals("inproceedings")) {
        MongoCollection<Document> collection = dbObj.getCollection(name);
        Bson filter = Filters.regex("title", "of");
        Bson equalComparison = gt("year", "2012");

        Iterator<Document> it = collection
          .find()
          .filter(filter)
          .filter(equalComparison)
          .iterator();
        while (it.hasNext()) {
          System.out.println("QUERY 1 search for MACHINE ---> " + it.next());
          count += 1;
        }
        break;
      }
    }
    System.out.println(count);
  }

  public static void query2(MongoDatabase dbObj) {
for (String name : dbObj.listCollectionNames()) {
      if (name.equals("inproceedings")) {
        MongoCollection<Document> collection = dbObj.getCollection(name);

        Bson comparison1 = gt("year", "2004");
        Bson comparison2 = lt("year", "2008");

        Iterator<Document> it = collection
          .find()
          .filter(comparison1)
          .filter(comparison2)
          .iterator();
        while (it.hasNext()) {
          System.out.println("docs inside the col:" + it.next());
        }
        break;
      }
    }
  }

  public static void createWWW(MongoClient mongoClient) throws Exception {
    File inputFile = new File("sample.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("www");
    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
    dbObj.drop();
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
    dbObj.drop();
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
    dbObj.drop();
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
