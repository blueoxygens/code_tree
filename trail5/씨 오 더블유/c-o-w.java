import java.util.*;
public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[] str = sc.next().toCharArray();

        int[] l = new int[n];
        if(str[0] == 'C') l[0] = 1;
        int[] r = new int[n];
        if(str[n-1] == 'W') r[n-1] = 1;

        for(int i = 1; i < n; i++){
            if(str[i] == 'C') l[i] = l[i-1] + 1;
            else  l[i] = l[i-1];
            if(str[n-i-1] == 'W') r[n-i-1] = r[n-i] + 1;
            else r[n-i-1] = r[n-i];
        }

        long ans = 0;

        for(int i = 1; i < n-1; i++){
            if(str[i] == 'O') ans += l[i-1] * r[i+1];
        }

        System.out.println(ans);
    }
}