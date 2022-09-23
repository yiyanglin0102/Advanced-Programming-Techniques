import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Merge {

  public static void main(String[] args) throws Exception {
    System.out.println(args[1]);

    FileReader inputFile = new FileReader("test4");
    BufferedReader br = new BufferedReader(inputFile);
    String line = br.readLine();
    while (line != null) {
      if (
        Pattern
          .compile(Pattern.quote(args[1]), Pattern.CASE_INSENSITIVE)
          .matcher(line)
          .find()
      ) {
        String[] namesList = line.split(",");
        System.out.println(namesList[0]);
      }
      
      line = br.readLine();
      
    }

    br.close();
  }
}
