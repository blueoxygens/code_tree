import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] cords = new int[n];
        for (int i = 0; i < n; i++) cords[i] = sc.nextInt();
        Arrays.sort(cords);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int u = sc.nextInt();

            int down = lowerBound(cords, l);   // l 이상 첫 인덱스
            int up = upperBound(cords, u) - 1; // u 이하 마지막 인덱스

            if (down > up) sb.append(0).append('\n');
            else sb.append(up - down + 1).append('\n');
        }
        System.out.print(sb);
    }

    static int lowerBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    static int upperBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}