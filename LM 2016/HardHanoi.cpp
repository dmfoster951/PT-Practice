// Author: Daniel Foster
// Diff: Hard - very hard without already knowing the algorithm.
// Needed: Recursion (though iterative solution exists), algorithmic problem solving.

using namespace std;
#include <bits/stdc++.h>

// Return string input of a line.
string strline() {
    string t;
    getline(cin, t);
    return t;
}

// Get int input of a line with 1 number.
int intline() {
    return stoi(strline());
}

// Recursive solution.
// hanoi(3, 'A', 'C', 'B')
void hanoi(int n, char start, char end, char help) {
    if (n == 0) return;

    // Move everything but bottom to B.
    hanoi(n - 1, start, help, end);

    // Move bottom to C.
    cout << start << "->" << end << endl;

    // Move everthing to C on top.
    hanoi(n - 1, help, end, start);
}

int main() {
    // Test cases.
    int cases = intline();
    while (cases-- > 0) {
        // Number of disks.
        int n = intline();
        cout << n << endl;
        hanoi(n, 'A', 'C', 'B');
    }
}
