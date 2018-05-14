import java.util.*;
public class Main {
    class Pair {
        int x, y, count;
        Pair (int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    final int limit = 310; // メテオは300
    final int INF = 2000;
    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    int m, time = INF;
    int[][] meteo = new int[limit][limit];
    Queue<Pair> que = new ArrayDeque<Pair>();
    boolean[][] vis = new boolean[limit][limit];

    void run() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                meteo[i][j] = 2000; // 安全
            }
        }
        m = scan.nextInt();
        int x, y, t, nx, ny;
        for (int i = 0; i < m; i++) {
            x = scan.nextInt();
            y = scan.nextInt();
            t = scan.nextInt();
            meteo[y][x] = Math.min(meteo[y][x], t);
            // メテオ落ちた所の周りも壊す
            for (int j = 0; j < 4; j++) {
                nx = x + dx[j];
                ny = y + dy[j];
                if (nx < 0 || ny < 0) continue;
                meteo[ny][nx] = Math.min(meteo[ny][nx], t);
            }
        }
        bfs();
        System.out.println(time);
    }
    void bfs() {
        que.add(new Pair(0, 0, 0));
        vis[0][0] = true;
        while(!que.isEmpty()){
            Pair p = que.poll();
            if (meteo[p.y][p.x] == INF) {
                time = p.count;
                break;
            }
            // 4方向に移動
            p.count++;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0) continue;
                if (p.count >= meteo[ny][nx]) continue;
                if (vis[ny][nx]) continue;
                que.add(new Pair(nx, ny, p.count));
                vis[ny][nx] = true;
            }
        }
        if (time == INF) time = -1;
    }

    public static void main(String args[]) {
        new Main().run();
    }
}