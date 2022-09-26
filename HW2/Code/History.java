import java.io.*;
import java.util.regex.Pattern;

public class History {

  public static void main(String[] args) throws Exception {
    checkHistory(args[0]);
  }

  public static void checkHistory(String input) throws IOException {
    try {
      FileReader inputFile = new FileReader(".history");
      BufferedReader br = new BufferedReader(inputFile);
      int count = 0;
      String line = br.readLine();
      while (line != null) {
        if (
          input.toUpperCase().equals(line.split(" ")[1].toUpperCase())
        ) {
          count += 1;
        }

        line = br.readLine();
      }
      System.out.println(
        input + ", " + count + " times in searching history..."
      );

      if (count > 0) {
        printTimestamp(input);
      }

      br.close();
    } catch (IOException ioe) {
      System.out.println("Exception caught: No searching history found...");
    }
  }

  public static void printTimestamp(String input) throws IOException {
    FileReader inputFile = new FileReader(".history");
    BufferedReader br = new BufferedReader(inputFile);
    String line = br.readLine();
    while (line != null) {
      if (
        Pattern
          .compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE)
          .matcher(line)
          .find()
      ) {
        String[] result = line.split(" ");
        System.out.println(result[2] + " " + result[3]);
      }

      line = br.readLine();
    }
    br.close();
  }
}
