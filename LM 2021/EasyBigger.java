// Author: Daniel Foster
// Difficulty: Easy - question of best way to do it in Java
//  depends on what you know. You could write algorithm yourself.
// Needed: Splitting, parsing, Array/List algorithms.

import java.util.*;

public class EasyBigger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        scan.nextLine(); // Buffer.
        while (cases-- > 0) {
            // Split line.
            String [] line = scan.nextLine().split(" ");

            // Get max.
            int max = Integer.MIN_VALUE;
            for (String s : line) {
                int num = Integer.parseInt(s);
                if (num > max) max = num;
            }

            // Result.
            System.out.println(max);
        }
    }
}
