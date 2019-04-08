import java.util.*;

public class Main {
  static class House {
    int index;
    boolean visited;
    int dist;
    House p;
    Set<House> connections;
    House(int i) {
      index = i;
      connections = new HashSet<>();
    }
    void connect(House other) {
      connections.add(other);
      other.connections.add(this);
    }
  }
  public static void main(String[] args) {
    // Create the houses (lazy so house[0] will be ignored)
    House[] houses = new House[21];
    for (int i = 0; i < houses.length; i++) {
      houses[i] = new House(i);
    }
    // Connect houses (first 19 lines)
    Scanner s = new Scanner(System.in);
    for (int src = 1; src <= 19; src++) {
      String line = s.nextLine();
      String[] split = line.split(" ");
      // ignore first number
      for (int i = 1; i < split.length; i++) {
        int dst = Integer.parseInt(split[i]);
        houses[src].connect(houses[dst]);
      }
    }
    // Test cases
    int numTestCases = s.nextInt();
    for (int caseNum = 0; caseNum < numTestCases; caseNum++) {
      int src = s.nextInt();
      int dst = s.nextInt();
      int dist = distBetween(houses, src, dst);
      System.out.println(src + " to " + dst + ": " + dist);
    }
    s.close();
  }

  private static int distBetween(House[] houses, int srcI, int dstI) {
    // Reset visited, distances, and predecessors
    for (House h : houses) {
      h.dist = Integer.MAX_VALUE;
      h.visited = false;
      h.p = null;
    }

    House src = houses[srcI];
    src.dist = 0;
    src.visited = true;
    src.p = null;

    Queue<House> q = new ArrayDeque<>();
    q.add(src);

    while (!q.isEmpty()) {
      House cur = q.poll();
      cur.visited = true;
      for (House h : cur.connections) {
        if (!h.visited) {
          h.visited = true;
          h.dist = cur.dist + 1;
          h.p = cur;
          q.add(h);
        }
      }
    }

    return houses[dstI].dist;
  }
}
