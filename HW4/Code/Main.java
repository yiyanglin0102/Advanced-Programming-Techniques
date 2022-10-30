import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {

    // Used to create operating system processes.
    ProcessBuilder pb = new ProcessBuilder();
    // Get the file
    pb.command(new File(".").getCanonicalPath() + "/" + args[0]);
    Process process = pb.start();
    String result = read(process);
    System.out.print(result);
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
