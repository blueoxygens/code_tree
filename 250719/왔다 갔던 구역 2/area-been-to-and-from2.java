import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] field = new int[1000];
        int pivot = 500;

        int minUsed = pivot;
        int maxUsed = pivot;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'R') {
                for (int j = pivot; j < pivot + x; j++) {
                    field[j]++;
                }
                maxUsed = Math.max(maxUsed, pivot + x - 1);
                pivot += x;
            } else {
                for (int j = pivot - 1; j >= pivot - x; j--) {
                    field[j]++;
                }
                minUsed = Math.min(minUsed, pivot - x);
                pivot -= x;
            }
        }

        int ans = 0;
        for (int i = minUsed; i <= maxUsed; i++) {
            if (field[i] >= 2) {
                int len = 0;
                int temp = i;
                while (temp <= maxUsed && field[temp] >= 2) {
                    len++;
                    temp++;
                }
                ans += len;
                i = temp - 1;
            }
        }

        System.out.println(ans);
    }
}
