import java.util.*;
public class Main {
    
    class Coin implements Comparable<Coin>{
        int v; // 価値
        int b; // 枚数
        public Coin(int v, int b) {
            this.v = v;
            this.b = b;
        }
        public int compareTo(Coin that) {
            if (this.v == that.v) return (this.b - that.b);
            else return (this.v - that.v);
        }
    }
    boolean canGive(Coin[] coins, int c) {
        // 高い硬貨から順番に，お釣りが出ないように支払う
        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i].b == 0) continue;
            int spend = Math.min(coins[i].b, c / coins[i].v);
            coins[i].b -= spend;
            c -= spend * coins[i].v;
            if (c <= 0) return true;
        }
        // お釣りを少なく支払う
        for (int i = 0; i < coins.length; i++) {
            if (coins[i].b == 0) continue;
            coins[i].b--;
            c-= coins[i].v;
            break;
        }
        return (c <= 0);
    }
    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 硬貨の種類
        int c = scan.nextInt(); // 毎週払う最低限
        Coin[] coins = new Coin[n];
        for (int i = 0; i < n; i++) {
            coins[i] = new Coin(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(coins);
        long ans = 0;
        while(canGive(coins, c)) ans++;
        System.out.println(ans);
    }
    
    public static void main(String args[]) {        
        new Main().run();        
    }
}