import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[] cords = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) cords[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cords);

        // 좌표 -> 정렬 후 순위(1-based) 매핑은 굳이 Map 없이 이진탐색으로 처리
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            int down = lowerBound(cords, l);   // l 이상 첫 인덱스
            int up = upperBound(cords, u) - 1; // u 이하 마지막 인덱스

            if (down > up) sb.append(0).append('\n');
            else sb.append(up - down + 1).append('\n');
        }
        System.out.print(sb);
    }

    // 첫 번째 원소 >= key
    static int lowerBound(int[] a, int key) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    // 첫 번째 원소 > key
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