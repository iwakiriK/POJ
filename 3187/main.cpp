//#include <bits/stdc++.h>
#include <iostream>
#include <algorithm>
using namespace std;

int n, sum;
int num[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
int pascal[10][10];

int main() {
    cin >> n >> sum;
    do {
        for (int i = 0; i < n; i++) pascal[0][i] = num[i]; // 三角形の一番上
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j + 1]; // 下の段を求める
            }
        }
        if (pascal[n-1][0] == sum) {
            for (int i = 0; i < n; i++) {
                if (i) cout << " ";
                cout << num[i];
            }
            cout << endl;
            break;
        }
    } while(next_permutation(num, num + n));
    return 0;
}