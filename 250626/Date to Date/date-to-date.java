import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30,
                              31, 31, 30, 31, 30, 31 };

        int result = 0;

        if (m1 == m2) {
            // 같은 달이면 단순히 날짜 차이 계산
            result = d2 - d1 + 1;
        } else {
            // 시작 달의 남은 날짜
            result += daysInMonth[m1] - d1 + 1;

            // 사이 달의 전체 날짜 합
            for (int m = m1 + 1; m < m2; m++) {
                result += daysInMonth[m];
            }

            // 마지막 달의 날짜
            result += d2;
        }

        System.out.println(result);
    }
}