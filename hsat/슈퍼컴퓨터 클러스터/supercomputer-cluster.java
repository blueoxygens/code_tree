import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        long left = Arrays.stream(a).min().getAsLong();
        long right = Arrays.stream(a).max().getAsLong() + (long) Math.sqrt(b) + 2;
        long ans = left;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canAchieve(a, mid, b)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static boolean canAchieve(long[] a, long mid, long budget) {
        long cost = 0;
        for (long v : a) {
            if (v < mid) {
                long d = mid - v;
                cost += d * d;
                if (cost > budget) return false;
            }
        }
        return true;
    }
}