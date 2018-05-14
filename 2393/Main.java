import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 週
        int s = scan.nextInt(); // 1週間保管するコスト
        int c, y, min = (1 << 30);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            c = scan.nextInt(); // 今週のコスト
            y = scan.nextInt(); // 今週送る数
            min = Math.min(min + s, c);
            ans += min * y;
        }
        System.out.println(ans);
    }
    public static void main(String args[]) {
        new Main().run();
    }
}