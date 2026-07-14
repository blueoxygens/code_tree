import java.util.*;
public class Main {

    static int n;
    static int m;
    static int[][] grid;

    static int[][] dir = {
        {1,0},
        {-1,0},
        {0,1},
        {0,-1}
    };


    static boolean bfs(){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        q.addLast(new int[] {0,0});
        visited[0][0] = 1;

        while(!q.isEmpty()){
            int[] cord = q.pollFirst();

            if(cord[0] == n-1 && cord[1] == m-1){
                return true;
            }

            for(int i =0; i < 4; i++){
                int nr = cord[0] + dir[i][0];
                int nc = cord[1] + dir[i][1];

                if(nr >=0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && visited[nr][nc] != 1){
                    q.addLast(new int[] {nr,nc});
                    visited[nr][nc] = 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        if(bfs()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}