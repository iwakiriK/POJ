import java.util.*;
public class Main {
    String str;
    int[] cost = new int[26];
    int[][] memo = new int[2001][2001];

    int solve(int a, int b) {
        if(memo[a][b] > 0) return memo[a][b];
        if(b - a <= 0) return 0;
        if(str.charAt(a) == str.charAt(b)) {
            return memo[a][b] = solve(a+1, b-1);
        }

        int num1 = solve(a+1, b) + cost[str.charAt(a)-'a'];
        int num2 = solve(a, b-1) + cost[str.charAt(b)-'a'];
        return memo[a][b] = Math.min(num1, num2);
        
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // num of char
        int m = scan.nextInt(); // length
        str = scan.next();

        char ch;
        int in, out;
        for (int i = 0; i < n; i++) {
            ch = scan.next().charAt(0);
            in = scan.nextInt(); out = scan.nextInt();
            cost[ch - 'a'] = Math.min(in, out);
        }
        System.out.println(solve(0, m-1));
    }
    public static void main(String args[]) {
        new Main().run();
    }
}
