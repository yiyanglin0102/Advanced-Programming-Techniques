import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // buildPhDThesisTable(args[0]);
    buildPhDThesisTable("sample.xml");
    // buildWWWTable("/Users/yiyanglin/Desktop/CS622/HW5/Code/sample.xml");
    // readFile("/Users/yiyanglin/Desktop/CS622/HW5/Code/dblp.xml");
  }

  public static void readFile(String file) throws IOException {
    FileInputStream inputStream = null;
    Scanner sc = null;

    try {
      inputStream =
        new FileInputStream("/Users/yiyanglin/Desktop/CS622/HW5/Code/dblp.xml");
      sc = new Scanner(inputStream, "UTF-8");
      while (sc.hasNextLine()) {
        String line = sc.nextLine();
        System.out.println(line);
      }
      // note that Scanner suppresses exceptions
      if (sc.ioException() != null) {
        throw sc.ioException();
      }
    } finally {
      if (inputStream != null) {
        inputStream.close();
      }
      if (sc != null) {
        sc.close();
      }
    }
  }

  public static void buildWWWTable(String file) {
    try {
      File inputFile = new File(file);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      NodeList nodeList = doc.getElementsByTagName("www");
      System.out.println(
        "Root element :" + doc.getDocumentElement().getAttribute("mdate")
      );
      for(int x=0,size= nodeList.getLength(); x<size; x++) {
        System.out.println(nodeList.item(x).getAttributes().getNamedItem("mdate").getNodeValue());
    }

      //////////////
      // NodeList nList = doc.getElementsByTagName("article");
      // System.out.println("here1 :" + nList.item(0).getNodeName());
      // Node nNode = nList.item(0);
      // Element eElement = (Element) nNode;
      // System.out.println("here2 :" + ((Element) nNode).getElementsByTagName("author").item(0).getTextContent());
      // System.out.println();
      //////////////
      // for (int i = 0; i < nList.getLength(); i++) {
      // Node nNode = nList.item(i);
      // System.out.println("\nCurrent Element :" + nNode.getNodeName());

      // if (nNode.getNodeType() == Node.ELEMENT_NODE) {
      // Element eElement = (Element) nNode;
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
      // }
      // }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void buildPhDThesisTable(String file) {
    try {
      File inputFile = new File(file);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      System.out.println(
        "Root element :" + doc.getDocumentElement().getNodeName()
      );
      NodeList nList = doc.getElementsByTagName("phdthesis");
      
      for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          System.out.println(
            "author : " +
            eElement.getElementsByTagName("author").item(0).getTextContent()
          );
          System.out.println(nNode.getAttributes().getNamedItem("mdate").getNodeValue());

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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static String read(Process process) throws IOException {
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(process.getInputStream())
    );
    StringBuilder builder = new StringBuilder();
    String line = null;
    while ((line = reader.readLine()) != null) {
      builder.append(line);
      builder.append(System.getProperty("line.separator"));
    }
    String result = builder.toString();
    return result;
  }
}
