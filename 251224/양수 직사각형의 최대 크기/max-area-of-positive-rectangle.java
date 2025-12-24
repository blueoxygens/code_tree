import java.util.Scanner;
public class Main {

    // static boolean inRange(int x, int y, int w, int h){
        
    // }
    static int[][] grid;
    // static int[] dx = {1,0,-1,0};
    // static int[] dy = {0,1,0,-1};
    static int temp = 0;
    static boolean checkRange(int x, int y, int w, int h){
        for(int i=x; i<x+h; i++){
            for(int j=y; j<y+w; j++){
                if (grid[i][j] < 0){
                    return false;
                }
                // System.out.print(i + " "  + j + "/");
            }
            // System.out.println();
        }
        temp = w*h;
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];

        boolean p = false;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
                if(!p){
                    if(grid[i][j]>0){
                        p = true;
                    }
                }
            }
        // Please write your code here.
        int answer = 0;
        if(p){
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    for(int w=0; w<m-j+1; w++){
                        for(int h=0; h<n-i+1; h++){
                            if(checkRange(i,j,w,h)){
                                answer = Math.max(answer, temp);
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
        System.out.println(answer);
        }
        else{
            System.out.println(-1);
        }
    }
}