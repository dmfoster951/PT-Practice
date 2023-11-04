// Author: Daniel Foster
// Difficulty: Medium - relatively very easy.
// Needed: ASCII

import java.util.*;

public class MedDot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Get word.
            String word = scan.next();

            // Count value for each character, based on problem.
            int res = 0;
            for (int i = 0; i < word.length(); i++)
                res += word.charAt(i) - 'a' + 1;

            // Result.
            System.out.println(res);
        }
    }
}
