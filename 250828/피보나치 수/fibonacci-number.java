import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int[] memo = new int[46];
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3; i<=n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.println(memo[n]);
    }
}