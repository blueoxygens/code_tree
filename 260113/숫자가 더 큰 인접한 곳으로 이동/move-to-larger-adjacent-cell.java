import java.util.*;
public class Main {
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        grid = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean [n+1][n+1];
        q.add(new int[] {r,c});
        visited[r][c] = true;
        System.out.print(grid[r][c]+" ");

        while(!q.isEmpty()){
            int[] t = q.pollFirst();
            for(int[] v : d){
                int nr = t[0] + v[0];
                int nc = t[1] + v[1];
                if(0<=nr && nr<n && 0<=nc && nc<n && !visited[nr][nc] && (grid[t[0]][t[1]] < grid[nr][nc])){
                    System.out.print(grid[nr][nc]+" ");
                    q.add(new int[] {nr,nc});
                    visited[nr][nc] = true;
                    break;
                }
            }
        }
    }
}