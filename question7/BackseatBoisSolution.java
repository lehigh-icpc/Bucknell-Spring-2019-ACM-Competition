import java.util.*;

public class Main {
  static class Coin {
    int weight;
    int value;
    Coin(int w, int v) {
      weight = w;
      value = v;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int numTests = scan.nextInt();

    for (int tNum = 0; tNum < numTests; tNum++) {
      runTestCase(scan);
    }
  }

  private static void runTestCase(Scanner scan) {
    int emptyWeight = scan.nextInt();
    int filledWeight = scan.nextInt();
    int totalCoinWeight = filledWeight - emptyWeight;
    
    int numTypesOfCoins = scan.nextInt();
    Coin[] coins = new Coin[numTypesOfCoins];
    for (int coinType = 0; coinType < numTypesOfCoins; coinType++) {
      int value = scan.nextInt();
      int weight = scan.nextInt();

      Coin c = new Coin(weight, value);
      coins[coinType] = c;
    }

    int[] memo = new int[totalCoinWeight + 1];
    for (int i = 0; i < memo.length; i++) {
      memo[i] = -1;
    }
    memo[0] = 0;

    int min = findMinValue(totalCoinWeight, coins, memo);

    if (min == Integer.MAX_VALUE) {
      System.out.println("This is impossible.");
    } else {
      System.out.println("The minimum amount of money is " + min + ".");
    }
  }

  private static int findMinValue(int totalWeight, Coin[] coins, int[] memo) {
    if (memo[totalWeight] != -1) {
      return memo[totalWeight];
    }

    int minVal = Integer.MAX_VALUE;
    for (Coin c : coins) {
      if (totalWeight >= c.weight) {
        int minWithoutThis = findMinValue(totalWeight - c.weight, coins, memo);
        if (minWithoutThis == Integer.MAX_VALUE) continue;
        minVal = Math.min(minVal, minWithoutThis + c.value);
      }
    }

    memo[totalWeight] = minVal;
    return memo[totalWeight];
  }
}
