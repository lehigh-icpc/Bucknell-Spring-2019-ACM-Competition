import java.util.*;
public class Main {
  static Set<Integer> primes;
  public static void main(String[] args) {
    // Precompute primes
    primes = new HashSet<Integer>();
    calcPrimes();

    // Read input
    Scanner scan = new Scanner(System.in);
    while (true) {
      int size = scan.nextInt();
      if (size == 0) {
        return;
      }
      printAllRingsOfSize(size);
    }
  }

  private static void printAllRingsOfSize(int n) {
    int[] ring = new int[n];
    ring[0] = 1;
    boolean[] used = new boolean[n + 1];
    used[1] = true;
    findRings(ring, used, 1);
  }

  private static void findRings(int[] ring, boolean[] used, int index) {
    if (index == ring.length) {
      printRing(ring);
      return;
    }
    for (int num = 2; num < used.length; num++) {
      if (!used[num]) {
        if (primes.contains(num + ring[index-1])) {
          // special case, last needs to be prime with first
          if (index == ring.length - 1 && !primes.contains(num + ring[0]))
            continue;
          used[num] = true;
          ring[index] = num;
          findRings(ring, used, index + 1);
          used[num] = false;
        }
      }
    }
  }

  private static void printRing(int[] ring) {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (int num : ring) {
      if (!first) {
        sb.append(" ");
      }
      first = false;
      sb.append(num);
    }
    System.out.println(sb.toString());
  }

  private static void calcPrimes() {
    for (int i = 2; i < 100; i++) {
      if (isPrime(i)) {
        primes.add(i);
      }
    }
  }

  private static boolean isPrime(int n) {
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
