// Author: Daniel Foster
// Difficulty: Medium - easy if you stay on top of formula.
// Needed: Math functions, trig, radians->degrees.

import java.util.Scanner;

public class MedMars {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Coordinates of Earth and Mars.
            double xe = scan.nextDouble(), ye = scan.nextDouble();
            double xm = scan.nextDouble(), ym = scan.nextDouble();

            // Distances between sun, earth, and moon.
            double a = dist(0, 0, xe, ye);
            double b = dist(xe, ye, xm, ym);
            double c = dist(0, 0, xm, ym);

            // Find angle between earth and sun.
            double p1 = (Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / (2 * a * b);
            double t = Math.toDegrees(Math.acos(p1));

            // Result.
            if (t < 2) System.out.println("VACATION");
            else System.out.println("WORKING HARD");
        }
    }

    // Distance between 2 points.
    public static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
