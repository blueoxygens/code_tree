import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int start = n-1;
        int ans = 1;
        for (int i = n-2; i>=0; i--){
            if (arr[i] < arr[i+1]){
                ans = Math.max(ans, start - i+1);
            }else{
                start = i;
            }
        }
        System.out.println(ans);
    }
}