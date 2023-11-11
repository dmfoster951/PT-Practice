// Author: Daniel Foster
// Difficulty: Medium - simple if you know the structures.
// Needed: Sets, maps.

import java.util.*;

public class MedSupervisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Test cases.
        int cases = scan.nextInt();
        while (cases-- > 0) {
            // Number of managers.
            int m = scan.nextInt();
            scan.nextLine(); // Buffer.

            // Set of all employees, we don't want repeats and it sorts automatically.
            Set<String> emps = new TreeSet<>();

            // Maps employee to manager.
            Map<String, String> mans = new HashMap<>();

            // Read each manager and a list of their employees.
            while (m-- > 0) {
                // Manager name.
                String man = scan.nextLine();
                emps.add(man);

                // Number of employees.
                int n = scan.nextInt();
                scan.nextLine(); // Buffer.

                // Add each name to employee set, map name to its manager.
                while (n-- > 0) {
                    String emp = scan.nextLine();
                    mans.put(emp, man);
                    emps.add(emp);
                }
            }

            // Print each employee with hierarchy of managers.
            for (String emp : emps) {
                System.out.print(emp);

                // Keep going up ladder for this employee.
                while (mans.containsKey(emp)) {
                    emp = mans.get(emp);
                    System.out.print("/" + emp);
                }

                // Reset.
                System.out.println();
            }
        }
    }
}