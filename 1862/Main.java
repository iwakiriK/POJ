import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        double[] stripies = new double[n];
        for (int i = 0; i < n; i++) {
            stripies[i] = scan.nextInt();
        }
        Arrays.sort(stripies);
        // 大きい順にぶつける
        for (int i = n-1; i > 0; i--) {
            stripies[i-1] = 2 * Math.sqrt(stripies[i] * stripies[i-1]);
        }
        System.out.printf("%.3f\n", stripies[0]);
    }
    
    public static void main(String args[]) {        
        new Main().run();        
    }
}