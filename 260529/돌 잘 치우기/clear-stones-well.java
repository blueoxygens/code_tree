import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

    static int n, k, m;
    static int[][] grid;
    static int[][] starts;
    static int[][] walls;
    static int wallCount;
    static int ans = 0;
    static int[] drs = {1,-1,0,0};
    static int[] dcs = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt() - 1;
            starts[i][1] = sc.nextInt() - 1;
        }

        ArrayList<int[]> wallList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    wallList.add(new int[]{i, j});

        walls = wallList.toArray(new int[0][]);
        wallCount = walls.length;

        int actualM = Math.min(m, wallCount);
        backtracking(0, new boolean[wallCount], 0, actualM);

        System.out.println(ans);
    }

    static void backtracking(int idx, boolean[] selected, int selectedCount, int actualM) {
        if (selectedCount == actualM) {
            ans = Math.max(ans, getCount(selected));
            return;
        }
        if (idx == wallCount) {
            ans = Math.max(ans, getCount(selected));
            return;
        }

        selected[idx] = true;
        backtracking(idx + 1, selected, selectedCount + 1, actualM);
        selected[idx] = false;

        backtracking(idx + 1, selected, selectedCount, actualM);
    }

    static int getCount(boolean[] selected) {
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int[] s : starts) {
            if (!visited[s[0]][s[1]]) {
                visited[s[0]][s[1]] = true;
                q.addLast(new int[]{s[0], s[1]});
            }
        }

        boolean[][] removeSet = new boolean[n][n];
        for (int i = 0; i < wallCount; i++)
            if (selected[i])
                removeSet[walls[i][0]][walls[i][1]] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            count++;

            for (int j = 0; j < 4; j++) {
                int nr = cur[0] + drs[j];
                int nc = cur[1] + dcs[j];

                if (0<=nr && nr<n && 0<=nc && nc<n && !visited[nr][nc]) {
                    if (grid[nr][nc] == 0 || removeSet[nr][nc]) {
                        visited[nr][nc] = true;
                        q.addLast(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
}