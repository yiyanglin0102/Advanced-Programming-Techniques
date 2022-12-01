import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

class Multithreading extends Thread {

  public void run() {
    try {
      Map<Integer, String> dna = new HashMap<>();
      dna.put(0, "A");
      dna.put(1, "T");
      dna.put(2, "C");
      dna.put(3, "G");

      Random rand = new Random();
      int num;
      String sequence;

      // Run 100 sequences for each Thread
      for (int j = 0; j < 100; j++) {
        sequence = "";
        for (int i = 0; i < 10; i++) {
          num = rand.nextInt(4);
          sequence += dna.get(num);
        }

        System.out.println(sequence);
      }
    } catch (Exception e) {
      System.out.println("Thread Exception is caught");
    }
  }
}

public class Multithread {

  public static void main(String[] args) {
    Timestamp instant1 = Timestamp.from(Instant.now());

    // Create 100 Threads
    for (int i = 0; i < 100; i++) {
      Multithreading sequence = new Multithreading();
      sequence.start();
    }

    Timestamp instant2 = Timestamp.from(Instant.now());

    System.out.println(instant1);
    System.out.println(instant2);
  }
}
