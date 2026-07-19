import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        sc.nextLine();
        int[] input = Arrays.stream(sc.nextLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int left = 0;
        long sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += input[right];
            while (sum >= s) {
                ans = Math.min(ans, right - left + 1);
                sum -= input[left];
                left++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}