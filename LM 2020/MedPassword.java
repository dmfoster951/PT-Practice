// Author: Daniel Foster
// Difficulty: Medium - easy if you know regex.
// Needed: Strings, regex (though simpler in Java than initially thought)

import java.util.*;

public class MedPassword {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int test = scan.nextInt();
        while (test-- > 0) {
            // Read password.
            String pass = scan.next();

            // Check length.
            if (pass.length() < 8) {
                System.out.println("INVALID");
                continue;
            }

            // If there are any >= 3 repeats, then invalid.
            boolean thrice = false;
            for (int i = 0; i < pass.length() - 2; i++) {
                String three = "" + pass.charAt(i) + pass.charAt(i) + pass.charAt(i);
                if (pass.contains(three)) {
                    thrice = true;
                    break;
                }
            }

            if (thrice) {
                System.out.println("INVALID");
                continue;
            }

            // Count char group matches.
            int groups = 0;
            if (pass.matches(".*[A-Z].*"))
                groups++;
            if (pass.matches(".*[a-z].*"))
                groups++;
            if (pass.matches(".*[0-9].*"))
                groups++;
            if (pass.matches(".*[^A-Za-z0-9].*"))
                groups++;

            // Does it match at least 3 groups?
            if (groups >= 3)
                System.out.println("VALID");
            else
                System.out.println("INVALID");
        }
    }
}
