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
        int count = 0;
        int temp = -1;
        int ans = 0;
        for(int i : arr){
            if(temp != i){
                ans = Math.max(ans, count);
                count = 1;
                temp = i;
            }
            else{
                count += 1;
                }
        }
        System.out.println(ans);
    }
}