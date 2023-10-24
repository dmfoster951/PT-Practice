using namespace std;
#include <bits/stdc++.h>

int main() {
    int cases, size;

    // Test cases.
    cin >> cases;
    while (cases-- > 0) {
        // size is positive, always at least 1.
        string row = "#";
        cin >> size;

        // Append pound signs and print.
        for (int i = 1; i < size; i++) row += " #";
        for (int i = 0; i < size; i++) cout << row << endl;
    }

    return 0;
}