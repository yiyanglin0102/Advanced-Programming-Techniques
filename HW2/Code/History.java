import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class History {

  // create a HashMap to quickly access the timestamp data
  static HashMap<String, ArrayList<String>> mapping = new HashMap<>();

  public static void main(String[] args) throws Exception {
    storeHistory(args[0]);
    checkHistory(args[0]);
  }

  public static void checkHistory(String input) throws IOException {

    //if the '.history' file not exist, the exception will be catched
    try {
      FileReader inputFile = new FileReader(".history");
      BufferedReader br = new BufferedReader(inputFile);
      int count = 0;
      String line = br.readLine();
      while (line != null) {
        if (input.toUpperCase().equals(line.split(" ")[1].toUpperCase())) {
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

  // restore the timestamp data from HashMap structure and print it out
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
        String store = result[2] + " " + result[3];

        System.out.println(store);
      }

      line = br.readLine();
    }
    br.close();
  }

  // when it start read '.history' file, it starts storing timestamp data
  // at the same time, if the search word do not be searched before, it will
  // create a new key value pair in Hashmap
  public static void storeHistory(String input) throws IOException {
    try {
      FileReader inputFile = new FileReader(".history");
      BufferedReader br = new BufferedReader(inputFile);

      String line = br.readLine();
      while (line != null) {
        String[] tokens = line.split(" ");
        if (tokens[0].equals("search")) {
          if (mapping.containsKey(tokens[1])) {
            mapping.get(tokens[1]).add(tokens[2] + " " + tokens[3]);
          } else {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(tokens[2] + " " + tokens[3]);
            mapping.put(tokens[1], temp);
          }
        }
        line = br.readLine();
      }
      br.close();
    } catch (IOException ioe) {
      System.out.println("Exception caught: No searching history found...");
    }
  }
}
