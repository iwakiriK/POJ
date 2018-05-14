import java.util.*;
public class Main {
    final int MOD = 1000000000;
    void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            if(i % 2 == 0) dp[i] = dp[i/2];
            dp[i] += dp[i-1];
            dp[i] %= MOD;
        }
        System.out.println(dp[N]);
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}