import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.Pattern;

public class Search {

  public static void main(String[] args) throws Exception {
    addHistory(args[1]);
    search(args[0], args[1]);
  }

  public static void search(String file, String input) throws IOException {
    try {
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
          String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
          System.out.println(
            "Name of Project: " + tokens[tokens.length - 15].replace("\"", "")
          );
          System.out.println(
            "Funding Amount: " + tokens[tokens.length - 2].replace("\"", "")
          );
          System.out.println("Category: " + tokens[3].replace("\"", ""));
          System.out.println();
        }

        line = br.readLine();
      }

      br.close();
    } catch (IOException ioe) {
      System.out.println("Exception caught: No '" + file + "' found...");
    }
  }

  public static void addHistory(String input) throws IOException {
    FileWriter writerHistory = new FileWriter(".history", true);
    Date date = new Date();
    Timestamp timestamp = new Timestamp(date.getTime());

    try (
      BufferedWriter historyBufferWriter = new BufferedWriter(writerHistory)
    ) {
      historyBufferWriter.write("search " + input + " " + timestamp);
      historyBufferWriter.newLine();
      historyBufferWriter.close();
    }
  }
}
