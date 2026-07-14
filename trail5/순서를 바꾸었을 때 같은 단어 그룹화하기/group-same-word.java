import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.next();
        }

        Map<String, Integer> hash = new HashMap<>();

        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            hash.merge(key, 1, Integer::sum);
        }

        System.out.println(hash.values().stream().max(Integer::compare).get());
    }
}