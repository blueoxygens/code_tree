import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] dp = new int[m+1];

        for(int init : coin){
            int v = (int)Math.ceil(m/init);
            for(int i = 1; i<=v; i++)
                dp[init*i] = Math.max(dp[init*i],i);
        }
        for(int i = 0; i<m; i++){
            for(int j = i+1; j<m+1; j++){
                if(i+j < m+1){
                    dp[i+j] = Math.max(dp[i+j], dp[i]+dp[j]);
                }
            }
        }
        // Arrays.stream(dp).forEach(System.out::print);
        System.out.println(dp[m]==0?-1:dp[m]);
    }
}