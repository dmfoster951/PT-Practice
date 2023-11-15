// Author: Daniel Foster
// Difficulty: Very easy, anyone could do it.
// Needed: Input, output.

import java.util.Scanner;

public class sequel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while (cases-- > 0) {
            String title = scan.next();
            System.out.println(title + " 2: Return of The " + title + "!");
        }
        scan.close();
    }
}
