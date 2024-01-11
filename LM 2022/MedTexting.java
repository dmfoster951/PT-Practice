// Author: Daniel Foster
// Difficulty: Medium, easiest with use of Maps.
// Needed: Strings, HashMaps.

import java.util.*;

public class MedTexting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Map letters to appropriate number.
        Map<String, String> map = Map.of("abc", "2", "def", "3", "ghi", "4", "jkl", "5",
                "mno", "6","pqrs", "7", "tuv", "8", "wxyz", "9", " ", "0");
        HashMap<String, String> numpad = new HashMap<>(map);

        // Test cases.
        int cases = scan.nextInt();
        scan.nextLine(); // Buffer.

        while (cases-- > 0) {
            // Get line.
            char [] line = scan.nextLine().toCharArray();
            String [] res = new String[line.length];

            // Traverse line.
            for (int i = 0; i < res.length; i++) {
                char c = line[i];

                // Find right key in map.
                for (String key : numpad.keySet()) {
                    if (key.indexOf(c) != -1) {
                        // Add right amount of that #.
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < key.indexOf(c) + 1; j++)
                            sb.append(numpad.get(key));

                        // Put in result.
                        res[i] = sb.toString();
                        break;
                    }
                }
            }

            // Result.
            System.out.println(String.join("-", res));
        }
    }
}
