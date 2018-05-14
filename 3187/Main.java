import java.util.*;
public class Main {
    final int MAX_N = 10;
    int n, sum;
    int[] num = new int[MAX_N];
    int[][] pascal = new int[MAX_N][MAX_N];
    boolean[] used = new boolean[MAX_N+1];
    boolean isFinished = false;
    void run() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        sum = scan.nextInt();
        permutation(0);
        for (int i = 0; i < n; i++) {
            if (i != 0) System.out.print(" ");
            System.out.print(num[i]);
        }
        System.out.println();
    }

    // 蟻本40ページ
    void permutation(int pos) {
        if (pos == n) {
            for (int i = 0; i < n; i++) pascal[0][i] = num[i]; // 三角形の一番上
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j + 1]; // 下の段を求める
                }
            }
            if (pascal[n-1][0] == sum) {
                isFinished = true;
            }
            return;
        }
        // 1~9をnumに入れる
        for (int i = 1; i <= n; i++) {
            if (isFinished) break;
            if (!used[i]) {
                num[pos] = i;
                used[i] = true;
                permutation(pos + 1);
                used[i] = false;
            }
        }
    }
    public static void main(String args[]) {
        new Main().run();
    }
}