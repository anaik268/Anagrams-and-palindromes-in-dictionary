import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AllPalindromes {

  public static void main(String[] args) {
    Elist<String> words = new Elist<String>();
    Elist<String> palindromes = new Elist<String>();
    File file = new File("src/words.txt");

    long start = System.currentTimeMillis();

    try {
      Scanner scanner = new Scanner(file);
      while (scanner.hasNext()) {
        String line = scanner.next();
        words.addToEnd(line);
        if (line.equals(reverse(line))) {
          palindromes.addToEnd(line);
          System.out.println(line);
        }
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println("read in " + words.size() + " words.");
    System.out.println("Number of palindromes: " + palindromes.size());
    //System.out.println(palindromes);
    long middle = System.currentTimeMillis();

    System.out.println("Elapsed time: " + (middle - start));
  }

  static String reverse(String st) {
    if (st.length() <= 1)
      return st;
    return st.charAt(st.length() - 1)
        + reverse(st.substring(0, st.length() - 1));
  }
}
