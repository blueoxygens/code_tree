import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main {
    
    static int [] dy = {1,-1,0,0};
    static int [] dx = {0,0,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.
        Set<String> visited = new HashSet<>();
        // 방문 기록
        ArrayDeque<String> queue = new ArrayDeque<>();
        // 큐
        boolean flag = false;
        queue.addLast(0+","+0);

        while(!queue.isEmpty()){
            String target = queue.pollFirst();
            int[] cord = Arrays.stream(target.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            
            for(int i = 0; i < 4; i++){
                int new_y = cord[0]+dy[i];
                int new_x = cord[1]+dx[i];

                if(new_y >= 0 && new_y < m && new_x >=0 && new_x < n && grid[new_y][new_x] == 1 && !visited.contains(new_y+","+new_x)){
                    queue.addLast(new_y+","+new_x);
                }
            }

            if(cord[0] == m-1 && cord[1] == n-1){
                flag = true;
            }
            visited.add(target);
        }
        System.out.println(flag?1:0);
    }
}