import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    while (true) {
      String line = s.nextLine();
      String[] splits = line.split(" ");

      int numTeams = Integer.parseInt(splits[0]);
      if (numTeams == 0) return;

      int numSafe = Integer.parseInt(splits[1]);
      
      int[] cards = new int[splits.length - 2];
  
      for (int i = 2; i < splits.length; i++) {
        cards[i-2] = Integer.parseInt(splits[i]);
      }
  
      printSafeSpots(numTeams, numSafe, cards);
    }
  }

  private static void printSafeSpots(int numTeams, int numToSave, int[] cards) {
    boolean[] isSafe = new boolean[numTeams];
    for (int i = 0; i < isSafe.length; i++) isSafe[i] = true;

    int numSafe = numTeams;

    for (int cardVal : cards) {
      int fakeI = 0;
      for (int i = 0; i < isSafe.length; i++) {
        if (isSafe[i]) {
          fakeI++;
        }
        else {
          continue;
        }
        if (fakeI % cardVal == 0) {
          isSafe[i] = false;
          numSafe--;
          if (numSafe == numToSave) break;
        }
      }
      if (numSafe == numToSave) break;
    }

    // Print the safe indexes + 1
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (int i = 0; i < isSafe.length; i++) {
      if (isSafe[i]) {
        if (!first) {
          sb.append(" ");
        }
        first = false;
        sb.append(i + 1);
      }
    }
    System.out.println(sb.toString());
  }
}
