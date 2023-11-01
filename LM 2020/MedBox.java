// Author: Daniel Foster
// Difficulty: Medium - logic and small mistakes can be annoying to track.
// Needed: Strings

import java.util.Scanner;

public class MedBox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Width and height.
            int w = scan.nextInt(), h = scan.nextInt();

            // Buffer, then read text.
            scan.nextLine();
            String text = scan.nextLine();

            // Split into words and try to fit in box.
            String [] words = text.split(" ");

            // StringBuilder is just a special String object
            //  that is more efficient to modify.
            StringBuilder refit = new StringBuilder();

            // cur tracks how many words we've fit in total.
            // For loop will stop once height limit is hit.
            int cur = 0;
            for (int i = 0; i < h; i++) {
                // Count size of current line.
                int count = 0;

                // If I can fit another word, then do it.
                // NOTE: For posterity: Thought to skip extra spaces at start of loop,
                // but it did not affect whether it was solved.
                while (cur < words.length && count + words[cur].length() <= w) {
                    // Add next word with space, and update line length;
                    refit.append(words[cur]);
                    refit.append(" ");
                    count += words[cur].length() + 1;
                    cur++;
                }

                // Remove extra space and add \n.
                refit.deleteCharAt(refit.length() - 1);
                refit.append("\n");
            }

            // Delete extra \n.
            refit.deleteCharAt(refit.length() - 1);

            // Result.
            if (cur < words.length) System.out.println("WILL NOT FIT");
            else System.out.println(refit);
        }
    }
}