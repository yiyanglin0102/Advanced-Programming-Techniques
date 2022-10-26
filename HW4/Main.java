import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    ProcessBuilder pb = new ProcessBuilder();
    pb.command(new File(".").getCanonicalPath() + "/script.sh");
    Process process = pb.start();
    String result = read(process);
	System.out.println(result);
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
