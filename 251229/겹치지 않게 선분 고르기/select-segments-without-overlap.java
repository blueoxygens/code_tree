import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        // Please write your code here.
        int max = 0;
        for(int i = 0; i<n; i++){
            int [] check = new int[1001];
            int count = 1;
            for(int j = segments[i][0]; j<=segments[i][1]; j++){
                check[j] = 1;
            }
            for(int j= i+1; j<n; j++){
                boolean flag = false;
                for(int k = segments[j][0]; k<=segments[j][1]; k++){
                    if (check[k] == 1){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    continue;
                } else{
                    count += 1;
                    for(int k = segments[j][0]; k<=segments[j][1]; k++){
                        check[k] = 1;
                    }
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}