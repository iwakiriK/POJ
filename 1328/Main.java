import java.util.*;
public class Main {

    class Island implements Comparable<Island>{
        int x;
        int y;
        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Island that) {
            if (this.x == that.x) return (this.y - that.y);
            else return (this.x - that.x);
        }
    }

    void solve(Island[] islands, int d) {
        double d2 = d * d;
        int count = 0;
        for (int i = 0; i < islands.length;) {
            Island isl = islands[i]; // 円の内側の左端の島
            if (isl.y > d) {
                count = -1;
                break;
            }
            double right = isl.x + Math.sqrt(d2 - Math.pow(isl.y, 2));
            while ((++i) < islands.length) {
                if (islands[i].y > d) break;
                double rx = Math.sqrt(d2 - Math.pow(islands[i].y, 2)); // これぐらい横に離れても大丈夫
                if (islands[i].x - rx > right) break;
                right = Math.min(right, islands[i].x + rx);
            }
            count++;
        }
        System.out.println(count);
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        int n, d;
        int cs = 1; // case番号
        while (true) {
            n = scan.nextInt(); // 島の数
            d = scan.nextInt(); // レーダーの範囲
            if (n + d == 0) break;
            Island[] islands = new Island[n];
            for (int i = 0; i < n; i++) {
                islands[i] = new Island(scan.nextInt(), scan.nextInt());
            }
            Arrays.sort(islands); // x少ない順
            System.out.print("Case " + cs + ": ");
            cs++;
            solve(islands, d);
        }
    }

    public static void main(String args[]) {
        new Main().run();
    }
}