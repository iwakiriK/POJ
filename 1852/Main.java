import java.util.*;
public class Main {
    void run() {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num > 0) {            
            int l = scan.nextInt(), n = scan.nextInt();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = scan.nextInt();            
            }                
            int min = 0, max = 0;
            for (int i = 0; i < n; i++) {
                min = Math.max(min, Math.min(x[i], l - x[i]));
                max = Math.max(max, Math.max(x[i], l - x[i]));                
            }
            System.out.println(min + " " + max);
            num--;
        }
    }    
    
    public static void main(String args[]) {        
        new Main().run();        
    }
}