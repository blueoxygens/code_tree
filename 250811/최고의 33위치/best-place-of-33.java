import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int max = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < n-2; j++){
                int temp = 0;
                for(int k = i; k< i+3; k++){
                    for(int h = j; h < j+3; h++){
                        if(grid[k][h] == 1){
                            temp += 1;
                        }
                    }
                }
                if (temp > max){
                    max = temp;
                }
            }
        }
        System.out.println(max);
    }
}