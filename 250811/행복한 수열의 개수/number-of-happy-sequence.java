import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {

    public static boolean isContinuous(int[][] grid, int row, int col, int m, String dir) {
        // dir: "r" = row 검사, "c" = column 검사
        if (dir.equals("r")) { // 가로 방향
            for (int k = col; k < col + m - 1; k++) {
                if (grid[row][k] != grid[row][k + 1]) {
                    return false;
                }
            }
        } else { // 세로 방향
            for (int k = row; k < row + m - 1; k++) {
                if (grid[k][col] != grid[k + 1][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int count = 0;
        Set<Integer> rowSet = new HashSet<>(); // 행 중복 방지
        Set<Integer> colSet = new HashSet<>(); // 열 중복 방지

        // 가로 방향 검사
        for (int i = 0; i < n; i++) { // 행
            for (int j = 0; j <= n - m; j++) { // 열 시작점
                if (!rowSet.contains(i) && isContinuous(grid, i, j, m, "r")) {
                    rowSet.add(i);
                    count++;
                    break; // 해당 행은 이미 카운트했으니 다음 행으로
                }
            }
        }

        // 세로 방향 검사
        for (int j = 0; j < n; j++) { // 열
            for (int i = 0; i <= n - m; i++) { // 행 시작점
                if (!colSet.contains(j) && isContinuous(grid, i, j, m, "c")) {
                    colSet.add(j);
                    count++;
                    break; // 해당 열은 이미 카운트했으니 다음 열로
                }
            }
        }

        System.out.println(count);
    }
}
