import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] scores = new int[10001];
        int maxPos = 0;

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char type = sc.next().charAt(0);
            scores[pos] = (type == 'G') ? 1 : 2;
            maxPos = Math.max(maxPos, pos);
        }

        int ans = 0;
        int currentSum = 0;
        
        for (int i = 1; i <= maxPos; i++) {
            currentSum += scores[i];
            
            if (i >= k+1) {
                currentSum -= scores[i - k - 1];
            }
            
            ans = Math.max(ans, currentSum);
        }

        System.out.println(ans);
    }
}