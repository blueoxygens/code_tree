import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    static int n; // 그리드 크기, 모든 메서드에서 접근 가능하도록 static으로 선언
    static List<int[]> onesCoordinates = new ArrayList<>(); // '1'이 있는 좌표들을 int 배열로 저장
    static int maxAffectedCells = 0; // 발견된 최대 영향을 받은 셀의 개수

    /**
     * 특정 셀이 유효한 범위 내에 있고 아직 영향을 받지 않았다면, 영향을 받은 것으로 표시합니다.
     * @param effected 영향을 기록하는 그리드
     * @param r 행 좌표
     * @param c 열 좌표
     * @return 셀이 새롭게 영향을 받았으면 true, 아니면 false
     */
    static boolean tryEffectCell(int[][] effected, int r, int c) {
        if (r >= 0 && r < n && c >= 0 && c < n) { // 그리드 경계 확인
            if (effected[r][c] == 0) { // 아직 영향을 받지 않은 셀이라면
                effected[r][c] = 1; // 영향을 받은 것으로 표시
                return true;
            }
        }
        return false;
    }

    /**
     * 주어진 위치에 특정 유형의 폭탄을 배치하고, 새롭게 영향을 받은 셀의 개수를 반환합니다.
     * 이 함수는 폭탄 배치 '선택' 단계를 캡슐화합니다.
     * @param effectedGrid 현재 영향을 기록하는 그리드
     * @param r 폭탄을 배치할 행 좌표
     * @param c 폭탄을 배치할 열 좌표
     * @param bombType 폭탄 유형 (0, 1, 2)
     * @return 새롭게 영향을 받은 셀의 개수
     */
    static int applyBomb(int[][] effectedGrid, int r, int c, int bombType) {
        int newlyAffected = 0;

        // 폭탄 유형 0: '+' 형태 (중앙, 위1, 위2, 아래1, 아래2)
        if (bombType == 0) {
            if (tryEffectCell(effectedGrid, r, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r + 1, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r + 2, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r - 1, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r - 2, c)) newlyAffected++;
        }
        // 폭탄 유형 1: 'X' 형태 (중앙, 상, 하, 좌, 우)
        else if (bombType == 1) {
            if (tryEffectCell(effectedGrid, r, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r + 1, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r - 1, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r, c + 1)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r, c - 1)) newlyAffected++;
        }
        // 폭탄 유형 2: 대각선 'X' 형태 (중앙, 네 방향 대각선)
        else if (bombType == 2) {
            if (tryEffectCell(effectedGrid, r, c)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r + 1, c + 1)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r + 1, c - 1)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r - 1, c + 1)) newlyAffected++;
            if (tryEffectCell(effectedGrid, r - 1, c - 1)) newlyAffected++;
        }
        return newlyAffected;
    }

    /**
     * 2D 배열을 깊은 복사합니다. 백트래킹에서 상태를 유지하기 위해 중요합니다.
     * @param original 원본 2D 배열
     * @return 깊은 복사된 2D 배열
     */
    static int[][] deepCopy(int[][] original) {
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            // System.arraycopy는 배열의 특정 부분을 다른 배열로 복사하는 효율적인 방법입니다.
            System.arraycopy(original[i], 0, copy[i], 0, n);
        }
        return copy;
    }

    /**
     * 백트래킹을 사용하여 모든 가능한 폭탄 배치 조합을 탐색합니다.
     * @param currentCoordIndex 현재 고려 중인 '1' 좌표의 인덱스
     * @param currentAffectedCount 현재까지 영향을 받은 총 셀의 개수
     * @param currentEffectedGrid 현재까지 폭탄 배치로 인해 영향을 받은 셀의 상태를 나타내는 그리드
     */
    static void backtrack(int currentCoordIndex, int currentAffectedCount, int[][] currentEffectedGrid) {
        // 기저 사례: 모든 '1' 좌표에 대해 폭탄 배치를 고려했으면
        if (currentCoordIndex == onesCoordinates.size()) {
            // 현재까지의 영향을 받은 셀의 개수가 최대값보다 크다면 갱신
            if (currentAffectedCount > maxAffectedCells) {
                maxAffectedCells = currentAffectedCount;
            }
            return;
        }

        // 현재 '1' 좌표를 가져옵니다.
        int[] coord = onesCoordinates.get(currentCoordIndex);
        int r = coord[0]; // 행
        int c = coord[1]; // 열

        // 3가지 폭탄 유형 (0, 1, 2) 각각에 대해 탐색
        for (int bombType = 0; bombType < 3; bombType++) {
            // 현재 영향을 받은 그리드의 상태를 깊은 복사하여 다음 경로 탐색에 사용
            int[][] nextEffectedGrid = deepCopy(currentEffectedGrid);

            // 현재 위치에 선택된 폭탄을 배치하고 새롭게 영향을 받은 셀의 개수를 계산
            int newlyAffected = applyBomb(nextEffectedGrid, r, c, bombType);

            // 다음 '1' 좌표로 이동하여 재귀 호출 (현재까지의 영향을 받은 셀 개수와 그리드 상태 업데이트)
            backtrack(currentCoordIndex + 1, currentAffectedCount + newlyAffected, nextEffectedGrid);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 그리드 크기 입력

        int[][] initialGrid = new int[n][n];

        // 그리드 입력 및 '1'의 좌표 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                initialGrid[i][j] = sc.nextInt();
                if (initialGrid[i][j] == 1) {
                    onesCoordinates.add(new int[]{i, j}); // '1'의 좌표를 리스트에 추가
                }
            }
        }

        // 초기 'effected' 그리드 생성 (모든 셀이 0으로 초기화됨)
        int[][] initialEffected = new int[n][n];

        // 백트래킹 프로세스 시작: 첫 번째 '1' 좌표부터, 초기 영향을 받은 셀 0개, 빈 effected 그리드로 시작
        backtrack(0, 0, initialEffected);

        // 최대 영향을 받은 셀의 개수 출력
        System.out.println(maxAffectedCells);
        sc.close(); // Scanner 리소스 해제
    }
}