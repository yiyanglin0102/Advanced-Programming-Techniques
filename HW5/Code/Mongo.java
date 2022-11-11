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
    // dbObj.createCollection("newcolzero");

    // MongoCollection<Document> col = dbObj.getCollection("newcolzero");
    // Document mydoc = new Document();
    // mydoc.put("name", "johnzzzz");
    // mydoc.put("role", "studentzzz");
    // col.insertOne(mydoc);

    createPHDTHESIS();
  }

  public static void createPHDTHESIS() throws Exception {
    File inputFile = new File("sample.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    org.w3c.dom.Document doc = dBuilder.parse(inputFile);
    doc.getDocumentElement().normalize();

    NodeList nList = doc.getElementsByTagName("phdthesis");
    MongoClient mongoClient = new MongoClient();
    MongoDatabase dbObj = mongoClient.getDatabase("DBLP");
    dbObj.drop();
    for (int i = 0; i < nList.getLength(); i++) {
      Node nNode = nList.item(i);

      if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        // dbObj.createCollection("phdthesis");

        Document obj = new Document(
          "key",
          nNode.getAttributes().getNamedItem("mdate").getNodeValue()
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
        // System.out.println("\nCurrent Element :" + nNode.getNodeName());
      }
    }
    mongoClient.close();
  }
}
