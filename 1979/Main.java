import java.util.*;
public class Main {
    int w, h, ans;
    final int limit = 20;
    char[][] room = new char[limit][];
    boolean[][] vis = new boolean[limit][limit];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    void run() {
        Scanner scan = new Scanner(System.in);
        int x = -1, y = -1;
        while (true) {
            w = scan.nextInt();
            h = scan.nextInt();
            if (w == 0 && h == 0) break;
            init();
            for (int i = 0; i < h; i++) {
                room[i] = scan.next().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (room[i][j] == '@') {
                        y = i;
                        x = j;
                    }
                }
            }
            dfs(x, y);
            System.out.println(ans);
        }
    }
    void dfs(int x, int y) {
        ans++;
        vis[y][x] = true;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
            if (room[ny][nx] == '#') continue;
            if (vis[ny][nx]) continue;
            dfs(nx, ny);
        }
    }
    void init() {
        ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                vis[i][j] = false;
            }
        }
    }

    public static void main(String args[]) {
        new Main().run();
    }
}