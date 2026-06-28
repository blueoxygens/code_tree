import java.util.*;
import java.io.*;

public class Main {

    public static String change(int n, int m) {
        if (n == 0) {
            return "0";
        } else {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int rem = n % m;
                // If remainder is > 9, convert to letter A-Z
                if (rem >= 10) {
                    sb.append((char) (rem - 10 + 'A'));
                } else {
                    sb.append(rem);
                }
                n /= m;
            }
            sb.reverse();
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ab = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String n = br.readLine();

        int num = 0;
        // Horner's Method: shifts the previous value left by base, then adds the new digit
        for (int i = 0; i < n.length(); i++) {
            num = num * ab[0] + Character.getNumericValue(n.charAt(i));
        }

        System.out.println(change(num, ab[1]));
    }
}