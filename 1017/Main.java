import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int[] boxes = new int[7];
        int ans, s1, s2;
        while(true) {
            ans = 0;
            for (int i = 1; i <= 6; i++) boxes[i] = scan.nextInt();
            // 6を入れる(1個の箱に1個しか入らない)
            ans += boxes[6];
            // 5を入れる(1個の箱に1個しか入らない)
            ans += boxes[5];
            s1 = boxes[5] * 11; // 1の入る隙間
            // 4を入れる(1個の箱に1個しか入らない)
            ans += boxes[4];
            s2 = boxes[4] * 5; // 2の入る隙間
            // 3を入れる
            ans += (boxes[3] + 3) / 4;
            switch (boxes[3] % 4) {
                case 0: break;
                case 1: s2 += 5; s1 += 7; break;
                case 2: s2 += 3; s1 += 6; break;
                case 3: s2 += 1; s1 += 5; break;
            }
            // 2を入れる
            if (s2 < boxes[2]) {
                boxes[2] -= s2;
                ans += (boxes[2] + 8) / 9;
                s1 += (9 - boxes[2] % 9) % 9 * 4;
            } else {
                s1 += (s2 - boxes[2]) * 4;
            }
            // 1を入れる
            boxes[1] -= Math.min(s1, boxes[1]);
            ans += (boxes[1] + 35) / 36;

            if (ans == 0) break;
            System.out.println(ans);
        }
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}