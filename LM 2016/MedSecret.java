import java.util.*;

public class MedSecret {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        int cases = Integer.parseInt(scan.nextLine());
        while (cases-- > 0) {
            // Read message.
            int m = Integer.parseInt(scan.nextLine());
            String [] lines = new String[m];
            for (int i = 0; i < m; i++) lines[i] = scan.nextLine();

            // Starting row, column.
            String [] yx = scan.nextLine().split(",");
            int row = Integer.parseInt(yx[0]);
            int col = Integer.parseInt(yx[1]);

            // Read cover.
            int co = Integer.parseInt(scan.nextLine());
            String [] cov = new String[co];
            for (int i = 0; i < co; i++) cov[i] = scan.nextLine();

            // Find secret.
            String secret = "";
            for (int r = 0; r < cov.length; r++) {
                // While there are still Os in the line.
                while (cov[r].indexOf('O') != -1) {
                    // Uncover correct letter and remove O from the line.
                    secret += lines[row + r].charAt(col + cov[r].indexOf('O'));
                    cov[r] = cov[r].replaceFirst("O", "-");
                }
            }
            System.out.println(secret);
        }
        scan.close();
    }
}
