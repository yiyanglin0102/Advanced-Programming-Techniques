import java.io.*;
import java.sql.*;
import java.util.Date;
import java.util.regex.Pattern;

public class Search {

  public static void main(String[] args) throws Exception {
    String file = "./data/test4";
    addHistory(args[1]);

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
        String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

        System.out.println("Name of the project " + tokens[23]);
        System.out.println("Category " + tokens[2]);
        System.out.println();
      }

      line = br.readLine();
    }

    br.close();
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
