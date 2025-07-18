import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            starts[i] = Math.min(a, b); // 항상 작은 값이 시작
            ends[i] = Math.max(a, b);   // 큰 값이 끝
        }

        int minPoint = Arrays.stream(starts).min().getAsInt();
        int maxPoint = Arrays.stream(ends).max().getAsInt();
        int maxOverlap = 0;

        for (int i = minPoint; i <= maxPoint; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (starts[j] <= i && i <= ends[j]) {
                    count++;
                }
            }
            maxOverlap = Math.max(maxOverlap, count);
        }

        System.out.println(maxOverlap);
    }
}
