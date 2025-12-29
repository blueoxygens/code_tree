import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int max = 0;
        for(int i = 0; i<n; i++){
            HashSet<Integer> set = new HashSet<Integer>();
            int count = 1;
            set.add(segments[i][0]);
            set.add(segments[i][1]);
            for(int j=i+1; j<n; j++){
                if(!set.contains(segments[j][0]) && !set.contains(segments[j][1])){
                    count += 1;
                    set.add(segments[j][0]);
                    set.add(segments[j][1]);
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}