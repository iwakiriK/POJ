import java.util.*;
public class Main {
    final int LEN = 5;
    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    int[][] dig = new int[LEN][LEN];
    Set<Integer> set = new HashSet<Integer>();

    void run() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < LEN; i++) {
            for (int j = 0; j < LEN; j++) {
                dig[i][j] = scan.nextInt();
            }
        }
        for (int y = 0; y < LEN; y++) {
            for (int x = 0; x < LEN; x++) {
                dfs(y, x, dig[y][x], 0);
            }
        }
        System.out.println(set.size());
    }
    void dfs(int y, int x, int num, int count) {
        if (count >= 5) {
            set.add(num);
            return;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= LEN || ny >= LEN) continue;
            dfs(ny, nx, num*10+dig[ny][nx], count+1);
        }
    }
    public static void main(String args[]) {
        new Main().run();
    }
}