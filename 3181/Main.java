import java.util.*;
import java.math.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // property      (1 <= n <= 1000)
        int k = scan.nextInt(); // maximum price (1 <= k <=  100)
        BigInteger[] dp = new BigInteger[n+1];
        dp[0] = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            dp[i] = new BigInteger("0");
        }
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = dp[j].add(dp[j - i]);
            }
        }
        System.out.println(dp[n]);

    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
