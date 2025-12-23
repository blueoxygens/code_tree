import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;

    static int[] dxs = {1, 1, -1, -1};
    static int[] dys = {1, -1, -1, 1};


    private static boolean inRange(int nx, int ny) {
        return 0 <= nx && nx < n && 0 <= ny && ny < n;
    }


    private static int getScore(int x, int y, int w, int h) {
        int[] moveSize = {w, h, w, h};
        int total = 0;
        int currX = x;
        int currY = y;

        for (int i = 0; i < 4; i++) {
            int dx = dxs[i];
            int dy = dys[i];
            int length = moveSize[i];

            for (int j = 0; j < length; j++) {
                currX += dx;
                currY += dy;

                if (!inRange(currX, currY)) {
                    return 0;
                }
                total += grid[currX][currY];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int w = 1; w < n; w++) {
                    for (int h = 1; h < n; h++) {
                        ans = Math.max(ans, getScore(i, j, w, h));
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}