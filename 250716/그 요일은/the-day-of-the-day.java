import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        sc.close();

        String[] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] daysInMonth = {31,29,31,30,31,30,31,31,30,31,30,31};

        // 기준일 (m1, d1)의 요일을 A라고 할 때, (m1, d1)부터 (m2, d2)까지 며칠 차이인지 계산
        int totalDays = getDayDifference(m1, d1, m2, d2, daysInMonth);
        
        // A 요일의 인덱스
        int startIndex = -1;
        for (int i = 0; i < 7; i++) {
            if (week[i].equals(A)) {
                startIndex = i;
                break;
            }
        }

        // 특정 요일이 등장하는 횟수 세기
        int count = 0;
        for (int i = 0; i <= totalDays; i++) {
            int currentDay = (startIndex + i) % 7;
            if (currentDay == 0) count++;  // 0은 A 요일
        }

        System.out.println(count);
    }

    // 두 날짜 사이의 일수 계산 함수 (m1, d1)부터 (m2, d2)까지
    private static int getDayDifference(int m1, int d1, int m2, int d2, int[] daysInMonth) {
        int total = 0;
        if (m1 == m2) {
            return d2 - d1;
        }
        total += daysInMonth[m1 - 1] - d1;  // 첫 달 남은 일수
        for (int m = m1; m < m2 - 1; m++) {
            total += daysInMonth[m];
        }
        total += d2;  // 마지막 달의 날짜
        return total;
    }
}
