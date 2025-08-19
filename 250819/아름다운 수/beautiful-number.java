import java.util.*;

public class Main {
    static int count;

    static void dfs(int sum, int n) {
        if (sum == n) {
            count++;
            return;
        }
        for (int step = 1; step <= 4; step++) {
            if (sum + step > n) break;     // 더 커지면 이후 step도 불가 → break
            dfs(sum + step, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        count = 0;
        dfs(0, n);                         // 0에서 시작!
        System.out.println(count);
    }
}
