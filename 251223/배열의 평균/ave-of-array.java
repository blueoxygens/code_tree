import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[2][4];
        double totalSum = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = sc.nextInt();
                totalSum += arr[i][j];
            }
        }

        for (int i = 0; i < 2; i++) {
            double rowSum = 0;
            for (int j = 0; j < 4; j++) {
                rowSum += arr[i][j];
            }
            System.out.printf("%.1f ", rowSum / 4);
        }
        System.out.println();

        for (int j = 0; j < 4; j++) {
            double colSum = 0;
            for (int i = 0; i < 2; i++) {
                colSum += arr[i][j];
            }
            System.out.printf("%.1f ", colSum / 2);
        }
        System.out.println();

        System.out.printf("%.1f\n", totalSum / 8);

        sc.close();
    }
}