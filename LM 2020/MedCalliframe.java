// Author: Daniel Foster
// Difficulty: Medium - not difficult if you know String manipulation.
// Needed: String manipulation, regex (though not necessary).

import java.util.Scanner;

public class MedCalliframe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        scan.nextLine(); // Buffer.
        while (cases-- > 0) {
            // Read line.
            String line = scan.nextLine();

            // If it meets requirements, print the Calliframe.
            if (line.matches("[A-Za-z]+") && line.length() >= 5 && line.length() <= 32) {
                printCall(line);
            } else {
                System.out.println("Not a Calliframe");
            }
        }
    }

    public static void printCall(String line) {
        // Original line.
        System.out.println(line);

        // Count spaces.
        StringBuilder sp = new StringBuilder();
        while (sp.length() < line.length() - 2) sp.append(' ');

        // For each row: left column, spaces, then right column.
        for (int i = 1; i < line.length() - 1; i++) {
            System.out.print(line.charAt(i));
            System.out.print(sp);
            System.out.println(line.charAt(line.length() - i - 1));
        }

        // Reverse line.
        StringBuilder temp = new StringBuilder(line);
        System.out.println(temp.reverse());
    }
}
