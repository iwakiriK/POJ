import java.util.*;
public class Main {

    class Cow implements Comparable<Cow>{
        int start; // 開始時間
        int end;   // 終了時間
        int id;    // 番号
        public Cow(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }
        public int compareTo(Cow that) {
            if (this.start == that.start) {
                return this.end - that.end;
            } else {
                return this.start - that.start;
            }
        }
    }

    void run() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Cow[] cows = new Cow[n];
        for (int i = 0; i < n; i++) {
            cows[i] = new Cow(scan.nextInt(), scan.nextInt(), i);
        }
        Arrays.sort(cows);
        PriorityQueue<Cow> pq = new PriorityQueue<Cow>(n, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                if (a.end == b.end) {
                    return a.start - b.start;
                } else {
                    return a.end - b.end;
                }
            }
        });
        int ans = 0;
        int[] ids = new int[n];
        for (Cow cow : cows) {
            if ((!pq.isEmpty()) && pq.peek().end < cow.start) {
                ids[cow.id] = ids[pq.poll().id]; // stall追加なし
            } else {
                ids[cow.id] = (++ans); // stall追加あり
            }
            pq.offer(cow);
        }
        System.out.println(ans);
        for (int i = 0; i < n; i++) {
            System.out.println(ids[i]);
        }
    }

    public static void main(String args[]) {
        new Main().run();
    }
}