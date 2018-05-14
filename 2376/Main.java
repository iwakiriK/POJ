import java.util.*;
public class Main {
    Scanner scan = new Scanner(System.in);
    class Cow implements Comparable<Cow>{
        int start; // 開始時間
        int end;   // 終了時間
        public Cow(int a, int b) {
            this.start = a;
            this.end = b;
        }
        public int compareTo(Cow that) {
            if (this.start == that.start) {
                return that.end - this.end;
            } else {
                return this.start - that.start;
            }
        }
    }
    void run() {
        int n = scan.nextInt(); // 牛の数  (1 <= n <= 25,000)
        int t = scan.nextInt(); // 終了時間(1 <= t <= 1,000,000)
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            cows[i] = new Cow(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(cows);
        boolean isFound;
        int start = 1, end = 0, ans = 0, i = 0;
        while(true) {
            isFound = false;
            for (;i < n && cows[i].start <= start; i++) {
                end = Math.max(end, cows[i].end);
                isFound = true;
            }
            ans++;
            start = end + 1;
            if (end >= t) break;
            if (i == n || !isFound){
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
