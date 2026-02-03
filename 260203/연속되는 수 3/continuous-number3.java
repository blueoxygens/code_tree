import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // Please write your code here.
        Arrays.sort(arr);
        // Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
        int start = 0;
        int ans = 1;
        for(int d = 1; d < n; d++){
            if(arr[start] * arr[d] > 0){
                ans = Math.max(ans, d==0 ? d-start+1:d-start);
            }else{
                ans = Math.max(ans, d==0 ? d-start+1:d-start);
                start = d;
            }
        }
        System.out.println(ans);
    }
}