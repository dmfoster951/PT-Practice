// Author: Daniel Foster
// Difficulty: Easy - need recursive or iterative solution for Fibonacci.
// Needed: Recursion.

import java.util.*;

public class EasyFibByte {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Get num and find out if it is in Fibonacci sequence.
            int num = scan.nextInt();
            System.out.println(isFib(0, 1, num));
        }
    }

    // Returns whether n is in the Fibonacci sequence.
    public static String isFib(int fib1, int fib2, int n) {
        if (n == fib1 || n == fib2) return "TRUE";

        else if (n > fib1 && n < fib2) return "FALSE";

        return isFib(fib2, fib1 + fib2, n);
    }
}