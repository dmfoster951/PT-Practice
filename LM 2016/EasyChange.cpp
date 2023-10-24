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
    int c = intLine();
    while (c-- > 0) {
        string line = strLine();
        cout << line << endl;

        vector<int> parts = strToInt(split(line.substr(1), "."));
        int price = parts[1] + (parts[0] * 100);

        // I have NO idea why this below solution doesn't work.
        //int price = (int)(stod(line.substr(1)) * 100);
        //cout << (stod(pStr.substr(1)) * 100) << endl;

        int q = price / 25;
        price %= 25;
        int d = price / 10;
        price %= 10;
        int n = price / 5;
        price %= 5;

        cout << "Quarters=" << q << endl;
        cout << "Dimes=" << d << endl;
        cout << "Nickels=" << n << endl;
        cout << "Pennies=" << price << endl;
    }
}
