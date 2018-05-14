import java.util.*;
public class Main {
    final int M = 1000000;
    void run() {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); // families
        int a = scan.nextInt(); // num
        int s = scan.nextInt(); // start
        int b = scan.nextInt(); // end
        int[] cnt = new int[t]; // num of ants
        int[][] dp = new int[t+1][b+1];
        for (int i = 0; i < a; i++) {
            cnt[scan.nextInt()-1]++;
        }
        // dp
        for (int i = 0; i <= t; i++) dp[i][0] = 1;
        for (int i = 0; i < t; i++) {
            for (int j = 1; j <= b; j++) {
                if (j - 1 - cnt[i] >= 0) {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j] - dp[i][j - 1 - cnt[i]] + M) % M;
                } else {
                    dp[i + 1][j] = (dp[i + 1][j - 1] + dp[i][j]) % M;
                }
            }
        }
        // output
        int ans = 0;
        for (int i = s; i <= b; i++) ans += dp[t][i];
        ans %= M;
        System.out.println(ans);
    }

    public static void main(String args[]) {
        new Main().run();
    }
}
