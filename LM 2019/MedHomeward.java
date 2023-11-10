// Author: Daniel Foster
// Difficulty: Medium - standard use of hashmaps.
// Needed: Hashmaps.

import java.util.*;

public class MedHomeward {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Maps arrival city to departure city.
            Map<String, String> trips = new HashMap<>();

            // Number of boarding passes.
            int x = scan.nextInt();
            while (x-- > 0) {
                // Map new arrival to new departure.
                String dep = scan.next(), arr = scan.next();
                trips.put(arr, dep);
            }

            // Find final destination.
            String last = "";
            for (String s : trips.keySet()) {
                if (!trips.containsValue(s)) {
                    last = s;
                    break;
                }
            }

            // Loop back through the passes until original is reached.
            System.out.println(last);
            while (trips.containsKey(last)) {
                last = trips.get(last);
                System.out.println(last);
            }
        }
    }
}
