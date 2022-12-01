import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

public class Single {

  public static void main(String[] args) {
    Map<Integer, String> dna = new HashMap<>();
    dna.put(0, "A");
    dna.put(1, "T");
    dna.put(2, "C");
    dna.put(3, "G");

    Random rand = new Random();
    int num;
    String sequence;

    Timestamp instant1 = Timestamp.from(Instant.now());

    // Run 10000 sequences 
    for (int j = 0; j < 10000; j++) {
      sequence = "";
      for (int i = 0; i < 10; i++) {
        num = rand.nextInt(4);
        sequence += dna.get(num);
      }

      System.out.println(sequence);
    }
    Timestamp instant2 = Timestamp.from(Instant.now());
    System.out.println(instant1);
    System.out.println(instant2);
  }
}
