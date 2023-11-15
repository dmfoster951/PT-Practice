// Author: Daniel Foster
// Difficulty: Easy, just read the problem and sample cases carefully.
// Needed: Casting.

import java.util.*;
public class notes {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        while(cases-- > 0) {
            double chance = 100;
            int n = scan.nextInt();
            while (n-- > 0) 
                chance *= ((100 - scan.nextInt()) / 100.0);
            System.out.println((int)chance);
        }
        scan.close();
    }
}