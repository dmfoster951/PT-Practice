using namespace std;
#include <bits/stdc++.h>

int intline() {
    string res;
    getline(cin, res);
    return stoi(res);
}

string strline() {
    string res;
    getline(cin, res);
    return res;
}

vector<string> split(string line, string delim) {
    vector<string> res;
    while (line.find(delim) != string::npos) {
        res.push_back(line.substr(0, line.find(delim)));
        line = line.substr(line.find(delim) + delim.length());
    }
    res.push_back(line);
    return res;
}

vector<int> strToInt(vector<string> list) {
    vector<int> res;
    for (auto &x : list) res.push_back(stoi(x));
    return res;
}

vector<double> strToDoub(vector<string> list) {
    vector<double> res;
    for (auto &x : list) res.push_back(stod(x));
    return res;
}

int main()
{
    // Test cases.
    int cases = intline();
    while (cases-- > 0) {
        // Line.
        vector<double> line = strToDoub(split(strline(), " "));
        int z = (int)line[0];
        double lat = line[1], lon = line[2];
        
        // x
        double x1 = (lon + 180) / 360;
        double x2 = pow(2, z);
        int x = (int)abs(x1 * x2);

        // y
        double y1 = tan(lat * (M_PI / 180));
        double y2 = 1 / (cos(lat * (M_PI / 180)));
        double y3 = (1 - (log(y1 + y2) / M_PI)) * pow(2, z - 1);
        int y = (int)abs(y3);
        
        // Result.
        cout << "http://map.lmcodequestacademy.com/" << z << "/" << x << "/" << y << ".png" << endl;
    }

    return 0;
}
