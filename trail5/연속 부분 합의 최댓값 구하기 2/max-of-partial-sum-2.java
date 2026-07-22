import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        // 시간 복잡도 O(n)
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int right = 0; right<n; right++){
            if(sum < 0){
                sum = 0;
            }
            sum += arr[right];
            ans = Math.max(ans,sum);
        }
        System.out.println(ans);
    }
}