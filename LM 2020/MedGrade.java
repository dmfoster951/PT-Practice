// Author: Daniel Foster
// Difficulty: Medium, but an easy one. Only rounding could stump.
// Needed: Rounding

import java.util.*;

public class Grade {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = Integer.parseInt(scan.nextLine());
        while (cases-- > 0) {
            // Number of students and correct answers.
            int s = scan.nextInt();
            String cor = scan.next();

            // Read each student.
            for (int x = 0; x < s; x++) {
                // Name and list of answers.
                String name = scan.next();
                String ans = scan.next();

                // Count correct answers by comparing real to correct.
                double numCorrect = 0;                
                for (int i = 0; i < cor.length(); i++) {
                    if (cor.charAt(i) == ans.charAt(i))
                        numCorrect++;
                }

                // Percentage grade.
                double grade = (numCorrect / cor.length()) * 100;

                // Determine letter grade.
                char letter;
                if (grade >= 90) letter = 'A';
                else if (grade >= 80) letter = 'B';
                else if (grade >= 70) letter = 'C';
                else if (grade >= 60) letter = 'D';
                else letter = 'F';
                
                // Rounding option 1.
                // import java.text.DecimalFormat;
                // import java.math.RoundingMode;
                // DecimalFormat decFor = new DecimalFormat("#.0");
                // decFor.setRoundingMode(RoundingMode.HALF_UP);
                // System.out.println(name + " " + decFor.format(grade) + "% " + letter);
                
                // Rounding option 2. Preferred, obviously.
                System.out.printf("%s %.1f%% %c\n", name, grade, letter);
            }
        }
        scan.close();
    }
}
