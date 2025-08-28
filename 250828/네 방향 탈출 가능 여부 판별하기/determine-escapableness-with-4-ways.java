import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {

    // 좌표를 저장할 간단한 내부 클래스 (String 처리보다 훨씬 효율적)
    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m]; // 2차원 배열로 visited 관리

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // 시작점이 벽이면 바로 0 출력 후 종료
        if (grid[0][0] == 0) {
            System.out.println(0);
            return;
        }

        ArrayDeque<Point> queue = new ArrayDeque<>();
        
        // 시작점 큐에 추가 및 방문 처리
        queue.addLast(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.pollFirst();
            int y = current.y;
            int x = current.x;

            // 목적지에 도달했는지 확인
            if (y == n - 1 && x == m - 1) {
                System.out.println(1);
                return; // 목적지 찾았으므로 즉시 종료
            }

            for (int i = 0; i < 4; i++) {
                int new_y = y + dy[i];
                int new_x = x + dx[i];

                // 1. 경계 조건 확인 (n과 m이 올바르게 수정됨)
                // 2. 갈 수 있는 길인지(== 1) 확인
                // 3. 아직 방문하지 않았는지 확인
                if (new_y >= 0 && new_y < n && new_x >= 0 && new_x < m &&
                    grid[new_y][new_x] == 1 && !visited[new_y][new_x]) {
                    
                    // ✨ 최적화: 큐에 추가할 때 바로 방문 처리
                    visited[new_y][new_x] = true;
                    queue.addLast(new Point(new_y, new_x));
                }
            }
        }

        // 큐가 비워질 때까지 목적지에 도달하지 못했다면 경로 없음
        System.out.println(0);
    }
}