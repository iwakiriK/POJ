import java.util.*;
public class Main {

    class List implements Comparable<List>{
        int start;
        int end;
        int effi;
        public List(int start, int end, int effi) {
            this.start = start;
            this.end = end;
            this.effi = effi;
        }
        public int compareTo(List that) {
            return (this.start - that.start);
        }
        
    }
    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // hour
        int m = scan.nextInt(); // num of list
        int r = scan.nextInt(); // rest
        List[] lists = new List[m];
        for (int i = 0; i < m; i++) {
            lists[i] = new List(scan.nextInt(), scan.nextInt() + r, scan.nextInt());
        }
        Arrays.sort(lists);
        int[] dp = new int[m+1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            dp[i] = lists[i].effi;
            for (int j = 0; j < i; j++) {
                if (lists[j].end <= lists[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + lists[i].effi);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
