import java.util.*;
public class Main {
    static int n, m;
    static int[][] grid;
    static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};

    static int[] bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        // 테두리 물칸에서 시작 (비용 0)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if (dist[i][j] > 0) {
                        dist[i][j] = 0;
                        q.addFirst(new int[]{i, j});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int r = cur[0], c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                int cost = (grid[nr][nc] == 1) ? 1 : 0;
                int nd = dist[r][c] + cost;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    if (cost == 0) q.addFirst(new int[]{nr, nc});
                    else           q.addLast(new int[]{nr, nc});
                }
            }
        }

        // total = 빙하칸 중 최대 시각, count = 그 시각에 녹는 빙하 개수
        int total = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && dist[i][j] != Integer.MAX_VALUE)
                    total = Math.max(total, dist[i][j]);

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && dist[i][j] == total)
                    count++;

        return new int[]{total, count};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        int[] ans = bfs();
        System.out.println(ans[0] + " " + ans[1]);
    }
}