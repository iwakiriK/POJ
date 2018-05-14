import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[][] triangle = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = scan.nextInt();
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }
        System.out.println(triangle[0][0]);
    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
