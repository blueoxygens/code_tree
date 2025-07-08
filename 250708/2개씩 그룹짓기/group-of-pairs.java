import java.util.Scanner;
import java.util.Arrays;
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
        int max = 0;
        for(int i = 0; i<nums.length/2; i++){
            int temp = nums[i] + nums[nums.length-1-i];
            if(max < temp){
                max = temp;
            }
        }
        System.out.println(max);
    }
}