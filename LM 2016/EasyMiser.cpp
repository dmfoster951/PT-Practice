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
    int c = intLine();
    while (c-- > 0) {
        // Get line, extract double.
        string line = strLine();
        double bill = stod(line.substr(1));

        // Calculate tips.
        double tip1 = bill * .15;
        double tip2 = bill * .18;
        double tip3 = bill * .20;

        // Use printf when needing to format.
        cout << "Total of the bill: " << line << endl;
        printf("15\% = $%.2f\n", tip1);
        printf("18\% = $%.2f\n", tip2);
        printf("20\% = $%.2f\n", tip3);
    }
}