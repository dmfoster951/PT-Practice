// Author: Daniel Foster
// Diff: Easy - very simple once you make connection to sort the words.
// Needed: Strings, splitting, sorting.

using namespace std;
#include <bits/stdc++.h>

// Split string into string vector.
vector<string> split(string line, string delim) {
    vector<string> res;
    // Find next token, add to vector, and pull it out of the string.
    while (line.find(delim) != string::npos) {
        int delimPoint = line.find(delim);
        res.push_back(line.substr(0, delimPoint));
        line = line.substr(delimPoint + delim.size());
    }
    res.push_back(line);
    return res;
}

// Return string input of a line.
string strLine() {
    string t;
    getline(cin, t);
    return t;
}

// Get int input of a line with 1 number.
int intLine() {
    return stoi(strLine());
}

int main() {
    // Test cases.
    int c = intLine();
    while (c-- > 0) {
        // Split input into words.
        string line = strLine();
        cout << line << " = ";

        vector<string> words = split(line, "|");
        if (words[0] == words[1]) {
            // If already the same, can't be anagram.
            cout << "NOT AN ANAGRAM" << endl;
        } else {
            // Sort both by alpha. If equal when sorted, then anagram.
            for (auto &s : words) sort(s.begin(), s.end());
            if (words[0] == words[1]) cout << "ANAGRAM" << endl;
            else cout << "NOT AN ANAGRAM" << endl;
        }
    }
}
