import java.util.*;

public class Main {
    static int ans = 0;
    static int[] nums;
    static int n, m, k;

    public static void backtracking(ArrayList<Integer> arr) {
        if (arr.size() == n) {
            int[] p = new int[k + 1];
            int temp = 0; 

            for (int i = 0; i < n; i++) {
                p[arr.get(i)] += nums[i];
            }

            for (int i = 1; i <= k; i++) {
                if (p[i] >= m-1) { 
                    temp += 1;
                }
            }
            ans = Math.max(ans, temp);
            return;
        }

        for (int i = 1; i <= k; i++) {
            arr.add(i);
            backtracking(arr);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        backtracking(new ArrayList<>());
        System.out.println(ans);
    }
}