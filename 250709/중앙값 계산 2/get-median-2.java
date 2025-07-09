import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Please write your code here.
        // 문제를 잘못 이해했다. 입력받을 때마다 있는 중앙값들이네,, que로 해야 하나

        Integer[] iarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        ArrayList <Integer> alist = new ArrayList<Integer>();
        int pivot = 1;
        for (Integer a : iarr){
            alist.add(a);
            if(pivot%2 != 0){
                Collections.sort(alist);
                System.out.print(alist.get((pivot-1)/2) + " ");
            }
            pivot ++;
        }
    }
}