import java.util.*;
public class Main {
    class Cow implements Comparable<Cow> {
        int t; // そこまで行く時間
        int d; // 1分で破壊する数
        Cow(int t, int d) {
            this.t = t;
            this.d = d;
        }
        public int compareTo(Cow that) {
            long res = this.t * that.d - this.d * that.t;
            if (res > 0) return 1;
            else if (res < 0) return -1;
            else return 0;
        }
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 牛の数
        Cow[] cows = new Cow[n];
        int sum = 0; // 破壊量の合計
        long ans = 0;
        for (int i = 0; i < n; i++) {
            cows[i] = new Cow(scan.nextInt(), scan.nextInt());
            sum += cows[i].d;
        }
        Arrays.sort(cows);
        for (int i = 0; i < n; i++) {
            sum -= cows[i].d;
            ans += sum * cows[i].t * 2;
        }
        System.out.println(ans);
    }
    
    public static void main(String args[]) {        
        new Main().run();        
    }
}