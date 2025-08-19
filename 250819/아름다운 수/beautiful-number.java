import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static int count = 0; // 찾은 조합의 개수
    static ArrayList<Integer> combination = new ArrayList<>(); // 현재 조합을 저장하는 리스트

    /**
     * 재귀 호출을 통해 합계가 n이 되는 모든 조합을 찾습니다.
     * @param currentSum 현재까지의 합계
     * @param targetN 목표 값 (n)
     */
    static void findCombinations(int currentSum, int targetN) {
        // 1. 기저 조건: 합계가 n에 도달하면 유효한 조합을 찾은 것
        if (currentSum == targetN) {
            count++; // 조합 개수 증가
            // System.out.println(combination); // 찾은 조합을 보고 싶을 때 활성화
            return;
        }

        // 2. 가지치기: 합계가 n을 초과하면 더 이상 진행하지 않음
        if (currentSum > targetN) {
            return;
        }

        // 3. 재귀 호출: 1부터 n까지의 숫자를 하나씩 더해봄
        for (int i = 1; i <= targetN; i++) {
            // 현재 숫자를 더해도 목표를 초과하지 않으면 다음 단계로 재귀 호출
            if (currentSum + i <= targetN) {
                combination.add(i); // 현재 숫자 추가
                findCombinations(currentSum + i, targetN); // 재귀 호출
                combination.remove(combination.size() - 1); // 백트래킹: 마지막에 추가한 숫자 제거
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findCombinations(0, n);
        System.out.println(count);
    }
}