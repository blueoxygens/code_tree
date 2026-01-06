import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        for(int i =0; i<n; i++)
            dp[i][i] = nums[i];
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                dp[i][j] = dp[i][j-1] + nums[j];
            }
        }

        int max = Arrays.stream(dp)
            .flatMapToInt(Arrays::stream)
            .max()
            .orElse(-1);

        // String result = Arrays.stream(dp)
        //     .map(row -> Arrays.stream(row)
        //                     .mapToObj(String::valueOf)
        //                     .collect(Collectors.joining(" ")))
        //     .collect(Collectors.joining("\n"));

        System.out.println(max);
    }
}