import java.io.*;
// import java.util.*;
import java.util.regex.Pattern;

public class History {

  public static void main(String[] args) throws Exception {
    checkHistory(args[0]);
  }

  public static void checkHistory(String input) throws IOException {
    FileReader inputFile = new FileReader(".history");
    BufferedReader br = new BufferedReader(inputFile);
    int count = 0;
    String line = br.readLine();
    while (line != null) {
      if (
        Pattern
          .compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE)
          .matcher(line)
          .find()
      ) {
        count += 1;
      }

      line = br.readLine();
    }
    System.out.println(input + ", " + count + " times in searching history...");

    if (count > 0) {
      printTimestamp(input);
    }

    br.close();
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
