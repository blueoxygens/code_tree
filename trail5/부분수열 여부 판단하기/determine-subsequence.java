import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        
        int[] A = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] B = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int i = 0;
        int j = 0;
        boolean flag = false;

        while(i < n){
            while(i < n && A[i] != B[j]){
                i++;
            }

            if(i < n && j == m-1 && A[i] == B[j]) {
                flag = true;
                break;
                }
            if( i< n && A[i] == B[j]) j++;
        }

        System.out.println(flag ? "Yes" : "No");
    }
}