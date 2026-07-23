import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        long[] cords = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long left = 1, right = cords[n-1] - cords[0] + 1;
        while (left < right) {
            long mid = left + (right - left) / 2;
            int c = 0, i = 0;
            while (i < n) {
                long end = cords[i] + mid - 1;
                while (i < n && cords[i] <= end) i++;
                c++;
            }
            if (c <= k) right = mid;
            else left = mid + 1;
        }
        System.out.println(left);
    }
}