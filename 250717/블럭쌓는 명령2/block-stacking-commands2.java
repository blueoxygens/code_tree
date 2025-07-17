import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int [] arr = new int [N];
        for (int i : arr){
            i = 0;
        }
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            for (int j = A-1; j<B; j++){
                arr[j] += 1;
            }
        }
        // Please write your code here.
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println(max);
    }
}