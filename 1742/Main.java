import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            int m = scan.nextInt();
            if (n == 0 && m == 0) break;
            int[] a = new int[n];
            int[] c = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();
            for (int i = 0; i < n; i++) c[i] = scan.nextInt();
            // dp
            int[] dp = new int[m+1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= m; j++) {
                    if (dp[j] >= 0) {
                        dp[j] = c[i];
                    } else if (j >= a[i] && dp[j - a[i]] > 0) {
                        dp[j] = dp[j - a[i]] - 1;
                    }
                }
            }
            // output
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                if (dp[i] >= 0) ans++;
            }
            System.out.println(ans);

        }
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
