import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        int[] arr = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int left = 0;
        boolean[] count = new boolean[100001];
        int ans = 0;
        for (int right = 0; right < n; right++) {
            while (count[arr[right]]) {
                count[arr[left]] = false;
                left++;
            }
            count[arr[right]] = true;
            ans = Math.max(ans, right - left + 1);
        }
        System.out.println(ans);
                
    }
}