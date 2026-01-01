import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, 1, -1, 0};
    static int n, m;
    static int[][] grid;

    static void bfs(int r, int c, int k, boolean[][] visited) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{r, c});
        visited[r][c] = true;

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && grid[nr][nc] > k) {
                        visited[nr][nc] = true;
                        dq.add(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }

        int maxSafeZones = 0;
        int minK = 0;

        for (int k = 1; k < maxHeight; k++) {
            boolean[][] visited = new boolean[n][m];
            int currentSafeZones = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] > k && !visited[i][j]) {
                        bfs(i, j, k, visited);
                        currentSafeZones++;
                    }
                }
            }
            if(maxSafeZones < currentSafeZones){
                minK = k;
            }
            maxSafeZones = Math.max(maxSafeZones, currentSafeZones);
        }
        System.out.println(maxSafeZones!=0?maxSafeZones+ " " + minK:1 + " " + minK);
    }
}