import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class Main {

  public static void main(String[] args) throws Exception {
    // buildPhDThesisTable(args[0]);
    // Used to create operating system processes.
    //  ProcessBuilder pb = new ProcessBuilder();
    //  // Get the file
    //  pb.command(new File(".").getCanonicalPath() + "/" + args[0]);
    //  Process process = pb.start();
    //  String result = read(process);
    //  System.out.print(result);

    buildPhDThesisTable(args[0]);
  }

  public static void buildDatabase(String file)
    throws IOException, ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    StringBuilder xmlStringBuilder = new StringBuilder();

    xmlStringBuilder.append("<?xml version=\"1.0\"?> <class> </class>");
    ByteArrayInputStream input = new ByteArrayInputStream(
      xmlStringBuilder.toString().getBytes("UTF-8")
    );
    // Document doc = builder.parse(input);

    // Element root = doc.getDocumentElement();
    // FileReader inputFile = new FileReader(file);
    // BufferedReader br = new BufferedReader(inputFile);
    // String line = br.readLine();

    // while (line != null) {

    //   line = line.replaceAll("\\<.*?\\>", "");
    //   if (line.isEmpty())
    //   {
    //     line = br.readLine();
    //   }
    //   System.out.println(line);
    //     line = br.readLine();

    // }
    // br.close();
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
      System.out.println("----------------------------");

      for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;

          System.out.println(
            "author : " +
            eElement.getElementsByTagName("author").item(0).getTextContent()
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
