import java.util.*;
public class Main {
    final int MOD = 1000000000;
    void run() {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); // times
        int W = scan.nextInt(); // num of moves
        int[] apples = new int[T];
        for (int i = 0; i < T; i++) {
            apples[i] = scan.nextInt() - 1;
        }

        int ans = -1, tmp;
        int[][][] dp = new int[T+1][W+2][2];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j <= W; j++) {
                if(apples[i] == 0) {
                    dp[i+1][j][0] = Math.max(dp[i+1][j][0], dp[i][j][0] + 1);
                    dp[i+1][j][1] = Math.max(dp[i+1][j][1], dp[i][j][1]);

                    dp[i+1][j+1][0]=Math.max(dp[i+1][j+1][0],dp[i][j][1] + 1);
                    dp[i+1][j+1][1]=Math.max(dp[i+1][j+1][1],dp[i][j][0]);
                    dp[i+1][j+1][0]=Math.max(dp[i+1][j+1][0],dp[i][j+1][0] + 1);
                    dp[i+1][j+1][1]=Math.max(dp[i+1][j+1][1],dp[i][j+1][1]);
                } else {
                    dp[i+1][j][0] = Math.max(dp[i+1][j][0], dp[i][j][0]);
                    dp[i+1][j][1] = Math.max(dp[i+1][j][1], dp[i][j][1] + 1);

                    dp[i+1][j+1][0]=Math.max(dp[i+1][j+1][0],dp[i][j][1]);
                    dp[i+1][j+1][1]=Math.max(dp[i+1][j+1][1],dp[i][j][0] + 1);
                    dp[i+1][j+1][0]=Math.max(dp[i+1][j+1][0],dp[i][j+1][0]);
                    dp[i+1][j+1][1]=Math.max(dp[i+1][j+1][1],dp[i][j+1][1] + 1);
                }
                tmp = Math.max(dp[i+1][j][0], dp[i+1][j][1]);
                ans = Math.max(ans, tmp);
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}