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
        vector<int> nums = strToInt(split(line, ", "));

        if (nums[0] >= nums[1] + nums[2] || nums[1] >= nums[0] + nums[2] || nums[2] >= nums[0] + nums[1])
            cout << "Not a Triangle"  << endl;
        else if (nums[0] == nums[1] && nums[1] == nums[2])
            cout << "Equilateral" << endl;
        else if (nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2])
            cout << "Scalene" << endl;
        else
            cout << "Isosceles" << endl;
    }

    return 0;
}