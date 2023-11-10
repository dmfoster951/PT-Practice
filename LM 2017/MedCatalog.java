// Author: Daniel Foster
// Difficulty: Medium - just need to think about how to store it.
// Needed: HashMaps, sorting, recursion.

import java.util.*;

public class MedCatalog {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        // Maps category to list of products under it.
        Map<String, List<String>> hier = new HashMap<>();

        // Number of products instead of test cases..
        int cases = scan.nextInt();
        scan.nextLine(); // Buffer
        while (cases-- > 0) {
            // Get product and its parent category.
            String [] line = scan.nextLine().split(",");
            String product = line[0], parent = line[1];

            // Add parent and its product to hierarchy.
            if (!hier.containsKey(parent)) {
                hier.put(parent, new ArrayList<>(List.of(product)));
            } 
            
            // Or add product to existing list for parent.
            else {
                hier.get(parent).add(product);
                Collections.sort(hier.get(parent));
            }
        }
        
        // Result.
        printHierarchy(hier, "None", 0);
    }

    // Print hierarchy correctly.
    public static void printHierarchy(Map<String, List<String>> hier, String parent, int depth) {
        // Go through each product in current parent category.
        for (String p : hier.get(parent)) {
            // Print current product.
            System.out.println("-".repeat(depth) + p);

            // Recurse if this product is its own category in hierarchy.
            if (hier.containsKey(p))
                printHierarchy(hier, p, depth + 1);
        }
    }
}
