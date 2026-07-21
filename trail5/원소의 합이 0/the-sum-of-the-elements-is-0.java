import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        long[] A = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] B = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] C = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] D = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Map<Long, Integer> ab = new HashMap<>();
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++)
                ab.merge(A[j] + B[k], 1, Integer::sum);

        long ans = 0;
        for (int j = 0; j < n; j++)
            for (int k = 0; k < n; k++)
                ans += ab.getOrDefault(-(C[j] + D[k]), 0);

        System.out.println(ans);
    }
}