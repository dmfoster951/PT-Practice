// Author: Daniel Foster
// Diff: Medium - tedious to account for special sorting though.
// Needed: Splitting, custom sorting.

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

// Returns lowercase version of string.
string lowerStr(string s) {
    string res = "";
    for (char l : s) res += tolower(l);
    return res;
}

// Making struct so sorting is easier.
// I could do pair except sorting doesn't account for "The " or casing.
typedef struct song {
    string artist;
    string title;

    inline bool operator < (song other) {
        string a = artist, oa = other.artist;
        if (a.find("The ") == 0) a = a.substr(4);
        if (oa.find("The ") == 0) oa = oa.substr(4);

        if (lowerStr(a) == lowerStr(oa)) return lowerStr(title) < lowerStr(other.title);
        return lowerStr(a).compare(lowerStr(oa)) < 0;
    }
} song;

int main() {
    // Test cases.
    int c = intLine();
    while (c-- > 0) {
        // Add songs to vector.
        int n = intLine();
        vector<song> songs;
        for (int i = 0; i < n; i++) {
            vector<string> line = split(strLine(), " - ");
            songs.emplace_back(song{line[1], line[0]});
        }

        // Sort and print back out.
        sort(songs.begin(), songs.end());
        for (auto &s : songs) {
            cout << s.title << " - " << s.artist << endl;
        }
    }
}
