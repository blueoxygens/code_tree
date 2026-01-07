import java.util.*;


public class Main {
    static int[] dirr = {-1,0,1,0};
    static int[] dirc = {0,-1,0,1};
    static int[][] grid;

    static boolean check(int r, int c, int tr, int tc){
        if(grid[r][c] > grid[tr][tc]){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        // Please write your code here.

        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new int[] {r-1,c-1});

        int ansr = r;
        int ansc = c;

        while(!q.isEmpty()){
            int[] temp = q.pollFirst();
            // System.out.println(temp[0] + " " + temp[1]);
            int max = Integer.MIN_VALUE;
            int tr = 0;
            int tc = 0;

            if(k<=0){
                ansr = temp[0];
                ansc = temp[1];
                break;
            }

            for(int i = 0; i<4; i++){
                int newr = temp[0] + dirr[i];
                int newc = temp[1] + dirc[i];

                if(0<=newr && newr<n && 0<=newc && newc<n ){
                    if(check(r-1, c-1, newr, newc) && !visited[newr][newc] && grid[newr][newc] > max){
                        // System.out.println("q in : "+newr + " " + newc);
                        max = grid[newr][newc];
                        tr = newr;
                        tc = newc;
                    }
                }
            }

            if(max > Integer.MIN_VALUE){
                q.add(new int[] {tr, tc});
                visited[tr][tc] = true;
                k--;
            }
            else{
                ansr = temp[0]+1;
                ansc = temp[1]+1;
                break;
            }
        }

    System.out.println(ansr + " " + ansc);

    }
}