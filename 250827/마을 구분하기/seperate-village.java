import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static ArrayList<ArrayList<String>> vilages = new ArrayList<>();
    static Set<String>set = new HashSet<>();
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static void DFS(int i, int j, int[][] grid, int n){
        if(grid[i][j] == 1 && !set.contains(i+","+j)){
            vilages.add(new ArrayList<>());
            vilages.get(vilages.size()-1).add(i+","+j);
            set.add(i+","+j);
            for(int k = 0; k < 4; k++){
                if(i+dy[k] >=0 && i+dy[k]<n && j+dx[k]>=0 && j+dx[k]<n){
                    DFSInVil(i+dy[k],j+dx[k],grid,n);
                }
            }
        }
        return;
    }
    static void DFSInVil(int i, int j, int[][] grid, int n){
        if(grid[i][j] == 1 && !set.contains(i+","+j)){
            vilages.get(vilages.size()-1).add(i+","+j);
            set.add(i+","+j);
            for(int k = 0; k < 4; k++){
                if(i+dy[k] >=0 && i+dy[k]<n && j+dx[k]>=0 && j+dx[k]<n){
                    DFSInVil(i+dy[k],j+dx[k],grid,n);
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        // Please write your code here.
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                DFS(i,j,grid, n);
            }
        }
        System.out.println(vilages.size());
        int[] sizeArr = vilages.stream()
                                .mapToInt(vilage -> vilage.size())
                                .toArray();
        Arrays.sort(sizeArr);
        Arrays.stream(sizeArr).forEach(System.out::println);
    }
}