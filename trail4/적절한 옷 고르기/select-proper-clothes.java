import java.util.*;

public class Main {
    static int n, m;
    static int[][] data;   // [i] = {start, end, beauty}
    static int[][] memo;   // [day][clothes]

    static void dp() {
        for (int[] row : memo) Arrays.fill(row, Integer.MIN_VALUE);

        // 첫날
        for (int i = 0; i < n; i++) {
            if (data[i][0] <= 1 && 1 <= data[i][1]) {
                memo[1][i] = 0;
            }
        }

        for (int day = 2; day <= m; day++) {
            for (int i = 0; i < n; i++) {
                if (data[i][0] > day || data[i][1] < day) continue;
                for (int j = 0; j < n; j++) {
                    if (memo[day - 1][j] == Integer.MIN_VALUE) continue;
                    memo[day][i] = Math.max(
                        memo[day][i],
                        memo[day - 1][j] + Math.abs(data[i][2] - data[j][2])
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        data = new int[n][];
        for (int i = 0; i < n; i++) {
            data[i] = Arrays.stream(sc.nextLine().trim().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }

        memo = new int[m + 1][n];
        dp();

        System.out.println(Arrays.stream(memo[m]).max().getAsInt());
    }
}