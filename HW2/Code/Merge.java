import java.io.*;
import java.util.*;

public class Merge {

  public static void main(String[] args) throws Exception {
    int argc = args.length;
    ArrayList<String> list = new ArrayList<>();

    for (int i = 1; i < argc; i++) {
      list.add(args[i]);
    }

    ArrayList<FileReader> listOfFiles = new ArrayList<>();
    for (String s : list) {
      FileReader inputFile = new FileReader(s);
      listOfFiles.add(inputFile);
    }

    FileWriter writer = new FileWriter(args[0]);
    BufferedWriter buffer = new BufferedWriter(writer);

    int index = 0;

    for (FileReader f : listOfFiles) {
      BufferedReader br = new BufferedReader(f);
      int i;
      buffer.write(String.valueOf(index) + " --> , ");

      while ((i = br.read()) != -1) {
        buffer.write((char) i);
        if ((char) i == '\n') {
          index += 1;
          buffer.write(String.valueOf(index) + " --> , ");
        }
      }
      index += 1;
      buffer.newLine();

      br.close();
      f.close();
      System.out.println();
    }

    buffer.close();
    writer.close();
    System.out.println("Success!");
    System.out.println();
  }
}
