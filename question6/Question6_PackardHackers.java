// Read in an unknown amount of input and prints the input followed by the sum.
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      String line = s.nextLine();
      Scanner d = new Scanner(line);
      int numTeams = d.nextInt();
      while(numTeams != 0) {
      	int numLucky = d.nextInt();
        ArrayList<Integer> spots = new ArrayList<>(numTeams);
        for(int i = 0; i < numTeams; i++) {
        	spots.add(i+1);
        }
        for(int i = 0; i < 20; i++) {
          if(spots.size() == numLucky) {
          	break;
          }
          int gone = d.nextInt();
          int gone2 = gone;
          int cnt = 0;
          while(gone2 <= (spots.size()+cnt)) {
          	spots.remove(gone2-1 - cnt);
            cnt += 1;
            gone2 += gone;
            if(spots.size() == numLucky) {
          		break;
          	}
          }
        }
        for(int i = 0; i < spots.size()-1; i++) {
        	System.out.print(spots.get(i) + " ");
        }
        System.out.println(spots.get(spots.size()-1));
       	line = s.nextLine();
        d = new Scanner(line);
        numTeams= d.nextInt();
      }
   }
}
