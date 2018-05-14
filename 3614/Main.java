import java.util.*;
public class Main {
    class Cow implements Comparable<Cow> {
        int minspf;
        int maxspf;
        public Cow(int a, int b) {
            this.minspf = a;
            this.maxspf = b;
        }
        public int compareTo(Cow that) {
            return this.minspf - that.minspf;
        }
    }
    class Lotion implements Comparable<Lotion> {
        int spf;
        int cover;
        public Lotion(int a, int b) {
            this.spf = a;
            this.cover = b;
        }
        public int compareTo(Lotion that) {
            return this.spf - that.spf;
        }
    }
    void run() {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt(); // num of cows
        int l = scan.nextInt(); // num of bottles
        Cow[] cows = new Cow[c];
        Lotion[] lotions = new Lotion[l];
        for (int i = 0; i < c; i++) {
            cows[i] = new Cow(scan.nextInt(), scan.nextInt());
        }
        for (int i = 0; i < l; i++) {
            lotions[i] = new Lotion(scan.nextInt(), scan.nextInt());
        }
        Arrays.sort(cows);    // asc of minspf
        Arrays.sort(lotions); // asc of spf
        PriorityQueue<Cow> pq = new PriorityQueue<Cow>(c, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.maxspf - b.maxspf;
            }
        });
        int ans = 0;
        int ci = 0; // index of cows
        int li = 0; // index of lotions
        while(li < l) {
            Lotion lo = lotions[li++];
            while (ci < c && cows[ci].minspf <= lo.spf) {
                pq.add(cows[ci++]);
            }
            while (lo.cover > 0 && !pq.isEmpty()) {
                Cow co = pq.poll();
                if (co.maxspf >= lo.spf) {
                    ans++;
                    lo.cover--;
                }
            }
        }
        System.out.println(ans);

    }
    
    public static void main(String args[]) {
        new Main().run();
    }
}
