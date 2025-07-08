import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            nums[i] = sc.nextInt();
        }
        // Please write your code here.
        // 정렬 후 가장 큰거, 가장 작은거 매칭
        Arrays.sort(nums);
        //System.out.println(nums);
        // Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // ArrayDeque<Integer> dq = new ArrayDeque<Integer>(Arrays.asList(arr));
        int ans = 0;
        for(int i = nums.length/n-1; i<nums.length; i+=n){
            //System.out.println(i);
            ans+=nums[i];
        }
        System.out.println(ans);
    }
}