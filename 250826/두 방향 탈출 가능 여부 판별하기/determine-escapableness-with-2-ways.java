import java.util.Scanner;

public class Main {

    static boolean[][] visited;
    static int n, m;
    static int[][] grid;

    /**
     * @param i 현재 행 위치
     * @param j 현재 열 위치
     * @return (i, j)에서 목표 지점까지 도달 가능하면 1, 불가능하면 0을 반환
     */
    static int DFS(int i, int j) {
        // 1. 범위를 벗어난 경우
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        // 2. 벽(0)을 만났거나 이미 방문한 곳인 경우 
        if (grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        // 3. 목표 지점에 도달한 경우 (성공)
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // 현재 위치를 방문 처리
        visited[i][j] = true;

        // 아래쪽으로 탐색
        if (DFS(i + 1, j) == 1) {
            return 1;
        }

        // 오른쪽으로 탐색
        if (DFS(i, j + 1) == 1) {
            return 1;
        }

        // 두 방향 모두 길이 없는 경우
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int result = DFS(0, 0);
        System.out.println(result);
        
        sc.close();
    }
}