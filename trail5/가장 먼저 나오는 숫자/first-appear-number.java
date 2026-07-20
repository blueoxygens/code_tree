import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        int[] target = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        for(int i : target){
            int lower = 0;
            int higher = n;
            while(lower < higher){
                int mid = lower + (higher-lower) / 2;
                if(nums[mid] < i){
                    lower = mid+1;
                }else{
                    higher = mid;
                }
            }
            // while(nums[lower-1] == i) lower --;
            System.out.println(lower < n && nums[lower] == i ? lower+1 : -1);
        }
    }
}