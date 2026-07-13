import java.util.Scanner;

public class Main {

    static int n;

    // 상, 하, 좌, 우
    static int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    // (r, c)를 중심으로 폭탄을 터뜨린 결과 격자를 반환 (원본은 건드리지 않음)
    static int[][] bomb(int r, int c, int[][] original) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = original[i].clone();
        }

        int k = original[r][c];
        map[r][c] = 0; // 자기 자신은 항상 터짐

        for (int d = 0; d < 4; d++) {
            for (int dist = 1; dist <= k - 1; dist++) {
                int nr = r + dirs[d][0] * dist;
                int nc = c + dirs[d][1] * dist;

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    break; // 격자를 벗어나면 그 방향은 더 이상 진행하지 않음
                }
                map[nr][nc] = 0;
            }
        }

        return map;
    }

    // 각 열마다 중력 적용 (0이 아닌 값들이 아래로 쌓임, 순서 유지)
    static int[][] gravity(int[][] map) {
        int[][] newGrid = new int[n][n];

        for (int j = 0; j < n; j++) {
            int pointer = n - 1; // 아래쪽부터 채워나갈 위치
            for (int i = n - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    newGrid[pointer][j] = map[i][j];
                    pointer--;
                }
            }
        }

        return newGrid;
    }

    // 상하좌우로 인접한 칸끼리 값이 같은 (0이 아닌) 쌍의 개수를 셈
    static int countPairs(int[][] map) {
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];

                    if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;

                    if (map[i][j] == map[ni][nj]) {
                        c++;
                    }
                }
            }
        }

        return c / 2; // 각 쌍이 두 번씩 카운트되므로 절반으로 나눔
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] exploded = bomb(i, j, grid);
                int[][] fallen = gravity(exploded);
                int pairs = countPairs(fallen);
                ans = Math.max(ans, pairs);
            }
        }

        System.out.println(ans);
    }
}