using namespace std;
#include <bits/stdc++.h>

// Read one int on line input.
int intline() {
    string res;
    getline(cin, res);
    return stoi(res);
}

// Return line input.
string strline() {
    string res;
    getline(cin, res);
    return res;
}

// Return split string.
vector<string> split(string line, string delim) {
    vector<string> res;
    while (line.find(delim) != string::npos) {
        res.push_back(line.substr(0, line.find(delim)));
        line = line.substr(line.find(delim) + delim.length());
    }
    res.push_back(line);
    return res;
}

// Return int version of string vector.
vector<int> strToInt(vector<string> list) {
    vector<int> res;
    for (auto &x : list) res.push_back(stoi(x));
    return res;
}

int main()
{
    // Test cases.
    int cases = intline();
    while (cases-- > 0) {
        // Read message.
        int m = intline();
        vector<string> lines(m);
        for (auto &x : lines) x = strline();
        
        // Starting row, column.
        vector<int> yx = strToInt(split(strline(), ","));
        int y = yx[0], x = yx[1];
        
        // Read cover.
        int c = intline();
        vector<string> cov(c);
        for (auto &x : cov) x = strline();
        
        // Find secret.
        string sec = "";
        for (int r = 0; r < cov.size(); r++) {
            while (cov[r].find('O') != string::npos) {
                int pos = cov[r].find('O');
                sec += lines[y + r][x + pos];
                cov[r][pos] = '-';
            }
        }
        
        // Result.
        cout << sec << endl;
    }

    return 0;
}
