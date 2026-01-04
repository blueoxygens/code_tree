import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        final int MOD = (int)1e4 + 7;

        int[] dp = new int[n + 1];
        int[] nums = {1, 2, 5};

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] = (dp[i] + dp[i - num]) % MOD;
                }
            }
        }

        System.out.println(dp[n]);
        scanner.close();
    }
}