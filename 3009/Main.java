import java.util.*;
public class Main {
    final int limit = 20;
    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    int w, h, ans;
    int[][] board = new int[limit][limit];
    void run() {
        Scanner scan = new Scanner(System.in);
        int sx = -1, sy = -1;
        while (true) {
            ans = 11;
            w = scan.nextInt();
            h = scan.nextInt();
            if (w == 0 && h == 0) break;
            for(int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 0.vacant, 1.block, 2.start, 3.goal
                    board[i][j] = scan.nextInt();
                    if (board[i][j] == 2) {
                        sx = j;
                        sy = i;
                    }
                }
            }
            dfs(sx, sy, 0);
            if (ans == 11) ans = -1;
            System.out.println(ans);
        }
   }
   void dfs(int x, int y, int dep) {
       if (dep >= ans) return;
       int nx, ny;
       for (int i = 0; i < 4; i++) {           
           nx = x + dx[i];
           ny = y + dy[i];
           if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
           if (board[ny][nx] == 1) continue;
           while(board[ny][nx] == 0 || board[ny][nx] == 2) {
               nx += dx[i];
               ny += dy[i];
               if (nx < 0 || ny < 0 || nx >= w || ny >= h) break;
           }
           if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
           if (board[ny][nx] == 3) {
               ans = Math.min(ans, dep + 1);
               break;
           }
           if (board[ny][nx] == 1) {
               board[ny][nx] = 0;
               dfs(nx - dx[i], ny - dy[i], dep + 1);
               board[ny][nx] = 1;
           }
       }
   }

    public static void main(String args[]) {
        new Main().run();
    }
}