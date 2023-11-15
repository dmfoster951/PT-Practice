// Author: Daniel Foster
// Difficulty: Easy, just read the problem.
// Needed: Math, rounding.

import java.util.*;

public class shapeshifter {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        while (cases-- > 0) {
            int r = scan.nextInt();
            double area = Math.PI * r * r;
            double res = Math.sqrt(area);
            System.out.printf("%.9f\n", res);
        }
        scan.close();
    }
}