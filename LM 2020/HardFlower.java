// Author: Daniel Foster
// Difficulty: Hard - relatively simple if you know how to convert bases and manipulate strings.
// Needed: Base conversion, string manipulation.

import java.util.*;

public class HardFlower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Read number.
            int num = scan.nextInt();

            // Convert num to base9 and generate flowers.
            ArrayList<Integer> base9 = base9(num);
            StringBuilder [] lines = flowerLines(base9);

            // Print each line with trailing whitespace removed.
            for (StringBuilder sb : lines)
                System.out.println(sb.toString().stripTrailing());
        }
    }

    // Converts a number to base-9. Returns list of digits.
    public static ArrayList<Integer> base9(int num) {
        ArrayList<Integer> res = new ArrayList<>();
        while (num != 0) {
            res.add(0, num % 9);
            num /= 9;
        }
        return res;
    }

    // Returns array for flower patterns.
    public static StringBuilder [] flowerLines(ArrayList<Integer> nums) {
        // Make Strings to return.
        StringBuilder [] lines = new StringBuilder[3];
        for (int i = 0; i < lines.length; i++)
            lines[i] = new StringBuilder();

        // Go through each "digit".
        for (int n : nums) {
            // Make flower pattern based on value.
            switch (n) {
                case 0:
                    lines[0].append("   ");
                    lines[1].append(" * ");
                    lines[2].append("   ");
                    break;
                case 1:
                    lines[0].append("\\  ");
                    lines[1].append(" * ");
                    lines[2].append("   ");
                    break;
                case 2:
                    lines[0].append("\\| ");
                    lines[1].append(" * ");
                    lines[2].append("   ");
                    break;
                case 3:
                    lines[0].append("\\|/");
                    lines[1].append(" * ");
                    lines[2].append("   ");
                    break;
                case 4:
                    lines[0].append("\\|/");
                    lines[1].append(" *-");
                    lines[2].append("   ");
                    break;
                case 5:
                    lines[0].append("\\|/");
                    lines[1].append(" *-");
                    lines[2].append("  \\");
                    break;
                case 6:
                    lines[0].append("\\|/");
                    lines[1].append(" *-");
                    lines[2].append(" |\\");
                    break;
                case 7:
                    lines[0].append("\\|/");
                    lines[1].append(" *-");
                    lines[2].append("/|\\");
                    break;
                case 8:
                    lines[0].append("\\|/");
                    lines[1].append("-*-");
                    lines[2].append("/|\\");
                    break;
            }

            // Put space at the end.
            for (StringBuilder sb : lines)
                sb.append(" ");
        }

        return lines;
    }
}
