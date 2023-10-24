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

// Convert string vector to int vector.
vector<int> strToInt(vector<string> strVec) {
    vector<int> res;
    for (auto &s : strVec) {
        res.push_back(stoi(s));
    }
    return res;
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