import java.io.*;
// import java.util.*;
import java.util.regex.Pattern;

public class Search {

  public static void main(String[] args) throws Exception {
    String file = "mergedFile.csv";
    addHistory(args[1]);
    checkHistory(args[1]);
    search(args[1], file);
  }

  public static void search(String input, String file) throws IOException {
    FileReader inputFile = new FileReader(file);
    BufferedReader br = new BufferedReader(inputFile);
    String line = br.readLine();
    while (line != null) {
      if (
        Pattern
          .compile(Pattern.quote(input), Pattern.CASE_INSENSITIVE)
          .matcher(line)
          .find()
      ) {
        System.out.println(line);
      }

      line = br.readLine();
    }

    br.close();
  }

  public static void addHistory(String input) throws IOException {
    FileWriter writerHistory = new FileWriter(".history", true);

    try (
      BufferedWriter historyBufferWriter = new BufferedWriter(writerHistory)
    ) {
      historyBufferWriter.write("search " + input);
      historyBufferWriter.newLine();
      historyBufferWriter.close();
    }
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
    System.out.println("Searched " + input + " " + count + " times...");
    br.close();
  }
}
