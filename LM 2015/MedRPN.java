// Author: Daniel Foster
// Difficulty: Hard - 
// Needed: 

import java.util.*;

public class MedRPN {
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);

        // Give priority values for each operator for later.
        Map<Character, Integer> prio = new HashMap<>(Map.of(
            '+', 0, '-', 0,
            '*', 1, '/', 1,
            '^', 2, '(', 3, ')', 3
        ));

        // Number of products instead of test cases..
        int cases = scan.nextInt();
        while (cases-- > 0) {
            //Number of lines to read.
            int n = scan.nextInt();
            scan.nextLine(); // Buffer.

            // Read n lines.
            while (n-- > 0) {
                // Turn input line into char array.
                char [] in = scan.nextLine().replaceAll(" ", "").toCharArray();

                // Operator stack.
                Stack<Character> ops = new Stack<>();
                
                // Postfix Line.
                StringBuilder res = new StringBuilder();

                for (char c : in) {
                    // If it's an operator.
                    if ("()^*/+-".indexOf(c) != -1) {
                        
                        if (c == ')') {
                            while(ops.peek() != '(') {
                                res.append(" " + ops.pop());
                            }
                            ops.pop();
                            continue;
                        }

                        // Keep popping into result until c is highest-priority operator in stack.
                        while (!ops.empty() && prio.get(ops.peek()) >= prio.get(c) && ops.peek() != '(') {
                            if (c == '^' && ops.peek() == '^') break;
                            res.append(" " + ops.pop());
                        }

                        // Push operator on stack, now highest priority.
                        ops.push(c);
                        //System.out.println(ops);

                        // Next character.
                        continue; 
                    }

                    // Otherwise add operand to postfix notation.
                    res.append(" " + c);
                }

                while (!ops.empty()) res.append(" " + ops.pop());

                System.out.println(res.deleteCharAt(0));
            }
        }
    }
}
