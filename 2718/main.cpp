//#include <bits/stdc++.h>
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int ans;
int digits[10];

void solve(int cnt){
    do {
        int mid = cnt / 2;
        if (cnt > 3 && digits[0] == 0) continue; // 0から始まる値を避ける
        if (cnt > 2 && digits[cnt/2] == 0) continue; // 上と同様
        int a = 0, b = 0;
        for (int i = 0; i < mid; i++) a = a * 10 + digits[i];
        for (int i = mid; i < cnt; i++) b = b * 10 + digits[i];
        ans = min(ans, abs(a - b));
    } while(next_permutation(digits, digits + cnt));
}

int main() {
    int n;
    cin >> n;
    string str;
    getline(cin, str); // 今の行を終わらせる
    for (int i = 0; i < n; i++) {
        ans = (1 << 30);
        /* 各数値をdigitsに格納 */
        getline(cin, str); // 取りたい行
        int size = str.size() / 2 + 1; // 数値の数
        int idx = 0;
        for (int j = 0; j < size; j++) {
            digits[j] = str[idx] - '0';
            idx += 2;
        }
        /* 格納おしまい */
        solve(size);
        cout << ans << endl;
    }
    return 0;
}