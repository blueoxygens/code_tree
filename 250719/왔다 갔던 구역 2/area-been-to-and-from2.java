import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] field = new int[200];
        int pivot = 99;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);

            if (dir == 'R') {
                for (int j = pivot; j < pivot + x; j++) {
                    field[j]++;
                }
                pivot += x;
            } else {
                for (int j = pivot - 1; j >= pivot - x; j--) {
                    field[j]++;
                }
                pivot -= x;
            }
        }

        int ans = 0;
        for (int i = 0; i < 200; i++) {
            if (field[i] >= 2) {
                int len = 0;
                int temp = i;
                while (temp < 200 && field[temp] >= 2) {
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
