// Author: Daniel Foster
// Diff: Medium - simple cipher.
// Needed: strings, ASCII, alphabetic ciphers.

using namespace std;
#include <bits/stdc++.h>

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
    string alpha = "abcdefghijklmnopqrstuvwxyz";

    int c = intLine();
    while (c-- > 0) {
        // Action and key.
        string act = strLine();
        string key = strLine();

        // Messages to encrypt/decrypt.
        int n = intLine();
        for (int i = 0; i < n; i++) {
            // Get message and lowercase version.
            string mes = strLine();
            string newMes = "";
            for (char ch : mes) {
                // For encryption.
                // If space, just add.
                if (ch == ' ') newMes += ch;
                else {
                    // Otherwise get substitute.
                    bool cap = ch >= 'A' && ch <= 'Z';
                    char newCh;

                    // Encrypt or decrypt direction?
                    if (act == "ENCRYPT") newCh = key[alpha.find(tolower(ch))];
                    else newCh = alpha[key.find(tolower(ch))];

                    // Retain casing in the same position.
                    if (cap) newMes += toupper(newCh);
                    else newMes += newCh;
                }
            }

            // Result.
            cout << newMes << endl;
        }
    }
}
