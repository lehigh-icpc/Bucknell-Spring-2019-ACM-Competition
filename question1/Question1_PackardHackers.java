// Read in an unknown amount of input and prints the input followed by the sum.
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static ArrayList<Integer> primes;
  public static int gSize;
  
    public static void main(String[] args) {
      initPrimes();
      int x;
      ArrayList<Integer> curr = new ArrayList<>();
      curr.add(1);
      ArrayList<Integer> bag = new ArrayList<>();
      Scanner s = new Scanner(System.in);
      x = s.nextInt();
      while(x != 0) {
        bag.clear();
        if(x % 2 == 0) {
         	for(int i = 2; i <= x; i++) {
            	bag.add(i);
            }
          	gSize = x;
            rec(curr, bag);
        }
        x = s.nextInt();
      }
    }
            
    public static void rec(ArrayList<Integer> curr, ArrayList<Integer> bag) {
      	for(int i = 0; i < bag.size(); i++) {
        	ArrayList<Integer> curr2 = clone(curr);
      		ArrayList<Integer> bag2 = clone(bag);
          	curr2.add(bag.get(i));
          	bag2.remove(bag2.indexOf(bag.get(i)));
          	if(isPrime(curr2.get(curr2.size()-1) + curr2.get(curr2.size()-2))) {
            	rec(curr2, bag2);
            }
        }
      	if(isPrime(curr.get(0) + curr.get(curr.size()-1)) && curr.size() == gSize) {
        	printAns(curr);
        }
    }
  
  	public static void printAns(ArrayList<Integer> ans) {
    	for(int i = 0; i < ans.size()-1; i++) {
        	System.out.print(ans.get(i) + " ");
        }
      	System.out.println(ans.get(ans.size()-1));
    }
  
  	public static ArrayList<Integer> clone(ArrayList<Integer> src) {
      ArrayList<Integer> clone = new ArrayList<>();
    	for(int i = 0; i < src.size(); i++) {
        	clone.add(src.get(i));
        }
      return clone;
    }
            
    public static boolean isPrime(int x) {
    	return primes.contains(x);
    }
            
    public static void initPrimes() {
    	primes = new ArrayList<>(11);
        primes.add(2);
      	primes.add(3);
      primes.add(5);
      primes.add(7);
      primes.add(11);
      primes.add(13);
      primes.add(17);
      primes.add(19);
      primes.add(23);
      primes.add(29);
      primes.add(31);
    }
}