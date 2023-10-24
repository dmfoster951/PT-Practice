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
string strline() {
    string t;
    getline(cin, t);
    return t;
}

// Get int input of a line with 1 number.
int intline() {
    return stoi(strline());
}

// Returns lowercase version of string.
string lowerStr(string s) {
    string res = "";
    for (char l : s) res += tolower(l);
    return res;
}

int main() {    
    // Test cases.
    int cases = intline();
    while (cases-- > 0) {
        // Get encoded chunk.
        bitset<11> enc(strline());

        // Keep going until no more 1 bits in actual data.
        while (enc.to_string().find('1') < 8) {
            // Pad const P3 based on position of first 1 bit.
            string divStr = "1011";
            int start = enc.to_string().find('1');
            for (int i = 0; i < start; i++) divStr = '0' + divStr;
            while (divStr.length() < 11) divStr += '0';
            
            // Division by XOR operation.
            bitset<11> div(divStr);
            enc ^= div;
        }
        
        // If no remainder, then ok.
        if (enc.to_string().substr(8) == "000")
            cout << "ok" << endl;
        else
            cout << "corrupt" << endl;
    }
}