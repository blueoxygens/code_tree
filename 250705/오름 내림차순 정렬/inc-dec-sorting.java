import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(arr);
        for (int i = 0; i<n; i++){
            if(i == n-1){
                System.out.println(arr[i]);
            }
            else{
            System.out.print(arr[i]+" ");
            }
        }
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i<n; i++){
            if(i == n-1){
                System.out.println(arr2[i]);
            }
            else{
            System.out.print(arr2[i]+" ");
            }
        }
    }
}