// Author: Daniel Foster
// Difficulty: Medium - solid medium, nothing unexpected.
// Needed: Strings, reversing.

import java.util.*;

public class MedHijack {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Length of stream.
            int lenStream = scan.nextInt();
            scan.nextLine(); // Buffer

            // Stream to check.
            String stream = scan.nextLine();

            // Stores each message.
            List<String> messages = new ArrayList<>();

            int index = 0;
            while (index < lenStream - 3) {
                // Get current 3-letter token and its reverse.
                String tok = stream.substring(index, index + 3);
                String tokRev = new StringBuilder(tok).reverse().toString();

                // Check if reverse occurs after original token.
                int revIndex = stream.indexOf(tokRev);
                if (revIndex > index + 3) {
                    // Get message between tokens.
                    StringBuilder sb = new StringBuilder(stream.substring(index + 3, revIndex));
                    
                    // Take out double escape characters.
                    for (int i = 0; i < sb.length(); i++) {
                        if (tok.indexOf(sb.charAt(i)) != -1)
                            sb.deleteCharAt(i);
                    }

                    // Add message to list and set index after the end of it.
                    messages.add(sb.toString());
                    index = revIndex + 3;
                } else {
                    index++;
                }
            }

            // Result.
            System.out.println(String.join("\n", messages));
        }

        scan.close();
    }
}